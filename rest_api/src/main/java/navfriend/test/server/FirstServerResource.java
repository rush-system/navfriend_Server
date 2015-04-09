package navfriend.test.server;


import org.restlet.*;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import static java.lang.System.out;

public class FirstServerResource{


	public static void main(String[]args) throws Exception {
		Restlet restlet = new Restlet() {
			@Override
			public void handle(Request request, Response response) {
				response.setEntity("Hello, Java RESTafarians!", MediaType.TEXT_PLAIN);
			}
		};

		// Avoid conflicts with other Java containers listening on 8080!
		new Server(Protocol.HTTP, 8182, restlet).start();
	}

}