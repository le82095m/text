package nowcoder;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * */

public class JZ55 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode nodeA = pHead;
        ListNode nodeB = pHead;
        while(nodeA != null && nodeB.next != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next.next;
            if(nodeA == nodeB){
                break;
            }
        }
        if(nodeA == null || nodeB.next == null){
            return null;
        }
        nodeA = pHead;
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
}
