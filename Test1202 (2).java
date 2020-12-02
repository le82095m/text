public class Test2 {
    public static void main(String[] args) {
        Robot r = new Robot();
        System.out.println(r.countWays(3, 2));
    }
}
class Robot {
    public int countWays(int x, int y) {
        if(x == 0 || y == 0){
            return 0;
        }
        if (x == 1 && y == 1) {
            return 0;
        }
        if (x == 1 && y == 2) {
            return 1;
        }
        if (x == 2 && y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}