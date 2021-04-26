import javax.swing.*;
import java.awt.*;
import java.io.*;

class JFrameByBadApple {

    public JFrameByBadApple() throws IOException, InterruptedException {

        JFrame  ck = new JFrame();

        //设置ck的位置 最外面的框框
        ck.setBounds(0, 100, 1265, 875);//左 上 宽 高
        JTextArea are = new JTextArea();
        ck.add(are);
        //设置are的位置 字体 以及要读取的文件
        are.setBounds(0, 0, 565, 875);
        are.setFont(new Font("宋体", 2, 15));
        are.setLineWrap(true);
        String path = "D:\\projectonezero\\vptxt";
        File file = new File(path);
        ck.setVisible(true);

        File[] files = file.listFiles();
        //System.out.println(files.length);
        // System.out.println(Arrays.toString(files));
        //Thread.sleep(2000);
        //Arrays.sort(files);
        for (int i = 1; i <= files.length; i++) {

            String fileName = String.format("D:\\projectonezero\\vptxt\\1  (%d).txt", i);

            if (fileName != null){
                InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
                BufferedReader br = new BufferedReader(reader);
                String line="";
                line = br.readLine();
                StringBuilder sb = new StringBuilder();
                while (line != null){
                    sb.append(line+"\r\n");
                    line = br.readLine();
                }
                are.setText(sb.toString());
                Thread.sleep((long)36.5);
                br.close();
            }
        }
    }
}
public class TestDemo {
    public static void main(String[] args) throws Exception {


        String etCommand = "D:\\其他软件\\VLC\\vlc安装\\VLC\\vlc.exe";

        String filePath = "E:\\极乐浄土.mp4";

        Runtime.getRuntime().exec(etCommand + " " + filePath);

        Thread.sleep(4350);
        JFrameByBadApple jFrameByBadApple = new JFrameByBadApple();

    }
}

