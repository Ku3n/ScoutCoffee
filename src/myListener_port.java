import java.awt.event.*;
import java.io.*;

public class myListener_port implements ActionListener,ItemListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String str = actionEvent.getActionCommand();
        if(str.equals(portScan.port_jb_input.getText())) {
            portScan.port_fd_load.setDirectory("./");
            portScan.port_fd_load.setVisible(true);      // 显示文件对话框
            String fileName = portScan.port_fd_load.getDirectory() + portScan.port_fd_load.getFile();     // 所选的文件
            try {
                FileReader reader = new FileReader(fileName);
                BufferedReader port_reader = new BufferedReader(reader);
                String str_port;
                while ((str_port = port_reader.readLine()) != null) {
                    portScan.port__sb_list.append(str_port + "\n");
                }
                reader.close();
            }catch (Exception e) {}
            portScan.port_str_list = portScan.port__sb_list.toString().split("\n");
            for(String str_add : portScan.port_str_list)
                portScan.port_li_ip.add(str_add);
        }
        if(str.equals(portScan.port_jb_output.getText())) {
            portScan.port_fd_save.setVisible(true);
            String fileName = portScan.port_fd_save.getDirectory() + portScan.port_fd_save.getFile();
            try {
                FileWriter writer = new FileWriter(fileName,true);
                String str_port = portScan.port_ta_port.getText();
                String[] str_output_port = str_port.split("\n");
                for(int i = 0; i < str_output_port.length; i++) {
                    writer.write(str_output_port[i] + "\n");
                }
                writer.close();
            }catch (Exception e) {}
        }
        if(str.equals(portScan.port_jb_set.getText())) {
            portScan.thread_num = Integer.valueOf(portScan.port_choice_thread.getSelectedItem());
            portScan.time_num = Integer.valueOf(portScan.port_choice_time.getSelectedItem());
        }
        if(str.equals(portScan.port_jb_start.getText())) {
            new portFind().portLode();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }
}
