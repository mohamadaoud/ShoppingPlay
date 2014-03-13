package controllers;

import java.util.List;
import java.util.Arrays;

import play.*;
import play.mvc.*;
import views.html.*;

public class ShoppingBasket extends Controller{
	
	public static Result listShoppingBasket(){
		List<models.ShoppingBasket> basket = askDatabaseForBasket();

		return ok(listbasket.render(basket));
	}

	private static List<models.ShoppingBasket> askDatabaseForBasket(){
		return Arrays.asList(new models.ShoppingBasket[]{
			new models.ShoppingBasket(1, 10),
			new models.ShoppingBasket(2, 15)
		});
	}

}
