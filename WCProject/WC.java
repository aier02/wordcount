import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WC {
	private int numofChar;//字符数
	private int numofWord;//单词数
	private int numofLine;//行数
	private int numofCode;//代码行数
	private int numofEmpty;//空行数
	private int numofComment;//注释行
	private String method;//输入的参数
	private String file;//统计的源文件
	private String stopList;//停用词表
	private String outputFile;//输出文件
	public WC(String theCommand){
		//划分-a等参数
		String pattern = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";   
		// 创建 Pattern 对象
	    Pattern r = Pattern.compile(pattern);
	    // 现在创建 matcher 对象,m.group(1)存储了-a等参数，m.group(3)存储了文件路径以后的内容
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
		//m.划分group(3)的字符串，path记录了源文件路径和-e,-o参数
		String[] path=m.group(3).split(" -e ");
		//设置统计的源文件
		this.file=path[0];
		if(path.length>1){
			//存在-e参数时
			if(path[1].split(" -o ").length>0){
				this.stopList=path[1].split(" -o ")[0];
			}
			//存在-o参数时
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
