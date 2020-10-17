package com.booking.steps;

import com.booking.pages.Background;
import io.cucumber.java.en.Given;
import net.thucydides.core.steps.ScenarioSteps;

public class BackgroundSteps extends ScenarioSteps {

	private Background background;

	@Given("/^\"([^\"]*)\" is open$/")
	public void openWebPage(String url) {
		background.openHomePage(url);
		background.cookieBtns.get(1).click();
	}

}
