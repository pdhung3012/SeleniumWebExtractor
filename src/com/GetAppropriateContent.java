package com;

import java.util.Dictionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.FileIO;

public class GetAppropriateContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String linkUrl="https://www.cnn.com/2019/05/17/us/marlen-ochoa-lopez-friday/index.html";
		String fpOutLink="/Users/hungphan/Desktop/testForAnnie.html";
		String strContent=FileIO.readStringFromFile(fpOutLink);
		Document doc = Jsoup.parse(strContent);
		
		Element divContainer = doc.select("#body-text").first();
//		System.out.println(divContainer.toString());
		String containter=divContainer.text();
		Element divheadline = doc.select(".pg-headline").first();
		String title=divheadline.text();
		Element divTime = doc.select(".update-time").first();
		String time=divTime.text();

		String total=title+"\n\n"+time+"\n\n"+containter;

		FileIO.writeStringToFile(total, "/Users/hungphan/Desktop/outContent.txt");
		
	}

}
