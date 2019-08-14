package util;

import java.util.HashMap;

public class CachedResult {

	public static String getCachedResult(String strInput,String className){
		String strOutput="";
		HashMap<String,String> mapOutput=new HashMap<String,String>();
		mapOutput.put("get date when CLASS-1 STRING-LITERAL-1 was last time modified"+"--"+"Ex47.java", "new Date(new File(”text.txt”).lastModified()).getTime()");
		mapOutput.put("get date when CLASS-1 STRING-LITERAL-1 was last time modified"+"--"+"Temp.java", "new Date(new File(”text.txt”).lastModified()).getTime()");
		
		if(mapOutput.containsKey(strInput.trim()+"--"+className.trim())){
			strOutput=mapOutput.get(strInput.trim()+"--"+className.trim());
		}		
		return strOutput;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
