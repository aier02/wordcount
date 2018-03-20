import java.io.File;  
import java.util.List;  
public class fileFinder {
    /** 
     * 寻找指定目录下，具有指定后缀名的所有文件。 
     *  
     * @param filenameSuffix : 文件后缀名 
     * @param currentDirUsed : 当前使用的文件目录 
     * @param currentFilenameList ：当前文件名称的列表 
     */  
    public void findFiles(String filenameSuffix, String currentDirUsed,  
            List<String> currentFilenameList) {  
        File dir = new File(currentDirUsed);  
        if (!dir.exists() || !dir.isDirectory()) {  
            System.out.println("不存在该目录");
        	return;  
        }  
  
        for (File file : dir.listFiles()) {  
            if (file.isDirectory()) {  
                /** 
                 * 如果目录则递归继续遍历 
                 */  
                findFiles(filenameSuffix,file.getAbsolutePath(), currentFilenameList);  
            } else {  
                /** 
                 * 如果不是目录。 
                 * 那么判断文件后缀名是否符合。
                 */  
                if (file.getAbsolutePath().endsWith(filenameSuffix)) {  
                    currentFilenameList.add(file.getAbsolutePath());  
                }  
            }  
        }  
    }  
      
}  

