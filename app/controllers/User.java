package controllers;

import java.util.List;
import java.util.Arrays;

import play.*;
import play.mvc.*;
import views.html.*;

public class User extends Controller{
	
	public static Result listAllUsers() {
		
		List<models.User> users = askDatabaseForAllUsers();
		
		return ok(listallusers.render(users));
	}
	
	public static Result showOneUser(int id) {
		models.User user = askDatabaseForOneUser(id);
		
			if(user == null){
				return ok(usernotfound.render());
			}
			
		return ok(showoneuser.render(user));
		
	}
	
	private static List<models.User> askDatabaseForAllUsers() {
		return Arrays.asList(new models.User[] {
				new models.User(1, "abc123", "Ali", "Hussein", "Stockholm", "077771111", "alihussein@mail.com"),
				new models.User(2, "cde455", "Mohamad", "Daoud", "Malmö", "011111111", "daoud@mail.com"),
				new models.User(3, "def333", "Karl", "Johansson", "Goteborg", "08988999", "karl@mail.com")
		});
	}
	
	private static models.User askDatabaseForOneUser(int id) {
		
		if(id == 1) {
			
			return new models.User(1, "abc123", "Ali", "Hussein", "Stockholm", "077771111", "alihussein@mail.com");
		}
		
		if(id == 2) {
			
			return new models.User(2, "cde455", "Mohamad", "Daoud", "Malmö", "011111111", "daoud@mail.com");
		}
		
		if(id == 3) {
			
			return new models.User(3, "def333", "Karl", "Johansson", "Goteborg", "08988999", "karl@mail.com");
		}
		
		return null;
	}

}
