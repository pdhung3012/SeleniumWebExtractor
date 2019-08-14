package com;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import util.FileDownloader;
import util.FileIO;
import util.HtmlUtil;

public class DownloadLeetCodeUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input="/Users/hungphan/Desktop/lt_solution_2.html";
//		String output="/Users/hungphan/Desktop/lt_list.txt";
//		String prefix="https://leetcode.com/problems/";
//		HtmlUtil.parseAndGetAllUrlToFile(input, prefix, output);
		String fpListUrls="/Users/hungphan/git/translationExample/leet_total_solutions.txt";
		String[] arrUrls=FileIO.readStringFromFile(fpListUrls).split("\n");
		String outFolder="/Users/hungphan/git/translationExample/leet2/";
		String fpSucess="/Users/hungphan/git/translationExample/leet2/b2_leet_ok.txt";
		String fpFail="/Users/hungphan/git/translationExample/leet2/b2_leet_fail.txt";
		FileIO.writeStringToFile("",fpSucess);
		FileIO.writeStringToFile("",fpFail);
		FirefoxProfile fxProfile = new FirefoxProfile();
		System.setProperty("webdriver.gecko.driver", "/Users/hungphan/git/translationExample/geckodriver");
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(fxProfile);
		WebDriver driver = new FirefoxDriver(options);
		StringBuilder sbSucess=new StringBuilder();
		StringBuilder sbFailed=new StringBuilder();
		for(int i=0;i<arrUrls.length;i++){
//			.split("\t")[1]
			
			String url = arrUrls[i].split("\t")[1].trim();
//			String.format("%04d", (i+1));
			String idOut= arrUrls[i].split("\t")[0].trim();
			int indexRun=1;
			String pageSource = "";
			boolean gotIt=false;
			if(i==0){
				
				try{
					driver.get("https://leetcode.com/accounts/login/");
					Thread.sleep(3000);	
					ById byUser=new ById("username-input");
					ById byPass=new ById("password-input");
					ById byButton=new ById("sign-in-button");
					driver.findElement(byUser).sendKeys("pdhung3012@gmail.com");
					driver.findElement(byPass).sendKeys("30121989bm");
					driver.findElement(byButton).click();
					Thread.sleep(15000);	
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			while(indexRun<=1){
				try{				
					driver.navigate().to(url);
					Thread.sleep(4000);			
					pageSource = driver.getPageSource();
					if(pageSource.contains("Algorithm")){
						gotIt=true;
						break;
					}	
				} catch(Exception ex){
					ex.printStackTrace();
				}
				
				indexRun++;
			}
			if(gotIt){
				FileIO.appendStringToFile(idOut+"\t"+url+"\n", fpSucess);
			} else{
				FileIO.appendStringToFile(idOut+"\t"+url+"\n", fpFail);
			}			
			FileIO.writeStringToFile(pageSource,outFolder+idOut+".html");
			System.out.println(idOut+"\t"+url+"\t"+gotIt);
//			if(i==5){
//				break;
//			}
		}
		driver.close();
	}

}
