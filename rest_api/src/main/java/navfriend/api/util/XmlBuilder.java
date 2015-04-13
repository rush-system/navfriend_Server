package navfriend.api.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class XmlBuilder {

	XmlHelper helper;
	List<Element> elementList;
	Document doc;

	public XmlBuilder(String name) throws ParserConfigurationException{
		helper = new XmlHelper();
		elementList = new ArrayList<Element>();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.newDocument();

		elementList.add(doc.createElement(name));
		doc.appendChild(elementList.get(0));
	}

	public void addElement(Element elem, String element){
		elementList.add(doc.createElement(element));
		elem.appendChild(getElement(element));
	}

	public void addTextElement(Element element, String stringa){
		element.appendChild(doc.createTextNode(stringa));
	}

	public Element getElement(String name){
		for(Element elem : elementList){
			if(elem.getNodeName().compareTo(name)==0)
				return elem;
		}
		return null;
	}

	public String toString(){
		return helper.xmlToString(doc);
	}
}