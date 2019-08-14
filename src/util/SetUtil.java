package util;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetUtil {
	
	public static HashSet<String> getSetFromFile(String filePath){
		HashSet<String> setS=new LinkedHashSet<String>();
		String[] arrItems=FileIO.readStringFromFile(filePath).trim().split("\n");
		for(int i=0;i<arrItems.length;i++){
			setS.add(arrItems[i].trim());
		}
		return setS;
		
	}
	
	public static Set<String> getSetFromFile(String filePath,StanfordLemmatizer slem){
		Set<String> setS=new LinkedHashSet<String>();
		String[] arrItems=FileIO.readStringFromFile(filePath).trim().split("\n");
		for(int i=0;i<arrItems.length;i++){
			String itemLem=slem.lemmatizeToString(arrItems[i].trim());
			setS.add(itemLem);
		}
		return setS;
		
	}
	
	public static LinkedHashSet<String> getLinkedHashSetFromFile(String filePath,StanfordLemmatizer slem){
		LinkedHashSet<String> setS=new LinkedHashSet<String>();
		String[] arrItems=FileIO.readStringFromFile(filePath).trim().split("\n");
		for(int i=0;i<arrItems.length;i++){
			String itemLem=slem.lemmatizeToString(arrItems[i].trim());
			setS.add(itemLem);
		}
		return setS;		
	}
	
	
	
	public static String getFirstElementFromSet(LinkedHashSet<String> set){
		String strResult="";
		for(String str:set){
			strResult=str;
		}
		return strResult;
	}
}
