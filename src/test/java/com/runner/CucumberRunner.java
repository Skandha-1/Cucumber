package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
features="./src/test/resources/",
glue="com.steps",
plugin = {
		"pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"

},
tags= "@Completed"
)
public class CucumberRunner {

}
