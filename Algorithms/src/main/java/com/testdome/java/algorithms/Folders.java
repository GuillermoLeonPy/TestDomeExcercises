package com.testdome.java.algorithms;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Folders {

  public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
  	  List<String> list = new ArrayList<>();
  	  findFolders(parseString(xml).getChildNodes(), startingLetter, list);
  	  return list;
  }
  
  private static void findFolders(NodeList nodeList, char startingLetter, Collection<String> list){	  
	  for(int i = 0; i < nodeList.getLength(); i++) {
		  Node node = nodeList.item(i);
		  if(node.hasChildNodes()) {
			  findFolders(node.getChildNodes(), startingLetter, list) ;
		  }
		  
		  Node attribute = node.getAttributes().item(0);
		  String folderName = attribute.getNodeValue();
		  if(folderName.startsWith(""+startingLetter)) {
			 list.add(folderName);  
		  }		  
	  }
  }
  
  private static Document parseString(String xml) throws ParserConfigurationException, SAXException, IOException {
	  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	  dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
	  
	  DocumentBuilder builder = dbf.newDocumentBuilder();
	  Document doc = builder.parse(new InputSource(new StringReader(xml)));
	  return doc;	  
  }
  
  public static void main(String[] args) throws Exception {
      String xml =
              "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
              "<folder name=\"c\">" +
                  "<folder name=\"program files\">" +
                      "<folder name=\"uninstall information\" />" +
                  "</folder>" +
                  "<folder name=\"users\" />" +
              "</folder>";

      Collection<String> names = folderNames(xml, 'u');
      for(String name: names)
          System.out.println(name);
  }

}
