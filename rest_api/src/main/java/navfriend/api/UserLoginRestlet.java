package navfriend.api;

import com.google.gson.Gson;
import navfriend.api.data.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.InputRepresentation;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


import java.io.IOException;


/**
 * Created by Lorenzo on 11/04/2015.
 */
public class UserLoginRestlet extends ServerResource{

	@Post("json")
	public void Login(Representation entity) throws IOException, JSONException {

		JsonRepresentation jsonR = new JsonRepresentation(entity);
		JSONObject jsonObject = jsonR.getJsonObject();
		Gson gson = new Gson();

		User user = gson.fromJson(jsonObject.toString(), User.class);

		System.out.println(user.toString());
		System.out.println(jsonObject.toString());

//		System.out.println(entity.getEmail() + "" + entity.getPwd());

		System.out.println(">> " + entity.getClass());
/*
		try {
			JsonRepresentation jsonRep=(JsonRepresentation) entity;
			JSONObject obj= jsonRep.getJsonObject();
			System.out.println("Got " + obj);
		}catch(JSONException ex){
			ex.printStackTrace();
		}
*/
	}
}
