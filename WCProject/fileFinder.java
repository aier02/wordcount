import java.io.File;  
import java.util.List;  
public class fileFinder {
    /** 
     * Ѱ��ָ��Ŀ¼�£�����ָ����׺���������ļ��� 
     *  
     * @param filenameSuffix : �ļ���׺�� 
     * @param currentDirUsed : ��ǰʹ�õ��ļ�Ŀ¼ 
     * @param currentFilenameList ����ǰ�ļ����Ƶ��б� 
     */  
    public void findFiles(String filenameSuffix, String currentDirUsed,  
            List<String> currentFilenameList) {  
        File dir = new File(currentDirUsed);  
        if (!dir.exists() || !dir.isDirectory()) {  
            System.out.println("�����ڸ�Ŀ¼");
        	return;  
        }  
  
        for (File file : dir.listFiles()) {  
            if (file.isDirectory()) {  
                /** 
                 * ���Ŀ¼��ݹ�������� 
                 */  
                findFiles(filenameSuffix,file.getAbsolutePath(), currentFilenameList);  
            } else {  
                /** 
                 * �������Ŀ¼�� 
                 * ��ô�ж��ļ���׺���Ƿ���ϡ�
                 */  
                if (file.getAbsolutePath().endsWith(filenameSuffix)) {  
                    currentFilenameList.add(file.getAbsolutePath());  
                }  
            }  
        }  
    }  
      
}  

