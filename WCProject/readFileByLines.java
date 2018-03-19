import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class readFileByLines {
	public String fileName;
	public readFileByLines(String theFilename){
		this.fileName=theFilename;
	}
    public ArrayList<String> fileString(){
	File file = new File(fileName);
	ArrayList<String>  lineArray = new ArrayList<String> ();
    BufferedReader reader =null;{
    try {
    	reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
        	lineArray.add(tempString);
        }
        reader.close();
    } catch (IOException e) {
        //e.printStackTrace();
    	System.out.println("找不到指定文件，请重新输入");
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e1) {
            }
        }
    }
}
	return lineArray;
    }
}

