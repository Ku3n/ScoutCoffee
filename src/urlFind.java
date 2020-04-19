import java.io.*;

public class urlFind {
    static String[] subdomain_list;
    static String[] domain_list;
    static int flag;
    static int count;
    static int save_main_thread_num;

    // 设置默认的字典
    public void urlListLoad() {
        String domain = Main.jta_domain.getText();      // 取得主域名
        domain_list = domain.split("\n");
        StringBuffer subdomain = new StringBuffer("");
        // 取得子域名
        try {
            FileReader reader = new FileReader(myListener_sub.fileName);
            BufferedReader src_reader = new BufferedReader(reader);
            String str_subdomain;
            while ((str_subdomain = src_reader.readLine()) != null) {
                subdomain.append(str_subdomain + "\n");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        subdomain_list = subdomain.toString().split("\n");
        flag = subdomain_list.length / Main.thread_num;     // 把长度均分给各个线程
        save_main_thread_num = Main.thread_num;

        count = domain_list.length;
        int first_flag = 0;
        String last_thread_name = "Thread-" + String.valueOf(count-1);
        String first_thread_name = "Thread-" + String.valueOf(first_flag);
        while(Main.thread_num > 0 && count > 0) {
            urlThread urlthread = new urlThread();
            urlthread.start();
            --Main.thread_num;
            if(Main.thread_num == 0) {
                count--;
                Main.thread_num = save_main_thread_num;
            }
        }
    }
}
