import java.util.Scanner;

abstract class Shape {
    public double perimeter() {
        return 0;
    }
    public double area(){
        return 0;
    }
}
class Cycle extends Shape {
    private final double r;
    public Cycle(double r) {
        this.r = r;
    }
    @Override
    public double perimeter() {
        return 2*3.14*this.r;
    }
    @Override
    public double area() {
        return 3.14*this.r*this.r;
    }
}
class Rectangle extends Shape {
    private final double a;
    private final double b;
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double perimeter() {
        return 2*(a+b);
    }
    @Override
    public double area() {
        return a*b;
    }
}
class Square extends Shape {
    private final double a;
    public Square(double a) {
        this.a = a;
    }
    @Override
    public double perimeter() {
        return 4*a;
    }
    @Override
    public double area() {
        return a*a;
    }
}

//public class TestDemo {
//    public static void main(String[] args) {
//        Square square = new Square(10.5);
//        Cycle cycle = new Cycle(15.5);
//        Rectangle rectangle = new Rectangle(10,5.6);
//        shapePerimeter(square);
//        shapeArea(cycle);
//        shapePerimeter(rectangle);
//    }
//    public static void shapePerimeter(Shape shape){
//        System.out.println(shape.perimeter());
//    }
//    public static void shapeArea(Shape shape){
//        System.out.println(shape.area());
//    }
//}

public class TestDemo {
    public static void login(int passWord){
        Scanner sc = new Scanner(System.in);
        int i=0;
        while(true){
            System.out.println("请输入密码");
            int num = sc.nextInt();
            if(passWord == num){
                System.out.println("密码正确");
                break;
            } else {
                System.out.println("密码错误");
            }
            if (i == 2) {
                System.out.println("您的输入已达上限，程序自动退出");
                break;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请设置密码");
        int passWord = sc.nextInt();
        login(passWord);
    }
}