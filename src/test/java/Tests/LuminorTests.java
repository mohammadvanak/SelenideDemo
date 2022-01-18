package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LuminorTests {
	
	@Test
	public void currencyRates() throws InterruptedException
	{
		//Configuration.pageLoadStrategy="eager";
		open("https://luminor.ee/currency-rates");
		$(By.className("loading-app")).should(disappear);
		Thread.sleep(20000);
			$(By.cssSelector(".bp3-popover-wrapper.custom-control.currency-select.currency-select-large")).shouldBe(visible);
		  $(By.cssSelector(".bp3-popover-wrapper.custom-control.currency-select.currency-select-large")).click();
		  $(By.xpath(" //button[contains(text(),\"USD\")]")).click();
		  $(By.className("control-input-input")).setValue("100");
		  //button[contains(text(),"USD")]
		  Thread.sleep(10000);
		  ElementsCollection inputFields= $$(By.className("control-input-input"));
		  String iBuyTextvalue=inputFields.get(2).getAttribute("value");
		  System.out.println(iBuyTextvalue);
	}
}
