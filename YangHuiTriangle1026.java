package List;

//        1
//      1   1
//    1   2   1
//  1   3   3   1
//1   4   6   4   1

//[[1],[1,1],[1,2,1][1,3,3,1][1,4,6,4,1]]
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

//创建两个线性表，一个线性表存放数据，一个线性表存放上个线性表
public class YangHuiTriangle {
    public void Triangle(int num) {
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> col = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else{
                    List<Integer>temp = col.get(i-1);
                    row.add(temp.get(j-1)+temp.get(j));
                }
            }
            col.add(row);

        }
        int j = num;
        for (int i = 0;i < num;i++){
            for ( j = num-i ; j > 0;j--){
                System.out.print(" ");
            }
            System.out.println(col.get(i));
        }
//            row = new ArrayList<>();
//            row.add(1);
//            row.add(1);
//            col.add(row);
//            row = new ArrayList<>();
//            row.add(1);
//            row.add(2);
//            row.add(1);
//            col.add(row);
//            row = new ArrayList<>();
//            row.add(1);
//            row.add(3);
//            row.add(3);
//            row.add(1);
//            col.add(row);
//            System.out.println(col);
        }
    }
