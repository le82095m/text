package serializable;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User u1 = new User(1, "张三", "男");
        User u2 = new User(2, "李四", "女");

        String filename = "D:\\JavaDemo\\myTomcat\\session\\users.obj";

//        try (OutputStream outputStream = new FileOutputStream(filename)) {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//
//            objectOutputStream.writeObject(u1);
//            objectOutputStream.writeObject(u2);
//
//            outputStream.flush();
//        }

        try(InputStream inputStream = new FileInputStream(filename)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            User uu1 = (User)objectInputStream.readObject();
            User uu2 = (User)objectInputStream.readObject();

            System.out.println(uu1);
            System.out.println(uu2);
        }
    }
}
