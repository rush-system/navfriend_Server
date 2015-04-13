package navfriend.api;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by Lorenzo on 11/04/2015.
 */
public class HttpApiRouter extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router();



		router.attach("/", new WelcomeRestlet());
		router.attach("/login", UserLoginRestlet.class);



		return router;
	}
}
