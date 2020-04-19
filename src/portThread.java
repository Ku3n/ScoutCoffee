import java.io.*;
import java.net.*;
import java.util.regex.*;

public class portThread extends Thread {
    int thread_num = portScan.thread_num;
    int i = portFind.count - 1;      // 确定是第n条host或者ip

    public void run() {
        for (int j = thread_num * portFind.length - 1; j >= (thread_num - 1) * portFind.length; j--) {       // 大于下一个线程的开始长度
            visite(i, j);
            try{this.sleep(Main.time_waite * 1000);}catch (Exception e){}
        }
    }
    public void visite(int i, int j) {
        String ip_host = portScan.port_str_list[i];
        String pattern = "\\d.\\d.\\d.\\d";
        if(ip_host.matches(pattern)) {
            try {
                InetAddress ip = InetAddress.getByName(ip_host);
                Socket socket = new Socket(ip,j);
                portScan.port_ta_port.append(socket.getInetAddress() + ":" + j);
                socket.close();
            }catch (Exception e){}
        }
        else {
            try {
                Socket socket = new Socket(ip_host,j);
                portScan.port_ta_port.append(socket.getInetAddress() + ":" + j + "\n");
                socket.close();
            }catch (Exception e){}
        }
    }
}
