import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WC {
	private int numofChar;//字符数
	private int numofWord;//单词数
	private int numofLine;//行数
	private int numofCode;//代码行数
	private int numofEmpty;//空行数
	private int numofComment;//注释行
	public int[] flag;//记录输入的类型，用于主函数返回相关的值
	private String method;//输入的参数
	private String file;//统计的源文件
	private String stopList=null;//停用词表
	private String outputFile=null;//输出文件
	public WC(String theCommand){
		//划分-a等参数
		this.flag=new int[6];
		String pattern = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";   
		// 创建 Pattern 对象
	    Pattern r = Pattern.compile(pattern);
	    // 现在创建 matcher 对象,m.group(1)存储了-a等参数，m.group(3)存储了文件路径以后的内容
	    Matcher m = r.matcher(theCommand);
	    if(m.find()){
			// 划分group(3)的字符串，path记录了源文件路径和-e,-o参数
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
					this.outputFile=path[1].split(" -o ")[1];
				}
			}
	        //确定文件路径
			fileFinder finder = new fileFinder();  
	        List<String> filenameList = new ArrayList<String>();
	        
	        if(file.split("\\*").length>1)
	        //文件中含有*
	        {
		        if(file.split("\\*")[0].length()>0){
		        //文件中含有绝对路径
		        finder.findFiles(file.split("\\.")[1] ,file.split("\\*")[0] , filenameList);}
		        //文件默认为当前路径
		        else{finder.findFiles(file.split("\\.")[1] ,System.getProperty("user.dir"), filenameList);}
	        }
	        else{
	        //文件中没有*,即文件名是确定的,默认\为目录的路径
	        	if(file.split("\\\\").length==1){
	        		//文件为当前路径
			        	
	        	}
	        	else{
	        		//文件为绝对路径
	        		
	        	}
	        	
	        }
		    //没有-s参数,即只用处理该目录下的制定文件
			if(Pattern.matches("[^(-s )]*(-c )[^(-s )]*",m.group(1))){
				countChar(file);
				flag[0]=1;
			}
			if(Pattern.matches("[^(-s )]*(-w )[^(-s )]*",m.group(1))){
				countWord(file);
				flag[1]=1;
			}
			if(Pattern.matches("[^(-s )]*(-l )[^(-s )]*",m.group(1))){
				countLine(file);
				flag[2]=1;
			}
			if(Pattern.matches("[^(-s )]*(-a )[^(-s )]*",m.group(1))){
				countCode(file);
				flag[3]=1;
				countEmpty(file);
				flag[4]=1;
				countComment(file);
				flag[5]=1;
			}
			//有-s参数，迭代处理该目录下的文件
			if(Pattern.matches(".*(-s ).*",m.group(1))&&Pattern.matches(".*(-c ).*",m.group(1))){
	
			}
			if(Pattern.matches(".*(-s ).*",m.group(1))&&Pattern.matches(".*(-w ).*",m.group(1))){
	
			}
			if(Pattern.matches(".*(-s ).*",m.group(1))&&Pattern.matches(".*(-l ).*",m.group(1))){
	
			}
			if(Pattern.matches(".*(-s ).*",m.group(1))&&Pattern.matches(".*(-a ).*",m.group(1))){
	
			}
	    }
	    else{
	    	System.out.println("No match");
	    }

	}
	//计算每个文件的字符数
	public void countChar(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//按行读取指定文件
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    String pattern=".";
	    Pattern r = Pattern.compile(pattern);
	    int count=0;
	    for(int i =0;i<lineArray.size();i++){
	    	Matcher m = r.matcher(lineArray.get(i));
	    	System.out.println(lineArray.get(i)+lineArray.size());
	    	while(m.find()){
	    		count++;
	    	}
	    }
	    setNumofChar(count+lineArray.size());
	    
	}
	//计算每个文件的单词数
	public void countWord(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//按行读取指定文件
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    String pattern="[^, 	]+";
	    Pattern r = Pattern.compile(pattern);
	    int count=0;
	    for(int i =0;i<lineArray.size();i++){
	    	Matcher m = r.matcher(lineArray.get(i));
	    	System.out.println(lineArray.get(i)+lineArray.size());
	    	while(m.find()){
	    		count++;
	    	}
	    }
	    setNumofWord(count);
	}
	//计算每个文件的总行数
	public void countLine(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//按行读取指定文件
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    setNumofLine(lineArray.size());
	}
	//计算每个文件的代码行数
	public void countCode(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//按行读取指定文件
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    String pattern="[^\\n]{2,}";
	    Pattern r = Pattern.compile(pattern);
	    int count=0;
	    for(int i =0;i<lineArray.size();i++){
	    	Matcher m = r.matcher(lineArray.get(i));
	    	System.out.println(lineArray.get(i)+lineArray.size());
	    	if(m.find()){
	    		count++;
	    	}
	    }
	    setNumofCode(count);
	}
	//计算每个文件的空行数
	public void countEmpty(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//按行读取指定文件
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    String pattern="[^ 	]{2,}";
	    Pattern r = Pattern.compile(pattern);
	    int count=0;
	    for(int i =0;i<lineArray.size();i++){
	    	Matcher m = r.matcher(lineArray.get(i));
	    	System.out.println(lineArray.get(i)+lineArray.size());
	    	if(m.find()){
	    		count++;
	    	}
	    }
	    setNumofEmpty(lineArray.size()-count);
	}
	//计算每个文件的注释行数(不完整，有可能出错只处理单字符+//，//，开头/*)
	public void countComment(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//按行读取指定文件
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    String p1="^.?//";
	    String p2="^/*";
	    Pattern r1 = Pattern.compile(p1);
	    Pattern r2 = Pattern.compile(p2);
	    int count=0;
	    for(int i =0;i<lineArray.size();i++){
	    	Matcher m1 = r1.matcher(lineArray.get(i));
	    	Matcher m2 = r2.matcher(lineArray.get(i));
	    	System.out.println(lineArray.get(i)+lineArray.size());
	    	if(m1.find()||m2.find()){
	    		count++;
	    	}
	    }
	    setNumofComment(count);
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
