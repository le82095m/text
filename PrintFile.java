package work;

import java.io.File;
import java.util.Objects;

public class PrintFile {
    public static void main(String[] args) {
        File[] files = new File("D:\\Temp").listFiles();
        assert files != null;
        printFiles(files);
    }
    public static void printFiles(File[] files){
        System.out.println("{");
        for(File f : files){
            if(f.isFile()){
                System.out.print(f.getName()+" ");
            }
            if(f.isDirectory()){
                System.out.print(f.getName());
                printFiles(Objects.requireNonNull(f.listFiles()));
            }
        }
        System.out.println("}");
    }
}
