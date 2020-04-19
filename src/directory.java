import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class directory {
    static TextArea dir_path_tf = new TextArea();
    static JButton dir_jb_start = new JButton("开始");
    static JLabel dir_jl_url = new JLabel("输入URL：");
    static JLabel dir_jl_out = new JLabel("目录：");
    static TextField dir_tf_url = new TextField("");
    static JButton dir_jb_output = new JButton("导出URL");
    static JLabel dir_jl_thread = new JLabel("线程：");
    static Choice dir_choice_thread = new Choice();
    static JLabel dir_jl_time = new JLabel("延时：");
    static Choice dir_choice_time = new Choice();
    static JButton dir_jb_set = new JButton("设置");
    static JButton dir_jb_path = new JButton("导入字典");
    static FileDialog dir_fd_load = new FileDialog(Main.jfrm, "读取文件",FileDialog.LOAD);
    static FileDialog dir_fd_save = new FileDialog(Main.jfrm,"导出文件",FileDialog.SAVE);
    static int thread_num = 10;      // 设置线程数量
    static int time_num = 0;      // 设置等待时间
    static Checkbox flag_200 = new Checkbox("200");

    public void set() {
        // 设置线程组件
        String[] thread_num = {"1","10","50","100","200"};
        String[] time_num = {"0","1","2","5","10"};
        for(int i = 0; i < thread_num.length; i++) {
            dir_choice_thread.add(thread_num[i]);
            dir_choice_time.add(time_num[i]);
        }
        dir_choice_time.select(0);
        dir_choice_thread.select(1);
        dir_jl_thread.setBounds(20,50,50,20);
        dir_choice_thread.setBounds(70,50,50,40);
        dir_jl_time.setBounds(150,50,50,20);
        dir_choice_time.setBounds(200,50,50,40);
        Main.jp_list.add(dir_jl_thread);
        Main.jp_list.add(dir_choice_thread);
        Main.jp_list.add(dir_jl_time);
        Main.jp_list.add(dir_choice_time);
        dir_jb_set.setBounds(280,50,70,20);
        Main.jp_list.add(dir_jb_set);
        // 设置其他组加
        dir_jl_url.setBounds(20,20,60,20);
        dir_tf_url.setBounds(100,20,180,20);
        dir_jb_path.setBounds(300,20,90,20);
        dir_jb_start.setBounds(370,50,60,20);
        dir_jl_out.setBounds(20,80,60,20);
        dir_path_tf.setBounds(20,100,400,300);
        dir_jb_output.setBounds(380,400,100,20);
        Main.jp_list.add(dir_jb_output);
        Main.jp_list.add(dir_jb_start);
        Main.jp_list.add(dir_jl_out);
        Main.jp_list.add(dir_jl_url);
        Main.jp_list.add(dir_path_tf);
        Main.jp_list.add(dir_tf_url);
        Main.jp_list.add(dir_jb_path);

        // 只返回200
        flag_200.setBounds(400,12,80,40);
        Main.jp_list.add(flag_200);

        dir_jb_path.addActionListener(new myListener_dir());
        dir_jb_set.addActionListener(new myListener_dir());
        dir_jb_start.addActionListener(new myListener_dir());
        dir_jb_output.addActionListener(new myListener_dir());
    }
}
