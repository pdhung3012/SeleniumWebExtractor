package com;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import util.FileIO;

public class DownloadGoogleLeetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String
		// fpListUrls="/Users/hungphan/git/translationExample/leet_total_solutions.txt";
		String outFolder = "/Users/hungphan/git/translationExample/google/";

		FirefoxProfile fxProfile = new FirefoxProfile();
		System.setProperty("webdriver.gecko.driver",
				"/Users/hungphan/git/translationExample/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		WebDriver driver = new FirefoxDriver(options);
		StringBuilder sbSucess = new StringBuilder();
		StringBuilder sbFailed = new StringBuilder();
		String url = "https://leetcode.com/company/google/";
		// String.format("%04d", (i+1));
		int indexRun = 1;
		String pageSource = "";
		boolean gotIt = false;
		try {
			driver.get("https://leetcode.com/accounts/login/");
			Thread.sleep(3000);
			ById byUser = new ById("username-input");
			ById byPass = new ById("password-input");
			ById byButton = new ById("sign-in-button");
			driver.findElement(byUser).sendKeys("pdhung3012@gmail.com");
			driver.findElement(byPass).sendKeys("30121989bm");
			driver.findElement(byButton).click();
			Thread.sleep(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		while (indexRun <= 1) {
			try {
				driver.navigate().to(url);
				Thread.sleep(4000);
				
//				ByClassName byButton = new ByClassName("reactable-th-frequency reactable-header-sortable reactable-header-sort-desc frequency__Hs3t");
//				byButton.tagName("th");
//				ByLinkText byLinkText=new ByLinkText("");
//				driver.findElement(byButton).click();
//				Thread.sleep(4000);
				pageSource = driver.getPageSource();
				break;
//				if (pageSource.contains("Description")) {
//					gotIt = true;
//					break;
//				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			indexRun++;
		}

		FileIO.writeStringToFile(pageSource, outFolder + "google-frequency.html");
//		System.out.println(idOut + "\t" + url + "\t" + gotIt);

		driver.close();

	}

}
