package navfriend.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.Map;

/**
 * Created by Lorenzo on 11/04/2015.
 */
public class UserLoginRestlet extends ServerResource{

	@Post("json")
	public void Login(Representation entity){
		try {
			JsonRepresentation jsonRep=(JsonRepresentation) entity;
			JSONObject obj= jsonRep.getJsonObject();
			System.out.println("Got " + obj);
		}catch(JSONException ex){
			ex.printStackTrace();
		}
	}
}
