package controllers;

import java.util.List;
import java.util.Arrays;

import play.*;
import play.mvc.*;
import views.html.*;

public class Product extends Controller{
	
	public static Result listAllProducts(){
		List<models.Product> products = askDatabaseForAllProducts();

		return ok(listallproducts.render(products));
	}

	public static Result showOneProduct(int id){
		models.Product product = askDatabaseForOneProduct(id);

		if(product == null){
			
			//return notFound("product not found");
			return ok(productnotfound.render());
		}

		return ok(showoneproduct.render(product));
	}

	private static List<models.Product> askDatabaseForAllProducts(){
		return Arrays.asList(new models.Product[]{
			new models.Product(1, "Java Programming 101", "Fundamentals of Java programming language",200.50),
			new models.Product(2, "Play Framework with eclipse", "A step by step details into the play framework",180.50)
		});
	}

	private static models.Product askDatabaseForOneProduct(int id) {
		if(id == 1){
			return new models.Product(1, "Java Programming 101", "Fundamentals of Java programming language", 200.50);
		}
		if(id == 2){
			return new models.Product(2, "Play Framework with eclipse", "A step by step details into the play framework", 180.50);
		}
		
		return null;
	}

}
