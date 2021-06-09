class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
public class NC40 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        String s1 = listToIntFunction(head1);
        String s2 = listToIntFunction(head2);
        StringBuilder s = new StringBuilder();
        String maxS = s1.length() > s2.length() ? s1 : s2;
        String minS = s1.length() > s2.length() ? s2 : s1;
        int a = 0;
        int i = 0;
        for(; i < minS.length(); i++){
            int num = (maxS.charAt(i)-'0')+(minS.charAt(i)-'0')+a;
            if(num > 9){
                num = num%10;
                a = 1;
            }else{
                a = 0;
            }
            s.insert(0,num);
        }
        for(;i < maxS.length(); i++){
            int num = (maxS.charAt(i)-'0')+a;
            if(num > 9){
                num = num%10;
                a = 1;
            }else{
                a = 0;
            }
            s.insert(0,num);
        }
        if(a == 1){
            s.insert(0,1);
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(char c : s.toString().toCharArray()){
            cur.next = new ListNode(c-'0');
            cur = cur.next;
        }
        return head.next;
    }

    public static String listToIntFunction(ListNode head1) {
        StringBuilder sb = new StringBuilder();
        while(head1 != null){
            sb.insert(0, head1.val + "");
            head1 = head1.next;
        }
        return sb.toString();
    }
}
