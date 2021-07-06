package work;

import java.io.*;

public class FileFunction {
    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\Program Files\\test.txt");
//        File file1 = new File("D:\\Program Files\\Java集合框架.png");
//        if(file.exists()){
//            //字符输入文本文件
//            FileReader fr = new FileReader(file);
//            char[] c = new char[1024];
//            int len = 0;
//            while((len=fr.read(c)) != -1){
//                System.out.println(new String(c,0,len));
//            }
//            //字符输入非文本文件
//            FileReader fr1 = new FileReader(file1);
//            char[] c1 = new char[1024];
//            int len1 = 0;
//            while((len1=fr1.read(c1)) != -1){
//                System.out.println(new String(c1,0,len1));
//            }
//            //字节输入文本文件
//            FileInputStream fis = new FileInputStream(file);
//            byte[] b = new byte[1024];
//            int len2 = 0;
//            while((len2 = fis.read(b)) != -1){
//                System.out.println(new String(b,0,len2));
//            }
//            //字节输入非文本文件
//            FileInputStream fr1 = new FileInputStream(file1);
//            byte[] c1 = new byte[1024];
//            int len1 = 0;
//            while((len1=fr1.read(c1)) != -1){
//                System.out.println(new String(c1,0,len1));
//            }
//        }
//        //复制文件
//        File file = new File("D:\\Program Files\\test.txt");
//        File file1 = new File("D:\\Program Files\\newTest.txt");
//        if(!file1.exists()){
//            file1.createNewFile();
//        }
//        FileInputStream fr = new FileInputStream(file);
//        FileOutputStream fw = new FileOutputStream(file1);
//        byte[] bytes = new byte[1024];
//        int len = 0;
//        while ((len = fr.read(bytes)) != -1){
//            fw.write(bytes,0,len);
//        }
//        fr.close();
//        fw.close();
//        FileInputStream fis = new FileInputStream(file1);
//        byte[] b = new byte[1024];
//        int len2 = 0;
//        while((len2 = fis.read(b)) != -1){
//            System.out.println(new String(b,0,len2));
//        }
        //使用字节缓冲流复制文件
        File file = new File("D:\\Program Files\\test.txt");
        File file1 = new File("D:\\Program Files\\newTest.txt");
        FileInputStream fr = new FileInputStream(file);
        FileOutputStream fw = new FileOutputStream(file1);
        BufferedInputStream buffRead = new BufferedInputStream(fr);
        BufferedOutputStream buffWrite = new BufferedOutputStream(fw);
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = buffRead.read(bytes)) != -1){
            buffWrite.write(bytes,0,len);
        }
        buffWrite.flush();
        buffWrite.close();
        buffRead.close();
        FileInputStream fis = new FileInputStream(file1);
        byte[] b = new byte[1024];
        int len2 = 0;
        while((len2 = fis.read(b)) != -1){
            System.out.println(new String(b,0,len2));
        }
    }
}
