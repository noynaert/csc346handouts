package com.noynaert;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParserApp {
    public static void main(String[] args) {
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("Library.xml"));

        NodeList bookList = document.getElementsByTagName("book");
        int n = bookList.getLength();
        System.out.println("Found " + n + " books");

        for(int i = 0; i < n; i++) {
            Node book = bookList.item(i);
            String id = "?id";
            String author = "?author";
            String title = "?title";
            id = book.getAttributes().getNamedItem("id").getNodeValue();
            NodeList bookFields = book.getChildNodes();
            for(int j = 0; j < bookFields.getLength(); j++) {
                Node field = bookFields.item(j);
                if(field.getNodeName().equals("author")) {
                    author = field.getTextContent();
                } else if(field.getNodeName().equals("title")) {
                    title = field.getTextContent();
                }
            }
            System.out.println("Book " + id + ": " + author + ", " + title);
        }

        System.out.println("Done");
    }catch(Exception e){
        System.err.println(e.getMessage());
        e.printStackTrace();}
    }
}
