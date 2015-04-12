package navfriend.api;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

/**
 * Created by Lorenzo on 11/04/2015.
 */
public class UserRestlet extends Restlet {

	@Override
	public void handle(Request request, Response response) {

		String username = (String)request.getAttributes().get("user");
		response.setEntity("welcome " + username, MediaType.TEXT_PLAIN);

	}
}
