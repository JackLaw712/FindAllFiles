
/**
 * Find all the files in the directory
 * Credits to https://blog.csdn.net/weixin_39086483/article/details/106313694
 * 
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindAllFiles {
    private static final String PATH = "target";

    public static void main(String[] args)  {
        List<String> list = new ArrayList<>();
        getAllFile(list, PATH);      
        System.out.println(list);
        System.out.println("Files in the Folder = " + list.size());

    }

    /**
     * find all the files in the directory
     * 
     * @param list to store the path of the files
     * @param path to store the path of the directory which is needed to be search
     */
    public static void getAllFile(List<String> list, String path) {
        File item = new File(path);
        boolean exists = item.exists();
        if (exists) {
            if (item.isFile()) {
                if (!item.getName().contains(".DS_Store")) {
                    list.add(item.getPath());
                    // System.out.println(item.getPath());
                }
            } else if (item.isDirectory()) {
                File[] items = item.listFiles();
                for (File f : items) {
                    getAllFile(list, f.getPath());
                    // System.out.println(f.getPath());
                }
            }
        } else {
            System.out.println("directory is not exists");
        }
    }
}