package pageObjects;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

/**
 * 01.04.2023
 * @author Dmitrijs Viongradovs 
 *
 * This page object is simplified, just to show why to use it
 */
public class DemoShopPage {

	public static void ClickTopMenuItem(String name) {
		$("#navbarExample").find(By.partialLinkText(name)).click();
	}
	
	public static void Login(String username, String password) {
		ClickTopMenuItem("Log in");
		$("#logInModalLabel").is(Condition.visible);
		$("#loginusername").sendKeys(username);
		$("#loginpassword").sendKeys(password);
		$("button[onclick='logIn()']").click();
		
		$("#nameofuser").shouldHave(Condition.text("Welcome " + username));
	}
}
