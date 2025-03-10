package com.noynaert;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Demonstrates writing XML from data
 *
 * @since March, 2025
 * @author J. Evan Noynaert
 */
public class App 
{
    private static Document document = null;
    public static void main( String[] args )
    {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Create the document
            document = builder.newDocument();

            Element root = document.createElement("library");
            document.appendChild(root);

            Element bookElement;
            bookElement = makeBookElement(12334, "Brandon Sanderson", "The Way of Kings");
            root.appendChild(bookElement);

            bookElement = makeBookElement(2345, "Robert Jordan", "The Eye of the World");
            root.appendChild(bookElement);

            bookElement = makeBookElement(5432, "Isaac Asimov", "I, Robot");
            root.appendChild(bookElement);

            /// ///////////////////////////////////////////////
            //Transform document to an XML document
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            int indent = 2;
            transformer.setParameter("indent-number", indent);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");


            //Determine and create the output
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("Library.xml");
            transformer.transform(source, result);


        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println( "Done" );
    }
    private static Element makeBookElement(int id, String author, String title){
        Element bookElement = document.createElement("book");
        bookElement.setAttribute("id", Integer.toString(id));

        Element authorElement = document.createElement("author");
        authorElement.setTextContent(author);
        bookElement.appendChild(authorElement);

        Element titleElement = document.createElement("title");
        titleElement.setTextContent(title);
        bookElement.appendChild(titleElement);
        return bookElement;
    }
}
