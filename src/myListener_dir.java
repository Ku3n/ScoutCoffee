import java.awt.event.*;
import java.io.*;

public class myListener_dir implements ActionListener {
    static String fileName = "";
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String str = actionEvent.getActionCommand();
        if(str.equals(directory.dir_jb_path.getText())) {
            directory.dir_fd_load.setDirectory("./");
            directory.dir_fd_load.setVisible(true);      // 显示文件对话框
            String fileName_new = directory.dir_fd_load.getDirectory() + directory.dir_fd_load.getFile();     // 所选的文件
            fileName = fileName_new;
        }
        if(str.equals(directory.dir_jb_set.getText())) {
            directory.thread_num = Integer.valueOf(directory.dir_choice_thread.getSelectedItem());
            directory.time_num = Integer.valueOf(directory.dir_choice_time.getSelectedItem());
        }
        if(str.equals(directory.dir_jb_output.getText())) {
            directory.dir_fd_save.setVisible(true);
            String fileName = directory.dir_fd_save.getDirectory() + directory.dir_fd_save.getFile();
            try {
                FileWriter writer = new FileWriter(fileName,true);
                String str_dir = directory.dir_path_tf.getText();
                String[] str_output_dir = str_dir.split("\n");
                for(int i = 0; i < str_output_dir.length; i++) {
                    writer.write(str_output_dir[i] + "\n");
                }
                writer.close();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        if(str.equals(directory.dir_jb_start.getText())) {
            new dirFind().dirLode();
        }
    }
}
