package qa.ui.tests;

import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DemoShopPage;

public class DemoShopTests {

	@BeforeTest
	public void setUp() {
		open("https://www.demoblaze.com");
	}

	@Test
	public void loginToPage() {
		DemoShopPage.Login("username", "password");
		DemoShopPage.ClickTopMenuItem("Home");
	}
}
