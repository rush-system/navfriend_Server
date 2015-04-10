package navfriend.test.client;

import org.restlet.resource.ClientResource;

import java.util.Date;

/**
 * Created by Lorenzo on 08/04/2015.
 */
public class testmain {


	// TODO controllare per le form - http://restlet.com/technical-resources/restlet-framework/guide/2.3/core/data/parameters
	// TODO controllare per le API - http://restlet.com/technical-resources/restlet-framework/guide/2.3/core/resource/overview

	static final String URL = "http://localhost:8182/";

	public static final void main(String args[]) throws Exception{

		while(true) {
			System.out.println(new Date() + ": Sending the first call...");
			new ClientResource(URL).get().write(System.out);
			System.out.println("");
		}

	}
}
