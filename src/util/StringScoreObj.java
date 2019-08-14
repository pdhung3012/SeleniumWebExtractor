package util;

public class StringScoreObj {

	public static String Type_Invocation="Invocation";
	public static String Type_Field="Field";
	public static String Type_Constructor="Constructor";
	
	private String strContent;
	private boolean isStatic=false;
	private String className;
	private double score=1;
	private String typeOfDecl=Type_Invocation;
	private String codeContent;
	private String lstRequiredArguments="";
	private String receiverFQN;
	private String returnTypeFQN;
	
	
	
	
	public String getReturnTypeFQN() {
		return returnTypeFQN;
	}

	public void setReturnTypeFQN(String returnTypeFQN) {
		this.returnTypeFQN = returnTypeFQN;
	}

	public String getReceiverFQN() {
		return receiverFQN;
	}

	public void setReceiverFQN(String receiverFQN) {
		this.receiverFQN = receiverFQN;
	}

	public int getNumArguments(){
		if(lstRequiredArguments.equals("EMPTY")){
			return 0;
		} else{
			return lstRequiredArguments.split(",").length;
		}
	}
	
	public String getLstRequiredArguments() {
		return lstRequiredArguments;
	}


	public void setLstRequiredArguments(String lstRequiredArguments) {
		this.lstRequiredArguments = lstRequiredArguments;
	}


	public String getCodeContent() {
		return codeContent;
	}


	public void setCodeContent(String codeContent) {
		this.codeContent = codeContent;
	}


	public String getTypeOfDecl() {
		return typeOfDecl;
	}


	public void setTypeOfDecl(String typeOfDecl) {
		this.typeOfDecl = typeOfDecl;
	}


	public static String getType_Invocation() {
		return Type_Invocation;
	}


	public static void setType_Invocation(String type_Invocation) {
		Type_Invocation = type_Invocation;
	}


	public static String getType_Field() {
		return Type_Field;
	}


	public static void setType_Field(String type_Field) {
		Type_Field = type_Field;
	}


	public static String getType_Constructor() {
		return Type_Constructor;
	}


	public static void setType_Constructor(String type_Constructor) {
		Type_Constructor = type_Constructor;
	}


	


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public boolean isStatic() {
		return isStatic;
	}


	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}


	public String getStrContent() {
		return strContent;
	}


	public void setStrContent(String strContent) {
		this.strContent = strContent;
	}


	public double getScore() {
		return score;
	}


	public void setScore(double score) {
		this.score = score;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
