package navfriend.api;
import com.google.gson.Gson;
import javafx.animation.Animation;
import javafx.application.Preloader;
import navfriend.api.data.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.InputRepresentation;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


import javax.ws.rs.core.Response;
import java.sql.*;
import java.io.IOException;



public class UserLoginRestlet extends ServerResource{

	@Post("json")
	public Representation Login(Representation entity) throws IOException, JSONException, SQLException {

		JsonRepresentation jsonR = new JsonRepresentation(entity);
		JSONObject jsonObject = jsonR.getJsonObject();
		Gson gson = new Gson();

		User user = gson.fromJson(jsonObject.toString(), User.class);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://192.168.201.116:3306/navfriend", "navfriend", "navfriend");

			statement = connection.prepareStatement("SELECT COUNT(*) AS exist FROM utente WHERE email=?");
			statement.setString(1, user.getEmail());


			ResultSet res = statement.executeQuery();
			if(res.next()) {
				if (res.getInt("exist") == 1) {
					statement = connection.prepareStatement("SELECT COUNT(*) AS exist FROM utente WHERE email=? AND  password=?");
					statement.setString(1, user.getEmail());
					statement.setString(2, user.getPwd());
					res = statement.executeQuery();
					if(res.next()) {
						if (res.getInt("exist") == 1) {
							return new StringRepresentation("{auth:si}", MediaType.APPLICATION_JSON);
						} else {
							return new StringRepresentation("{auth:no}", MediaType.APPLICATION_JSON);
						}
					}
				}
			}



		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}finally {
			if(connection!=null)
				connection.close();
			if(statement!=null)
				statement.close();
		}





		return null;
/*
		System.out.println(user.toString());
		System.out.println(jsonObject.toString());

		System.out.println(">> " + entity.getClass());

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
