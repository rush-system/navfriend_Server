package navfriend.test.client;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import static java.lang.System.out;

/**
 * Created by Lorenzo on 08/04/2015.
 */
public class testmain {
	// TODO controllare per le form - http://restlet.com/technical-resources/restlet-framework/guide/2.3/core/data/parameters
	// TODO controllare per le API - http://restlet.com/technical-resources/restlet-framework/guide/2.3/core/resource/overview
	public static final void main(String args[]) throws Exception{
		try {

			Client c = new Client(Context.getCurrent(), Protocol.HTTP);
			c.start();

			Request request = new Request();
			Reference ref = new Reference(Protocol.HTTP, "127.0.0.1", 8182);


			request.setMethod(Method.GET);
			request.setLoggable(true);
			request.setResourceRef(ref);


			Response response = new Response(request);
			request.commit(response);
			//response = c.handle(request);

			out.println(response);

			response.getEntity().write(System.out);



		//	out.println(response.getEntity().getText());


		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
