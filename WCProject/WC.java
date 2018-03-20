import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WC {
	private int numofChar;//�ַ���
	private int numofWord;//������
	private int numofLine;//����
	private int numofCode;//��������
	private int numofEmpty;//������
	private int numofComment;//ע����
	public int[] flag;//��¼��������ͣ�����������������ص�ֵ
	private String method;//����Ĳ���
	private String file;//ͳ�Ƶ�Դ�ļ�
	private String stopList=null;//ͣ�ôʱ�
	private String outputFile=null;//����ļ�
	public WC(String theCommand){
		//����-a�Ȳ���
		this.flag=new int[6];
		String pattern = "((-[cwlsa] )+)([^(-[cwlsa] )]+(\\.).+)";   
		// ���� Pattern ����
	    Pattern r = Pattern.compile(pattern);
	    // ���ڴ��� matcher ����,m.group(1)�洢��-a�Ȳ�����m.group(3)�洢���ļ�·���Ժ������
	    Matcher m = r.matcher(theCommand);
	    if(m.find()){
			// ����group(3)���ַ�����path��¼��Դ�ļ�·����-e,-o����
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
					this.outputFile=path[1].split(" -o ")[1];
				}
			}
	        //ȷ���ļ�·��
			fileFinder finder = new fileFinder();  
	        List<String> filenameList = new ArrayList<String>();
	        
	        if(file.split("\\*").length>1)
	        //�ļ��к���*
	        {
		        if(file.split("\\*")[0].length()>0){
		        //�ļ��к��о���·��
		        finder.findFiles(file.split("\\.")[1] ,file.split("\\*")[0] , filenameList);}
		        //�ļ�Ĭ��Ϊ��ǰ·��
		        else{finder.findFiles(file.split("\\.")[1] ,System.getProperty("user.dir"), filenameList);}
	        }
	        else{
	        //�ļ���û��*,���ļ�����ȷ����,Ĭ��\ΪĿ¼��·��
	        	if(file.split("\\\\").length==1){
	        		//�ļ�Ϊ��ǰ·��
			        	
	        	}
	        	else{
	        		//�ļ�Ϊ����·��
	        		
	        	}
	        	
	        }
		    //û��-s����,��ֻ�ô����Ŀ¼�µ��ƶ��ļ�
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
			//��-s���������������Ŀ¼�µ��ļ�
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
	//����ÿ���ļ����ַ���
	public void countChar(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//���ж�ȡָ���ļ�
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
	//����ÿ���ļ��ĵ�����
	public void countWord(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//���ж�ȡָ���ļ�
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
	//����ÿ���ļ���������
	public void countLine(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//���ж�ȡָ���ļ�
	    ArrayList<String>  lineArray = new ArrayList<String> ();
	    lineArray=readFile.fileString();
	    setNumofLine(lineArray.size());
	}
	//����ÿ���ļ��Ĵ�������
	public void countCode(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//���ж�ȡָ���ļ�
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
	//����ÿ���ļ��Ŀ�����
	public void countEmpty(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//���ж�ȡָ���ļ�
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
	//����ÿ���ļ���ע������(���������п��ܳ���ֻ�����ַ�+//��//����ͷ/*)
	public void countComment(String theFile){
		readFileByLines readFile= new readFileByLines(this.file);
		//���ж�ȡָ���ļ�
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
