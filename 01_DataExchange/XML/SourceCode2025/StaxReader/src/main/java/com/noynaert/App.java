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
        try {
            //Set up the output file
            outputFile = new PrintWriter("people.md");
            outputFile.println("|ID|Name|Email|Phone Number<br>Count|");
            outputFile.println("|:---:|:----|:-----|:---------:|");

            //Open the StAX parser
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(new File("people.xml")));
            BriefPerson person = null;

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                //System.out.println(event);
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
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
                    person = null;
                }

            }

            outputFile.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


        System.out.println("Done");
    }
}
