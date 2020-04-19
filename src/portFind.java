import java.io.*;

public class portFind {
    static String[] port_list;
    static int length;       // 选择的字典长度除以线程数量
    static int save_port_thread_num;    // 用于保存线程数量
    static int count;
    static int port_num;
    public void portLode() {
        port_num = Integer.valueOf(portScan.port_port_num.getText());
        System.out.println(port_num);
        count = portScan.port_li_ip.getItemCount();
        StringBuffer port = new StringBuffer();
        for(int i = 1; i < port_num; i++)
            port.append(i + "\n");
        port_list = port.toString().split("\n");
        length = port_list.length / portScan.thread_num;
        save_port_thread_num = portScan.thread_num;       // 保存线程数

        while(portScan.thread_num > 0 && count > 0) {
            portThread portthread = new portThread();
            portthread.start();
            --portScan.thread_num;
            if(portScan.thread_num == 0) {
                count--;
                portScan.thread_num = save_port_thread_num;
            }
        }

    }
}
