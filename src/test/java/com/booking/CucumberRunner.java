package com.booking;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports.html"},
        glue = {"com.booking.steps"},
		features = "src/test/resources/features/",
		tags = "@Booking")
public class CucumberRunner {

}