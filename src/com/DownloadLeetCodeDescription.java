package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import util.FileIO;

public class DownloadLeetCodeDescription {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String fpListUrls="/Users/hungphan/git/translationExample/leet_total_solutions.txt";
//		String[] arrUrls=FileIO.readStringFromFile(fpListUrls).split("\n");
//		String outFolder="/Users/hungphan/git/translationExample/discussion/";
//		String fpSucess="/Users/hungphan/git/translationExample/desc/leet_ok.txt";
//		String fpFail="/Users/hungphan/git/translationExample/desc/leet_fail.txt";
//		FileIO.writeStringToFile("",fpSucess);
//		FileIO.writeStringToFile("",fpFail);
		String linkUrl="https://www.cnn.com/2019/05/17/us/marlen-ochoa-lopez-friday/index.html";
		String fpOutLink="/Users/hungphan/Desktop/testForAnnie.html";
		FirefoxProfile fxProfile = new FirefoxProfile();
		System.setProperty("webdriver.gecko.driver", "/Users/hungphan/git/translationExample/geckodriver");
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(fxProfile);
		WebDriver driver = new FirefoxDriver(options);
		StringBuilder sbSucess=new StringBuilder();
		StringBuilder sbFailed=new StringBuilder();
//			.split("\t")[1]
			int indexRun=1;
			String pageSource = "";
			boolean gotIt=false;
//			if(i==184){
//				
//				try{
//					driver.get("https://leetcode.com/accounts/login/");
//					Thread.sleep(3000);	
//					ById byUser=new ById("username-input");
//					ById byPass=new ById("password-input");
//					ById byButton=new ById("sign-in-button");
//					driver.findElement(byUser).sendKeys("pdhung3012@gmail.com");
//					driver.findElement(byPass).sendKeys("30121989bm");
//					driver.findElement(byButton).click();
//					Thread.sleep(15000);	
//				}catch(Exception ex){
//					ex.printStackTrace();
//				}
//			}
			while(indexRun<=1){
				try{				
					driver.navigate().to(linkUrl);
					Thread.sleep(4000);			
					pageSource = driver.getPageSource();
					gotIt=true;
					break;

//					if(pageSource.contains("Description")){
//						gotIt=true;
//						break;
//					}	
				} catch(Exception ex){
					ex.printStackTrace();
				}
				
				indexRun++;
			}
//			if(gotIt){
//				FileIO.appendStringToFile(idOut+"\t"+url+"\n", fpSucess);
//			} else{
//				FileIO.appendStringToFile(idOut+"\t"+url+"\n", fpFail);
//			}			
			FileIO.writeStringToFile(pageSource,fpOutLink);
//			System.out.println(idOut+"\t"+url+"\t"+gotIt);
//			if(i==5){
//				break;
//			}
		driver.close();
	}

}
