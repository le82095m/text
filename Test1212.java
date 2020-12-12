public class Test {
    public static void main(String[] args){
        int n = 1;
        for(int i = 0; i < 30; i++){
            n *= 2;
        }
        System.out.println(10*30);
        System.out.println(n);
    }
}
class HasStatic{
    private static int x = 100;

    public static void main(String[] args) {
        HasStatic h1 = new HasStatic();

    }
}