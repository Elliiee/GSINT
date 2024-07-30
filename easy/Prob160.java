package easy;

public class Prob160 {
    //160. Intersection of Two Linked Lists
    public ListNode getIntersectioNode(ListNode headA, ListNode headB){
        ListNode l1 = headA; 
        ListNode l2 = headB;
        while (l1 != l2){
            l1 = l1 == null ? headB : l1.next; 
            l2 = l2 == null ? headA : l2.next; 
        }
        return l1; //return l2 is the same, l1 and l2 meet at this point 
    }
}
