import java.net.URL;
import java.net.URLConnection;

public class urlThread extends Thread {
    int thread_num = Main.thread_num;
    int max = urlFind.save_main_thread_num;
    int i = urlFind.count - 1;      // 确定是第n条主域名
    public void run() {
        if (urlFind.subdomain_list.length % max != 0 && thread_num == Integer.valueOf(Main.choice_thread.getSelectedItem(), 10)) {
            for (int j = urlFind.subdomain_list.length - 1; j >= thread_num * urlFind.flag; j--) {
                visite(i, j);
                try{this.sleep(Main.time_waite * 1000);}catch (Exception e){}
            }
        }
        for (int j = thread_num * urlFind.flag - 1; j >= (thread_num - 1) * urlFind.flag; j--) {       // 大于下一个线程的开始长度
            visite(i, j);
            try{this.sleep(Main.time_waite * 1000);}catch (Exception e){}
        }
    }
    public void visite(int i, int j) {
        try {
            URL url1 = new URL("http://" + urlFind.subdomain_list[j] + "." + urlFind.domain_list[i]);
            URL url2 = new URL("https://" + urlFind.subdomain_list[j] + "."+ urlFind.domain_list[i] );
            URLConnection uC1 = url1.openConnection();
            URLConnection uC2 = url2.openConnection();
            if(uC1.getContentLength() > 0) {
                Main.jta_sub.append(url1.toString() + "\n");
            } else if(uC2.getContentLength() > 0) {
                Main.jta_sub.append(url2.toString() + "\n");
            }
        }catch (Exception e) { }
    }
}