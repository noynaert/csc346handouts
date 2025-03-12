package com.noynaert;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

/**
 * Illustrates reading large XML files using StAX
 * <p>
 * The program reads the people.xml file and outputs it to people.md
 *
 * @author J. Evan Noynaert
 * @since March, 2025
 */
public class App {
    public static PrintWriter outputFile;

    public static void main(String[] args) {
        int count = 0;
        try {
            String inputFileName = "people.xml";
            inputFileName = "/home/noynaert/classes/346/homework07/people.xml"; //large file

            //Set up the output file
            outputFile = new PrintWriter("people.md");
            outputFile.println("|ID|Name|Email|Phone Number<br>Count|");
            outputFile.println("|:---:|:----|:-----|:---------:|");

            //Open the StAX parser

                /*
                The Wikipedia file is too large for one of the security limits.
                I found the solution by digging grough the documentation at
                https://docs.oracle.com/en/java/javase/23/security/java-api-xml-processing-jaxp-security-guide.html#GUID-6E76FE41-A8C5-4F56-AB46-83A89B1E904A

                To disable the limit, put the following line BEFORE you instantiate the XMLInputFactory
                            System.setProperty("jdk.xml.totalEntitySizeLimit","0");

             */
            System.setProperty("jdk.xml.totalEntitySizeLimit","0");
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(new File(inputFileName)));
            BriefPerson person = null;

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                //System.out.println(event);
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    //This is the old code that used if statements instead of switch
//                    if(startElement.getName().getLocalPart().equals("person")){
//                        String id = startElement.getAttributeByName(new QName("id")).getValue();
//                        System.out.println(id);
//                    }
//                    if(startElement.getName().getLocalPart().equals("middle")){
//                        String middleName = reader.getElementText();
//                        System.out.println(middleName);
//                    }

                    String elementName = startElement.getName().getLocalPart();

                    switch (elementName) {
                        case "person":
                            person = new BriefPerson();
                            String id = startElement.getAttributeByName(new QName("id")).getValue();
                            person.setId(id);
                            break;
                        case "middle":
                            String middleName = reader.getElementText();
                            person.setMiddleName(middleName);
                            break;
                        case "first":
                            String firstName = reader.getElementText();
                            person.setFirstName(firstName);
                            break;
                        case "last":
                            String lastName = reader.getElementText();
                            person.setLastName(lastName);
                            break;
                        case "email":
                            String email = reader.getElementText();
                            person.setEmail(email);
                            break;
                        case "phone":
                            String phoneNumber = reader.getElementText();
                            person.addPhoneNumber(phoneNumber);
                            break;
                        default:
                    }
                }
                if (event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("person")) {
                    outputFile.println(person.toString());

                    count++;
                    //Print out every 100,000 records
                    if(count % 100000 == 0)
                        System.out.println(person);
                    person = null;
                }

            }

            outputFile.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.printf("\nRecords processed: %,d\n",count);
        System.out.println("Done");
    }
}
