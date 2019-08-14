package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapUtil {

	public static HashMap<String, String> getMapConstructorFromFile(
			String filePath) {
		HashMap<String, String> mapS = new LinkedHashMap<String, String>();
		String[] arrLines = FileIO.readStringFromFile(filePath).trim()
				.split("\n");
		for (int i = 0; i < arrLines.length; i++) {
			String[] arrItems = arrLines[i].split("\t");
			if (arrItems.length >= 3) {
				mapS.put(arrItems[0] + "\t" + arrItems[1], arrItems[2]);
			}

		}
		return mapS;

	}

	public static LinkedHashMap<String, LinkedHashSet<String>> getMapClassFromFolderFilterCommonTerm(
			String folderPath, Set<String> setCommonTerms) {
		LinkedHashMap<String, LinkedHashSet<String>> mapS = new LinkedHashMap<String, LinkedHashSet<String>>();
		File folder = new File(folderPath);
		File[] arrFileClass = folder.listFiles();
		for (int i = 0; i < arrFileClass.length; i++) {
			String classFQN = arrFileClass[i].getName()
					.replaceFirst(".txt", "");
			String className = StringUtil.getNameFromFQN(classFQN);
			if (!setCommonTerms.contains(className.toLowerCase())) {
				if (!mapS.containsKey(classFQN)) {
					LinkedHashSet<String> mapFQN = new LinkedHashSet<String>();
					mapFQN.add(classFQN);
					mapS.put(className, mapFQN);
				} else {
					mapS.get(className).add(classFQN);
				}
			}

		}
		return mapS;
	}

	public static LinkedHashMap<String, LinkedHashSet<String>> getMapClassFromFolder(
			String folderPath) {
		LinkedHashMap<String, LinkedHashSet<String>> mapS = new LinkedHashMap<String, LinkedHashSet<String>>();
		File folder = new File(folderPath);
		File[] arrFileClass = folder.listFiles();
		for (int i = 0; i < arrFileClass.length; i++) {
			String classFQN = arrFileClass[i].getName()
					.replaceFirst(".txt", "");
			String className = StringUtil.getNameFromFQN(classFQN);
			if (!mapS.containsKey(classFQN)) {
				LinkedHashSet<String> mapFQN = new LinkedHashSet<String>();
				mapFQN.add(classFQN);
				mapS.put(className, mapFQN);
			} else {
				mapS.get(className).add(classFQN);
			}

		}
		return mapS;
	}

	public static LinkedHashMap<String, LinkedHashSet<String>> getMapSynonymFromFolder(
			String folderPath, StanfordLemmatizer slem) {
		LinkedHashMap<String, LinkedHashSet<String>> mapS = new LinkedHashMap<String, LinkedHashSet<String>>();
		File folder = new File(folderPath);
		File[] arrFileClass = folder.listFiles();
		for (int i = 0; i < arrFileClass.length; i++) {
			String wordName = slem.lemmatizeToString(arrFileClass[i].getName()
					.replaceFirst(".txt", ""));
			if (!mapS.containsKey(wordName)) {
				LinkedHashSet<String> mapSynonyms = new LinkedHashSet<String>();
				String[] arrItems = FileIO.readStringFromFile(
						arrFileClass[i].getAbsolutePath()).split("\n");
				for (int j = 0; j < arrItems.length; j++) {
					if (!arrItems[j].isEmpty()) {
						mapSynonyms.add(arrItems[j]);
					}
				}
				mapS.put(wordName, mapSynonyms);
			}
		}
		return mapS;
	}

	public static LinkedHashMap<String, LinkedHashSet<String>> getMapMethodFromFolder(
			String folderPath) {
		LinkedHashMap<String, LinkedHashSet<String>> mapS = new LinkedHashMap<String, LinkedHashSet<String>>();
		File folder = new File(folderPath);
		File[] arrFileClass = folder.listFiles();
		for (int i = 0; i < arrFileClass.length; i++) {
			String methodName = arrFileClass[i].getName().replaceFirst(".txt",
					"");
			String[] arrContents = FileIO.readStringFromFile(
					arrFileClass[i].getAbsolutePath()).split("\n");

			if (!mapS.containsKey(methodName)) {
				LinkedHashSet<String> setMethodSignatures = new LinkedHashSet<String>();
				for (int j = 0; j < arrContents.length; j++) {
					setMethodSignatures.add(arrContents[j]);
				}
				mapS.put(methodName, setMethodSignatures);
			}
		}
		return mapS;
	}

	// public static <K, V extends Comparable<? super V>> Map<K, V>
	// sortByValue(Map<K, V> map) {
	// List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
	// list.sort(Entry.comparingByValue());
	//
	// Map<K, V> result = new LinkedHashMap<>();
	// for (Entry<K, V> entry : list) {
	// result.put(entry.getKey(), entry.getValue());
	// }
	//
	// return result;
	// }
}
