import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * Created by Lorenzo on 08/04/2015.
 */
public class testmain {
	// TODO controllare per le form - http://restlet.com/technical-resources/restlet-framework/guide/2.3/core/data/parameters
	// TODO controllare per le API - http://restlet.com/technical-resources/restlet-framework/guide/2.3/core/resource/overview
	public static final void main(String args[]){
		try {
			new ClientResource("http://www.google.com").get().write(System.out);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
