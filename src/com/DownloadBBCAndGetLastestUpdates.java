package com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import util.FileIO;

public class DownloadBBCAndGetLastestUpdates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String linkUrl = "https://www.bbc.com/news/world/";
		String fpHtmlContent = "/tmp/lastestUpdatesAnnie.html";
		String fpOutListUrl="/Users/hungphan/Desktop/outLinks.txt";
		FirefoxProfile fxProfile = new FirefoxProfile();
		System.setProperty("webdriver.gecko.driver", "/Users/hungphan/git/translationExample/geckodriver");
		String urlBBC="https://www.bbc.com/";
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		WebDriver driver = new FirefoxDriver(options);
		StringBuilder sbSucess = new StringBuilder();
		StringBuilder sbFailed = new StringBuilder();
		int indexRun = 1;
		String pageSource = "";
		boolean gotIt = false;
		try {
			driver.navigate().to(linkUrl);
			Thread.sleep(1000);
			pageSource = driver.getPageSource();
			gotIt = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		FileIO.writeStringToFile(pageSource, fpHtmlContent);
		driver.close();
		
		String strContent=FileIO.readStringFromFile(fpHtmlContent);
		Document doc = Jsoup.parse(strContent);
		
		Element divContainer = doc.select("div.gel-layout.gel-layout--center.lx-stream-wrapper-heading").first();
//		Elements lstUrls=divContainer.select(".qa-heading-link, .lx-stream-post__header-link");
		Elements lstUrls=doc.select("a.qa-heading-link, .lx-stream-post__header-link");
		String container=divContainer.text();
//		System.out.println(container);
		StringBuilder sbBuild=new StringBuilder();
		for(Element ele:lstUrls) {
//			System.out.println(ele.text());
			sbBuild.append(urlBBC+ ele.attr("href").trim().split("\\?intlink_from_url")[0]+"\n");
		}
		String total=sbBuild.toString();
		System.out.println(total);
		FileIO.writeStringToFile(total, fpOutListUrl);
	}

}
