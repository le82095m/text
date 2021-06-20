import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    /**
     *
     * 有一个由很多木棒构成的集合，每个木棒有对应的长度，
     * 请问能否用集合中的这些木棒以某个顺序首尾相连构成一个面积大于 0 的简单多边形且所有木棒都要用上，
     * 简单多边形即不会自交的多边形。
     *
     * 初始集合是空的，有两种操作，要么给集合添加一个长度为 L 的木棒，
     * 要么删去集合中已经有的某个木棒。
     * 每次操作结束后你都需要告知是否能用集合中的这些木棒构成一个简单多边形。
     *
     */
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();
        int size = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(sc.hasNext()){
            int aor = sc.nextInt();
            int num = sc.nextInt();
            if(aor == 1){
                list.add(num);
                size += num;
            }else{
                if(list.contains(num)) {
                    list.remove((Integer) num);
                    size -= num;
                }
            }
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            boolean tof = judge(list,size);
            if(tof){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    private static boolean judge(List<Integer> list,int size) {
        if(list.size() == 0){
            return false;
        }
        return size - list.get(0) > list.get(0);
    }


    /**
     *
     * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
     * 为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,
     * 0代表这个位置有障碍物,小青蛙达到不了这个位置,1代表小青蛙可以达到的位置。
     * 小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)保证这两个位置都是1,
     * 并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,
     * 向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,
     * 当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
     * 现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
     *
     */

    //思路分析：采用递归的方法分别像上下左右四个方向找出口，找到出口以后与上一条比较是否为更省能量的一条路径，
    //如果是，就更新路径，如果不是，就继续递归。

    private static String road = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] hasPassBy = new boolean[n][m];
        arr = new int[n][m];
        hasPassBy = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                hasPassBy[i][j] = true;
            }
        }
        find(arr,hasPassBy,0,0,p,"");
        System.out.println(road);
    }
    public static void find(int[][] arr,boolean[][] hasPassBy,int r,int l,int p,String tempRoad){
        if(r == 0 && l == arr[0].length-1 && arr[r][l] == 1) {
            if (p >= 0) {
                road = tempRoad + "[0" + "," + l + "]";
            } else {
                road = "Can not escape!";
            }
            return;
        }
        if(r >= 0 && r < arr.length && l >= 0 && l < arr[0].length && hasPassBy[r][l] && arr[r][l] == 1){
            tempRoad += "["+ r + "," + l + "],";
            hasPassBy[r][l] = false;
            find(arr,hasPassBy,r,l+1,p-1,tempRoad);
            find(arr,hasPassBy,r+1,l,p,tempRoad);
            find(arr,hasPassBy,r,l-1,p-1,tempRoad);
            find(arr,hasPassBy,r-1,l,p-3,tempRoad);
        }
    }
}
