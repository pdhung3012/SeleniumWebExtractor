package util;

import java.io.File;
import java.util.ArrayList;

public class FileSearchUtil {

	public static void findFiles(File root, String extension,
			ArrayList<String> lstFilePaths) {
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(extension)) {
				lstFilePaths.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				findFiles(file, extension, lstFilePaths);
			}
		}
	}

	public static String[] findAllJavaFiles(String inputPath) {
		ArrayList<String> lstRersult = new ArrayList<String>();
		File fileInput = new File(inputPath);
		findFiles(fileInput, "java", lstRersult);

		return convertToArrString(lstRersult);
	}
	
	public static String[] findAllExtensionFiles(String inputPath,String extension) {
		ArrayList<String> lstRersult = new ArrayList<String>();
		File fileInput = new File(inputPath);
		findFiles(fileInput, "java", lstRersult);

		return convertToArrString(lstRersult);
	}
	
	public static String[] convertToArrString(ArrayList<String> lstInput) {
		String[] arrResult = new String[lstInput.size()];
		for (int i = 0; i < lstInput.size(); i++) {
			arrResult[i] = lstInput.get(i);
		}
		return arrResult;
	}

}
