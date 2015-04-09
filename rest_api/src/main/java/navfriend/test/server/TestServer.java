package navfriend.test.server;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by Lorenzo on 08/04/2015.
 */
public class TestServer extends ServerResource{

	public static void main(String[] args) throws Exception {
		// Create the HTTP server and listen on port 8182
		new Server(Protocol.HTTP, 8182, TestResource.class).start();
	}

	@Get
	public String toString() {
		return "hello, world";
	}
}
