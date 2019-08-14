package util;

import java.util.Random;

public class NumberUtil {

	public static int randInt(int min, int max) {
		Random rn = new Random();
		int range = max - min + 1;
		int randomNum =  rn.nextInt(range) + min;
	    return randomNum;
	}
	
	public static boolean checkStringInDouble(String value){
		boolean isCorrectResult=false;
		try{
			double result=Double.valueOf(value);
			isCorrectResult=true;
		} catch(Exception e){
			
		}
		return isCorrectResult;
	}
	
	public static boolean checkStringInBoolean(String value){
		
		return "true".equals(value) || "false".equals(value);
	}
	
	public static boolean checkStringInNumberElement(String value){
		boolean isCorrectResult=false;
		try{
			if(value.endsWith("th")||value.endsWith("rd")||value.endsWith("st")){
				String numValue=value.substring(0, value.length()-2);
				if(NumberUtil.checkStringInInteger(numValue)){
					isCorrectResult=true;
				}
			}
		} catch(Exception e){
			
		}
		return isCorrectResult;
	}
	
	public static int getStringInNumberElement(String value){
		int result=-1;
		try{
			if(value.endsWith("th")||value.endsWith("nd")||value.endsWith("rd")||value.endsWith("st")){
				String numValue=value.substring(0, value.length()-2);
				if(NumberUtil.checkStringInInteger(numValue)){
					result=Integer.parseInt(numValue);
				}
			}

		} catch(Exception e){
			
		}
		return result;
	}
	public static boolean checkStringInInteger(String value){
		boolean isCorrectResult=false;
		try{
			double result=Integer.valueOf(value);
			isCorrectResult=true;
		} catch(Exception e){
			
		}
		return isCorrectResult;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
