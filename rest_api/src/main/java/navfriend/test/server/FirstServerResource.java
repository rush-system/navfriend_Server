package navfriend.test.server;


import org.restlet.*;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import static java.lang.System.out;

public class FirstServerResource extends ServerResource {

		public static void main(String[] args) throws Exception {
			new Server(Protocol.HTTP, 8182, FirstServerResource.class).start();
		}

		@Get
		public String toString() {
			return "Ciao Hola Bonjour Hello Ahoj";
		}
}

