package controllers;

import com.jfinal.core.Controller;

public class IndexController extends Controller {

	public void index() {
		render("index.html");
	}

	public void home() {
		render("home.html");
	}
}
