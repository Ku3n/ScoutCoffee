import java.io.*;

public class dirFind {
    static String[] path_list;
    static int count;       // 选择的字典长度除以线程数量
    static int save_directory_thread_num;    // 用于保存线程数量

    public void dirLode() {
        StringBuffer path = new StringBuffer();
        try {
            FileReader reader = new FileReader(myListener_dir.fileName);
            BufferedReader src_reader = new BufferedReader(reader);
            String str_path;
            while ((str_path = src_reader.readLine()) != null) {
                path.append(str_path + "\n");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        path_list = path.toString().split("\n");
        count = path_list.length / directory.thread_num;
        save_directory_thread_num = directory.thread_num;       // 保存线程数
        while(directory.thread_num > 0) {
            dirThread dirThread = new dirThread();
            dirThread.start();
            --directory.thread_num;
        }
        directory.thread_num = save_directory_thread_num;
    }
}
