package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;

import Utils.ExcelUtil;

import static com.codeborne.selenide.Selenide.*;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class LuminorTests {
	
	@Test
	public void currencyRates() throws InterruptedException, IOException
	{
		Configuration.reportsFolder = "test-output/Screenshots";
		//Configuration.pageLoadStrategy="eager";
		List<String> data=ExcelUtil.readExcel(".//Data", "TestData.xlsx", "CurrencyRates");
		open("https://luminor.ee/currency-rates");
		$(By.className("loading-app")).should(disappear);
		Thread.sleep(20000);// This is being used because the site is very slow and selenide is giving exceptions very early.
			$(By.cssSelector(".bp3-popover-wrapper.custom-control.currency-select.currency-select-large")).shouldBe(visible);
		  $(By.cssSelector(".bp3-popover-wrapper.custom-control.currency-select.currency-select-large")).click();
		  $(By.xpath(" //button[contains(text(),\"USD\")]")).click();
		  $(By.className("control-input-input")).setValue(data.get(0));
		  Thread.sleep(5000);
		  ElementsCollection inputFields= $$(By.className("control-input-input"));
		  String iBuyTextvalue=inputFields.get(2).getAttribute("value");
		  System.out.println(iBuyTextvalue);
		  String pngFileName = screenshot("currencyRates");
	}
}
