package util;

public class DataUtil {

	public static boolean isValueAsDouble(String input){
		String strTest=input.replace("QUOTE_SYM", "").trim();
		try{
			double b=Double.parseDouble(strTest);
			return true;
		} catch(Exception ex){
		//	ex.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
