package com.noynaert.sqlCredentials;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * This class returns the user name, password, host name, and password hint from
 * an XML file.  A sample XML file would be like the following.  Note that
 * "port" is not accessed, and the hint for a password is optional.
 * <p>
 * <?xml version="1.0"?>
 * <credentials>
 * <user>csc</user>
 * <password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">😈湯🦊🚴</password>
 * <host>woz.cs.missouriwestern.edu</host>
 * <port>33006</port> <!--This isn't the right port, by the way -->
 * </credentials>
 *
 * If a field is not found it is left as null.
 * This class is immutable.
 */

public class SqlCredentials {
    private final String fileName;
    private final String user;
    private final String password;
    private final String host;
    private final String passwordHint;

    public SqlCredentials(String fileName) {
        TmpCreds creds = new TmpCreds(fileName);

        this.fileName = fileName;
        this.user = creds.user;
        this.password = creds.password;
        this.passwordHint = creds.passwordHint;
        this.host = creds.host;

    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public String getHost() {
        return host;
    }

    public String getPasswordHint() {

        return passwordHint;
    }

    /**
     * @return user, host and the password hint are formatted as a block of text.
     */
    @Override
    public String toString() {
        String s = String.format("\n\tFile Name: %s\n\tUser: %s\n\tHost: %s\n\tPassword Hint: %s\n\n", fileName, user, host, getPasswordHint());
        return s;
    }

    /**
     * This class is just to offload the actual reading of the XML file
     * from the main constructor class
     */

    private class TmpCreds {
        /* Fields are left as null if not found. */
        protected String user = null;
        protected String host = null;
        protected String password = null;
        protected String passwordHint = null;

        public TmpCreds(String fileName) {

            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dbf.newDocumentBuilder();

                Document doc = builder.parse(new File(fileName));
                doc.getDocumentElement().normalize();

                Element root = doc.getDocumentElement();
                NodeList nodes = root.getChildNodes();

                //Get the user
                NodeList users = root.getElementsByTagName("user");
                this.user = (users.getLength()>0)?users.item(0).getTextContent():null;

                //Get the host
                NodeList hosts = root.getElementsByTagName("host");
                this.host = (hosts.getLength()>0)?hosts.item(0).getTextContent():null;

                //Get the password and the hint, if they exist
                NodeList passwords = root.getElementsByTagName("password");
                if(passwords.getLength()>0) {
                    this.password = passwords.item(0).getTextContent();
                    var hintNodes = passwords.item(0).getAttributes();
                    this.passwordHint = (hintNodes.getLength() > 0) ? hintNodes.item(0).getTextContent() : null;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}

