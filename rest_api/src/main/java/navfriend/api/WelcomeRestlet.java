package navfriend.api;

import navfriend.api.util.XmlBuilder;
import navfriend.api.util.XmlHelper;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.io.StringWriter;

public class WelcomeRestlet extends Restlet {

	XmlHelper xmlHelper;

	public WelcomeRestlet(){
		xmlHelper = new XmlHelper();
	}


	@Override
	public void handle(Request request, Response response){


		if(request.getMethod() == Method.GET){
			response.setEntity("welcome in NavAPI", MediaType.TEXT_PLAIN);
			try {
				/*DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.newDocument();

				Element root = doc.createElement("Navfriend");
				doc.appendChild(root);

				Element name = doc.createElement("Name");
				name.appendChild(doc.createTextNode("Lorenzo"));
				root.appendChild(name);


				String xmlFile = xmlHelper.xmlToString(doc);
				*/

				XmlBuilder builder = new XmlBuilder("Navfriend");

				builder.addElement(builder.getElement("Navfriend"),"Name");
				builder.addTextElement(builder.getElement("Name"), "Lorenzo");

				builder.addElement(builder.getElement("Name"), "Età");
				builder.addElement(builder.getElement("Età"), "Anno");
				builder.addElement(builder.getElement("Età"), "Giorno");
				builder.addElement(builder.getElement("Età"), "Mese");


				String xmlFile = builder.toString();

				if(xmlFile.compareTo("XML ERROR")==0){
					response.setEntity("SERVER PROCESSING ERROR", MediaType.TEXT_PLAIN);
				}else{
					response.setEntity(xmlFile, MediaType.TEXT_XML);
				}




			}catch(ParserConfigurationException ex){
				ex.printStackTrace();
			}
		}

	}



}
