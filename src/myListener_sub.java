import java.awt.event.*;
import java.io.*;

public class myListener_sub implements ActionListener {
    static String fileName = "./src/Subdomain.txt";
    public void actionPerformed(ActionEvent actionEvent) {
        String str = actionEvent.getActionCommand();

        // 确定线程和延时事件
        if(str.equals(Main.jb_set.getText())) {
            int thread_num = Integer.valueOf(Main.choice_thread.getSelectedItem(),10);
            int time_num = Integer.valueOf(Main.choice_waite.getSelectedItem(),10);
            Main.thread_num = thread_num;
            Main.time_waite = time_num;
        }

        // 域名导入
        if(str.equals(Main.jb_sub_input.getText())) {
            Main.sub_fd_load.setDirectory("./");
            Main.sub_fd_load.setVisible(true);      // 显示文件对话框
            String fileName = Main.sub_fd_load.getDirectory() + Main.sub_fd_load.getFile();     // 所选的文件
            try {
                FileReader reader = new FileReader(fileName);
                BufferedReader src_reader = new BufferedReader(reader);
                String str_domain;
                while ((str_domain = src_reader.readLine()) != null) {
                    Main.jta_domain.append(str_domain + "\n");
                }
                reader.close();
            }catch (Exception e) {
                System.out.println(e);
            }
        }

        // 导入字典
        if(str.equals(Main.jb_sub_dictionaries.getText())) {
            Main.sub_fd_load.setDirectory("./");
            Main.sub_fd_load.setVisible(true);      // 显示文件对话框
            String fileName_new = Main.sub_fd_load.getDirectory() + Main.sub_fd_load.getFile();     // 所选的文件
            fileName = fileName_new;
        }

        // 开始爆破
        if(str.equals(Main.jb_sub_start.getText())) {
            urlFind urlfind = new urlFind();
            urlfind.urlListLoad();
        }



        // 子域名导出
        if(str.equals(Main.jb_sub_output.getText())) {
            Main.sub_fd_save.setVisible(true);
            String fileName = Main.sub_fd_save.getDirectory() + Main.sub_fd_save.getFile();
            try {
                FileWriter writer = new FileWriter(fileName,true);
                String str_sub = Main.jta_sub.getText();
                String[] str_output_sub = str_sub.split("\n");
                for(int i = 0; i < str_output_sub.length; i++) {
                    writer.write(str_output_sub[i] + "\n");
                }
                writer.close();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

