package easy;
//83. Remove Duplicates from Sorted List
public class Prob83 {
    public ListNode removeDup(ListNode head){
        ListNode current = head; 
        while (current != null && current.next != null){
            if (current.val == current.next.val){
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }
        return head; 
    }
}
