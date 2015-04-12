package navfriend.api.util;

import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;

public class XmlHelper {

	public String xmlToString(Document doc){

		try {
			//inizializza i trasformatori
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			//creo uno StringWriter per immagazzinare lo stream result
			StringWriter writer = new StringWriter();

			//processo il file xml
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);

			//trasformo lo stream in stringa
			StringBuffer buffer = writer.getBuffer();
			String output = buffer.toString();

			return output;
		}catch(TransformerConfigurationException ex){
			ex.printStackTrace();
		}catch(TransformerException ex){
			ex.printStackTrace();
		}

		return "XML ERROR";

	}

}
