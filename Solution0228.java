import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    /**
     * 实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如 :
     * 当字符串为 We Are Happy.
     * 则经过替换之后的字符串为 We%20Are%20Happy。
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer(s);
        char[] c = new char[]{'%', '2', '0'};
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                str.insert(i, c);
            }
        }
        return str.substring(0, str.length());
    }

    public int[] reOrderArray0(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex < endIndex) {
            while (startIndex < array.length) {
                if (array[startIndex] % 2 == 0) {
                    break;
                }
                startIndex++;
            }
            while (endIndex >= 0) {
                if (array[endIndex] % 2 != 0) {
                    break;
                }
                endIndex--;
            }
            if (startIndex == array.length || endIndex < 0) {
                return array;
            }
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return array;
    }

    //1，插排思想，从后往前遍历，找到第一个遇见的奇数记录下标,
    //再从下标处向前遍历找到第一个遇见的偶数，将其插到记录下标的后一位
    //1,2,3,5,7,4,6,8
    public int[] reOrderArray1(int[] array) {
        int addIndex = array.length - 1;
        if (addIndex < 0) {
            return array;
        }
        int evenIndex = 0;
        while (true) {
            if (array[addIndex] % 2 != 0) {
                evenIndex = addIndex;
                while (true) {
                    if (array[evenIndex] % 2 == 0) {
                        int temp = array[evenIndex];
                        for (int i = evenIndex; i < addIndex; i++) {
                            array[i] = array[i + 1];
                        }
                        array[addIndex] = temp;
                        addIndex--;
                    }
                    evenIndex--;
                    if (evenIndex < 0) {
                        return array;
                    }
                }
            }
            addIndex--;
            if (addIndex < 0) {
                return array;
            }
        }
    }

    public int[] reOrderArray2(int[] array) {
        List<Integer> listAdd = new ArrayList<>();
        List<Integer> listEver = new ArrayList<>();
        for (int a : array){
            if(a % 2 != 0){
                listAdd.add(a);
            }else{
                listEver.add(a);
            }
        }
        listAdd.addAll(listEver);
        int[] newArray = new int[listAdd.size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = listAdd.get(i);
        }
        return newArray;
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0){
            return null;
        }
        int lowIndex = 0;
        int rowIndex = 0;
        int row = matrix.length;
        int low = matrix[0].length;
        int i = 0;
        int j = 1;
        // [ 1, 2, 3, 4]
        // [12,13,14, 5]
        // [11,16,15, 6]
        // [10, 9, 8, 7]
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            while(lowIndex < low){
                list.add(matrix[rowIndex][lowIndex]);
                lowIndex++;
            }
            lowIndex--;
            while(rowIndex < row){
                list.add(matrix[rowIndex][lowIndex]);
                rowIndex++;
            }
            rowIndex--;
            while(lowIndex > i-1){
                list.add(matrix[rowIndex][lowIndex]);
                lowIndex--;
            }
            lowIndex++;
            while(rowIndex > j-1){
                list.add(matrix[rowIndex][lowIndex]);
                rowIndex--;
            }
            rowIndex++;
            if(list.size() == matrix[0].length*matrix.length){
                break;
            }
            i++;
            j++;
            row--;
            low--;
        }
        return list;
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        Node newHead = new Node(head.val);
        Node newCur = newHead;
        while(cur.next != null){
            cur = cur.next;
            newCur.next = new Node(cur.val);
            newCur = newCur.next;
        }
        cur = newHead;
        Map<Node,Node> map = new HashMap<>();
        while (cur != null && head != null){
            map.put(head,cur);
            cur.random = head.random;
            cur = cur.next;
            head = head.next;
        }
        cur = newHead;
        while (cur != null){
            cur.random = map.getOrDefault(cur.random,null);
            cur = cur.next;
        }
        return newHead;
    }
}