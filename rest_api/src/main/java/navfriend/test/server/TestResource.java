package navfriend.test.server;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by Lorenzo on 08/04/2015.
 */
public class TestResource extends ServerResource {

	@Get
	public String toString() {
		return "hello, world";
	}

}
