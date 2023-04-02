package qa.ui.tests;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTests {

	@BeforeMethod
	@BeforeTest
	public void setUp() {
		open("https://www.google.com");
		
		if($$("button>div.sy4vM").get(1).exists()) {
			$$("button>div.sy4vM").get(1).click();
		}
		
		assert title().equals("Google");
	}
	
	@Test
	public void pageHasInputAndASearchButton() {
		$("input[name='q']").shouldBe(visible);
		$("input[name='btnK']").shouldBe(exist);
	}
	
	@Test
	//@Parameters({"eglobal-group", "E-Global Group: international group of companies"})
	public void findSpeficPage() {
		$("input[name='q']").sendKeys("eglobal-group");
		$("input[name='q']").pressEnter();
		
		$$("#rso > div").get(0).find("a").click();
		
		assert title().equals("E-Global Group: international group of companies");
	}
}
