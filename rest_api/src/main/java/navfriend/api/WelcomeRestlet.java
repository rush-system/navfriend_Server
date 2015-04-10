package navfriend.api;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Lorenzo on 10/04/2015.
 */
public class WelcomeRestlet extends Restlet {

	@Override
	public void handle(Request request, Response response) {


		if(request.getMethod() == Method.GET){
			Calendar cal = new GregorianCalendar();
			response.setEntity("welcome in NavAPI", MediaType.TEXT_PLAIN);

			response.setStatus(Status.SUCCESS_OK);

		}

	}
}
