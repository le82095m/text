import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] credits = new int[num];
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            credits[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }
        double cgp = 0;
        int cre = 0;
        for (int i = 0; i < num; i++) {
            cgp += CGP(score[i],credits[i]);
            cre += credits[i];
        }
        System.out.printf("%.2f",cgp/cre);
    }
    public static double CGP(int score, int credits){
        double res = 0;
        if(score > 100){
            res = 0;
        }else if(score >= 90){
            res = 4.0*credits;
        }else if(score >= 85){
            res = 3.7*credits;
        }else if(score >= 82){
            res = 3.3*credits;
        }else if(score >= 78){
            res = 3.0*credits;
        }else if(score >= 75){
            res = 2.7*credits;
        }else if(score >= 72){
            res = 2.3*credits;
        }else if(score >= 68){
            res = 2.0*credits;
        }else if(score >= 64){
            res = 1.5*credits;
        }else if(score >= 60){
            res = 1.0*credits;
        }else {
            res = 0.0*credits;
        }
        return res;
//         return new BigDecimal(res).setScale(2,BigDecimal.ROUND_HALF_UP)
//         .doubleValue();
    }
}
