import javax.swing.*;
import java.awt.*;

public class portScan {
    // 设置组件
    static JLabel port_jl_num = new JLabel("端口最大值");
    static TextField port_port_num = new TextField();
    static Checkbox port_ck_1w = new Checkbox("1w");
    static Checkbox port_ck_10w = new Checkbox("10w");
    static JLabel port_jl_ip = new JLabel("导入host或IP");
    static StringBuffer port__sb_list = new StringBuffer();
    static String[] port_str_list;
    static JLabel port_jl_port = new JLabel("端口");
    static FileDialog port_fd_load = new FileDialog(Main.jfrm, "读取文件",FileDialog.LOAD);     // 文件选取窗口
    static FileDialog port_fd_save = new FileDialog(Main.jfrm,"导出文件",FileDialog.SAVE);
    static List port_li_ip = new List();
    static TextArea port_ta_port = new TextArea();
    static JButton port_jb_input = new JButton("导入ip/host");
    static JButton port_jb_output = new JButton("导出端口");
    static JLabel port_jl_thread = new JLabel("线程");
    static JLabel port_jl_time = new JLabel("延时");
    static JButton port_jb_set = new JButton("设置");
    static Choice port_choice_thread = new Choice();
    static Choice port_choice_time = new Choice();
    static int thread_num = 10;
    static int time_num = 0;
    static JButton port_jb_start = new JButton("开始");
    public void set() {
        port_jl_ip.setBounds(10,10,80,20);
        Main.jp_port.add(port_jl_ip);
        port_jb_input.setBounds(160,10,100,20);
        Main.jp_port.add(port_jb_input);
        port_li_ip.setBounds(10,35,250,380);
        Main.jp_port.add(port_li_ip);

        String[] thread_num = {"1","10","50","100","200"};
        String[] time_num = {"0","1","2","5","10"};
        for(int i = 0; i < thread_num.length; i++) {
            port_choice_thread.add(thread_num[i]);
            port_choice_time.add(time_num[i]);
        }
        port_choice_time.select(0);
        port_choice_thread.select(1);
        port_jl_thread.setBounds(300,30,60,30);
        Main.jp_port.add(port_jl_thread);
        port_choice_thread.setBounds(370,30,60,30);
        Main.jp_port.add(port_choice_thread);
        port_jl_time.setBounds(300,60,60,30);
        Main.jp_port.add(port_jl_time);
        port_choice_time.setBounds(370,65,60,30);
        Main.jp_port.add(port_choice_time);
        port_jl_num.setBounds(300,100,70,20);
        port_port_num.setText("100");
        Main.jp_port.add(port_jl_num);
        port_port_num.setBounds(370,100,80,20);
        Main.jp_port.add(port_port_num);
        port_jb_set.setBounds(370,140,60,20);
        Main.jp_port.add(port_jb_set);
        port_jb_start.setBounds(300,140,60,20);
        Main.jp_port.add(port_jb_start);
        port_jl_port.setBounds(300,170,40,20);
        Main.jp_port.add(port_jl_port);
        port_ta_port.setBounds(300,200,150,150);
        Main.jp_port.add(port_ta_port);
        port_jb_output.setBounds(370,370,85,20);
        Main.jp_port.add(port_jb_output);

        // 添加事件倾听者和处理者
        port_jb_input.addActionListener(new myListener_port());
        port_jb_output.addActionListener(new myListener_port());
        port_jb_set.addActionListener(new myListener_port());
        port_li_ip.addActionListener(new myListener_port());
        port_jb_start.addActionListener(new myListener_port());
    }
}
