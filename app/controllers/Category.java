package controllers;

import java.util.List;
import java.util.Arrays;

import play.*;
import play.mvc.*;
import views.html.*;

public class Category extends Controller{
	
	public static Result listAllCategories(){
		List<models.Category> categories = askDatabaseForAllCategories();

		return ok(listallcategories.render(categories));
	}

	public static Result showOneCategory(int id){
		models.Category category = askDatabaseForOneCategory(id);

		if(category == null){
			return ok(categorynotfound.render());
		}

		return ok(showonecategory.render(category));
	}

	private static List<models.Category> askDatabaseForAllCategories(){
		return Arrays.asList(new models.Category[]{
			new models.Category(1, "Books", "'Java Programming 101', 'Play Framework with eclipse'"),
			new models.Category(2, "Cars", "'BMW', 'Mercedes', ''Volvo")
		});
	}

	private static models.Category askDatabaseForOneCategory(int id) {
		if(id == 1){
			return new models.Category(1, "Books", "'Java Programming 101', 'Play Framework with eclipse'");
		}
		if(id == 2){
			return new models.Category(2, "Cars", "'BMW', 'Mercedes', ''Volvo");
		}
		
		return null;
	}

}
