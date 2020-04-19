import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Main {
    // 窗口整体
    static JFrame jfrm = new JFrame("侦察咖啡");
    static Container ct = jfrm.getContentPane();
    static JTabbedPane tp = new JTabbedPane();
    static JPanel jp_list = new JPanel();
    static JPanel jp_sub = new JPanel();
    static JPanel jp_port = new JPanel();
    static Image img = Toolkit.getDefaultToolkit().getImage("/icon.jpg");

    // 子域名爆破组件
    static JLabel lab_domain = new JLabel("域名：");
    static JLabel lab_sub = new JLabel("子域名：");
    static TextArea jta_domain = new TextArea("");
    static TextArea jta_sub = new TextArea();
    static JLabel lab_thread = new JLabel("线程：");
    static int thread_num = 10;      // 设置线程数量
    static int time_waite = 0;      // 设置等待时间
    static JLabel lab_waite = new JLabel("延时：");
    static Choice choice_thread = new Choice();
    static Choice choice_waite = new Choice();
    static JButton jb_set = new JButton("设置");
    static JButton jb_sub_input = new JButton("导入域名");
    static JButton jb_sub_output = new JButton("导出子域名");
    static FileDialog sub_fd_load = new FileDialog(jfrm, "读取文件",FileDialog.LOAD);
    static FileDialog sub_fd_save = new FileDialog(jfrm,"导出文件",FileDialog.SAVE);
    static JButton jb_sub_start = new JButton("开始爆破");
    static JButton jb_sub_dictionaries = new JButton("选择字典");

    static JLabel sub_author = new JLabel("Powered by ku3n/李香兰");
    static JLabel sub_email = new JLabel("ku3n@qq.com");
    static JLabel port_author = new JLabel("Powered by ku3n/李香兰");
    static JLabel port_email = new JLabel("ku3n@qq.com");
    static JLabel dir_author = new JLabel("Powered by ku3n/李香兰");
    static JLabel dir_email = new JLabel("ku3n@qq.com");

    public static void main(String[] args) {
        jfrm.setSize(517,540);
        jfrm.setIconImage(img);
        ct.setLayout(null);
        jp_sub.setLayout(null);
        jp_list.setLayout(null);
        jp_port.setLayout(null);
        tp.add("子域名扫描",jp_sub);
        tp.add("目录扫描",jp_list);
        tp.add("端口扫描",jp_port);
        tp.setBounds(0,0,500,500);

        sub_author.setBounds(350,430,150,20);
        sub_email.setBounds(350,450,100,20);
        port_author.setBounds(350,430,150,20);
        port_email.setBounds(350,450,100,20);
        dir_author.setBounds(350,430,150,20);
        dir_email.setBounds(350,450,100,20);
        jp_port.add(port_author);jp_port.add(port_email);
        jp_list.add(dir_author);jp_list.add(dir_email);
        jp_sub.add(sub_author);jp_sub.add(sub_email);

        // 子域名扫描的版面配置
        lab_domain.setBounds(10,50,40,40);
        jta_domain.setBounds(10,90,200,300);
        lab_sub.setBounds(250,50,60,40);
        jta_sub.setBounds(250,90,200,300);

        jp_sub.add(lab_domain);
        jp_sub.add(jta_domain);
        jp_sub.add(lab_sub);
        jp_sub.add(jta_sub);
        // 子域名版面设置线程和等待时间
        String[] thread_num = {"1","10","50","100","200"};
        String[] time_num = {"0","1","2","5","10"};
        for(int i = 0; i < thread_num.length; i++) {
            choice_thread.add(thread_num[i]);
            choice_waite.add(time_num[i]);
        }
        choice_waite.select(0);
        choice_thread.select(1);
        lab_thread.setBounds(10,0,40,40);
        choice_thread.setBounds(50,10,50,40);
        lab_waite.setBounds(120,0,40,40);
        choice_waite.setBounds(160,10,50,40);
        jb_set.setBounds(230,10,60,25);

        jp_sub.add(lab_thread);
        jp_sub.add(lab_waite);
        jp_sub.add(choice_thread);
        jp_sub.add(choice_waite);
        jp_sub.add(jb_set);

        // 子域名版面设置文件导入导出
         jb_sub_input.setBounds(10,400,90,30);
         jp_sub.add(jb_sub_input);
        jb_sub_output.setBounds(350,400,100,30);
        jp_sub.add(jb_sub_output);
        jb_sub_dictionaries.setBounds(110,400,90,30);
        jp_sub.add(jb_sub_dictionaries);
        jb_sub_start.setBounds(250,400,90,30);
        jp_sub.add(jb_sub_start);

        // 子域名版面设置倾听者和事件处理者
        jb_sub_input.addActionListener(new myListener_sub());
        jb_sub_output.addActionListener(new myListener_sub());
        jb_sub_dictionaries.addActionListener(new myListener_sub());
        jb_sub_start.addActionListener(new myListener_sub());
        jb_set.addActionListener(new myListener_sub());

        // 目录扫描版面
        new directory().set();
        // 端口扫描版面
        new portScan().set();


        ct.add(tp);
        jfrm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfrm.setVisible(true);
    }
}
