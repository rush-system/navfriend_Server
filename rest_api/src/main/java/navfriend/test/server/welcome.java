package navfriend.test.server;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by Lorenzo on 09/04/2015.
 */

public class welcome extends ServerResource{

	@Get
	public String toString(){
		return "hello";
	}



}

