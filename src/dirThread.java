import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class dirThread extends Thread {
    int num = dirFind.count * directory.thread_num;
    int num_last = dirFind.count * (directory.thread_num-1);
    int thread_num = directory.thread_num;
    boolean flag = directory.flag_200.getState();
    public void run() {
        System.out.println(flag);
        System.out.println(num + "num_last:" + num_last);
        if(dirFind.path_list.length % dirFind.save_directory_thread_num != 0 && thread_num == dirFind.save_directory_thread_num) {
            for(int i = dirFind.path_list.length - 1; i > num; i--) {
                visite(i);
                System.out.println(i + "多余被调用");
                try{this.sleep(directory.time_num * 1000);}catch (Exception e){}
            }
        }

        for(int i = num; i >= num_last; i--) {
            visite(i);
            System.out.println(i + "被调用");
            try{this.sleep(directory.time_num * 1000);}catch (Exception e){}
        }
    }
    public void visite(int i) {
        String url = directory.dir_tf_url.getText();
        try {
            URL url1 = new URL("http://" + url + "/" + dirFind.path_list[i]);
            URL url2 = new URL("https://" + url + "/" +dirFind.path_list[i]);
            HttpURLConnection uC1 =(HttpURLConnection) url1.openConnection();
            HttpURLConnection uC2 =(HttpURLConnection) url2.openConnection();

            if(uC1.getContentLength() > 0 && (uC1.getResponseCode() == 200 || flag)) {
                System.out.println(url1.toString() + "\t" + uC1.getResponseCode() + "\n");
                directory.dir_path_tf.append(url1.toString() + "\n");
            } else if(uC2.getContentLength() > 0 && (uC2.getResponseCode() == 200 || flag)) {
                System.out.println(url2.toString() + "\t" + uC2.getResponseCode() + "\n");
                directory.dir_path_tf.append(url2.toString() + "\n");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
