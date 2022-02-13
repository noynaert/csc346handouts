import java.io.File;

/**
 * App is a driver class for the credentials program.
 *
 * It takes the name of the XML file containing credentials.
 * A sample XML file is shown below:
 *
 * <?xml version="1.0"?>
 * <credentials>
 *     <user>csc</user>
 *     <password xhint="room where woz is located It definitily is not '!😈湯🦊🚴'">😈湯🦊🚴</password>
 *     <host>woz.cs.missouriwestern.edu</host>
 *     <port>3306</port>
 * </credentials>
 *
 * @author: YOUR NAME
 * @since: MONTH YEAR program is started
 */

public class App {
    public static void main(String[] args){

        String fileName = getFileName(args);

        //See if the file exists.  If it does, get the credentials.
        //Abort if the file does not exist.

        if(new File(fileName).exists()){
            System.out.printf("The file \"%s\" exists.\n",fileName);

        }else{
            System.err.printf("The file \"%s\" does not exist.  Aborting.\n",fileName);
        }

        System.out.println("\nDone!");
    }

    /**
     *   Gets the name of the file name from args[0].
     *   If no filee name is returned, then use the default name sql.xml;
     */

    private static String getFileName(String[] args) {
        String fileName = "sql.xml";
        if (args.length >= 1){
            fileName = args[0];
        }
        return fileName;
    }
}
