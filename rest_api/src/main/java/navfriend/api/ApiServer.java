package navfriend.api;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

/**
 * Created by Lorenzo on 10/04/2015.
 */
public class ApiServer{

	private static int httpApiPort = 8182;


	public static final void main(String args[]) throws Exception{
		Component comp = new Component();

		Server httpApiServer = new Server(Protocol.HTTP, httpApiPort);
		httpApiServer.setName("NavAPI Server");
		httpApiServer.setDescription("Http API server for the application Navfriend");


		comp.getServers().add(httpApiServer);
		comp.getDefaultHost().attach("/", new WelcomeRestlet());

		comp.start();
	}
}
