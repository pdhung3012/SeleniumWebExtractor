package util;

import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLUtil {

	public static boolean parseAndReplaceProjectNameFile(String inputPath,String outputPath,String newName)  {
	    boolean result=false;
	    try{
	    	File fXmlFile = new File(inputPath);
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);
	    			
	    	//optional, but recommended
	    	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    	doc.getDocumentElement().normalize();

	    	
	    			
	    	
		    
		    // Do something with the document here.
//		    System.out.println(FileIO.readStringFromFile(inputPath));
//		    System.out.println(doc);
//		    NodeList list=doc.getElementsByTagName("projectDescription");
		    Element firstElement=doc.getDocumentElement();
		    Element nameProject=(Element) firstElement.getElementsByTagName("name").item(0);
//		    System.out.println("Root element :" + nameProject.getTextContent());
		    nameProject.setTextContent(newName);
		    
//		    save to file
		    DOMSource source = new DOMSource(doc);
		    FileWriter writer = new FileWriter(new File(outputPath));
		    StreamResult resultOut = new StreamResult(writer);

		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    transformer.transform(source, resultOut);		    
		    result=true;
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
