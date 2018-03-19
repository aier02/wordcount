import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WC {
	private int numofChar;//�ַ���
	private int numofWord;//������
	private int numofLine;//����
	private int numofCode;//��������
	private int numofEmpty;//������
	private int numofComment;//ע����
	private String method;//����Ĳ���
	private String file;//ͳ�Ƶ�Դ�ļ�
	private String stopList;//ͣ�ôʱ�
	private String outputFile;//����ļ�
	public WC(String theCommand){
		//����-a�Ȳ���
		String pattern = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";   
		// ���� Pattern ����
	    Pattern r = Pattern.compile(pattern);
	    // ���ڴ��� matcher ����,m.group(1)�洢��-a�Ȳ�����m.group(3)�洢���ļ�·���Ժ������
	    Matcher m = r.matcher(theCommand);
		if(Pattern.matches(".*(-c ).*",m.group(1))){
			
		}
		if(Pattern.matches(".*(-w ).*",m.group(1))){
			
		}
		if(Pattern.matches(".*(-l ).*",m.group(1))){
			
		}
		if(Pattern.matches(".*(-s ).*",m.group(1))){
			
		}
		if(Pattern.matches(".*(-a ).*",m.group(1))){
			
		}
		//m.����group(3)���ַ�����path��¼��Դ�ļ�·����-e,-o����
		String[] path=m.group(3).split(" -e ");
		//����ͳ�Ƶ�Դ�ļ�
		this.file=path[0];
		if(path.length>1){
			//����-e����ʱ
			if(path[1].split(" -o ").length>0){
				this.stopList=path[1].split(" -o ")[0];
			}
			//����-o����ʱ
			if(path[1].split(" -o ").length==2){
				this.stopList=path[1].split(" -o ")[1];
			}
		}
		
	}
	public void countChar(String theFile){
		
	}
	public void countWord(String theFile){
		
	}
	public void countLine(String theFile){
		
	}
	public void countCode(String theFile){
		
	}
	public void countEmpty(String theFile){
		
	}
	public void countComment(String theFile){
		
	}
	public int getNumofChar() {
		return numofChar;
	}
	public void setNumofChar(int numofChar) {
		this.numofChar = numofChar;
	}
	public int getNumofWord() {
		return numofWord;
	}
	public void setNumofWord(int numofWord) {
		this.numofWord = numofWord;
	}
	public int getNumofLine() {
		return numofLine;
	}
	public void setNumofLine(int numofLine) {
		this.numofLine = numofLine;
	}
	public int getNumofCode() {
		return numofCode;
	}
	public void setNumofCode(int numofCode) {
		this.numofCode = numofCode;
	}
	public int getNumofEmpty() {
		return numofEmpty;
	}
	public void setNumofEmpty(int numofEmpty) {
		this.numofEmpty = numofEmpty;
	}
	public int getNumofComment() {
		return numofComment;
	}
	public void setNumofComment(int numofComment) {
		this.numofComment = numofComment;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getStopList() {
		return stopList;
	}
	public void setStopList(String stopList) {
		this.stopList = stopList;
	}
	public String getOutputFile() {
		return outputFile;
	}
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	
}
