package navfriend.test.server;


import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;


public class FirstServerResource extends ServerResource {

	public static void main(String[] args) throws Exception {

		Restlet rest = new Restlet() {
			@Override
			public void handle(Request request, Response response) {

				response.setEntity("<html><head><title>Welcome</title></head><body background=red></body></html>", MediaType.TEXT_HTML);

			}
		};

		new Server(Protocol.HTTP, 8182, /*FirstServerResource.class*/ rest).start();
	}

	@Get
	public String toString() {
		return "Ciao Hola Bonjour Hello Ahoj";
	}

}


