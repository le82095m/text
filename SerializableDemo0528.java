package v3;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User u1 = new User(1,"张三","男");
        User u2 = new User(2,"李四","女");

        //把u1和u2对应的对象，序列化，并写入文件中

        String filename = "D:\\JavaDemo\\HTTPServletStude\\Sessions\\users.obj";
//        try(OutputStream outputStream = new FileOutputStream(filename)) {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//
//            objectOutputStream.writeObject(u1);
//            objectOutputStream.writeObject(u2);
//        }
        try(InputStream inputStream = new FileInputStream(filename)){
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            User U1 = (User) objectInputStream.readObject();
            User U2 = (User) objectInputStream.readObject();

            System.out.println(U1);
            System.out.println(U2);
        }
    }
}
