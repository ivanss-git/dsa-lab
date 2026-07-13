package LinkedLists;

public class ReorderLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }  

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // Fixed: must move 2 steps
        }
        
        ListNode secondHalf = slow.next;
        slow.next = null; // cut

        ListNode prev = null;
        ListNode curr = secondHalf;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev; // prev is the head of the reversed half

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        ReorderLinkedList rll = new ReorderLinkedList();
        ListNode list = new ListNode(1);
        list.next = new ListNode(2); 
        list.next.next = new ListNode(3); 
        list.next.next.next = new ListNode(4); 
        list.next.next.next.next = new ListNode(5); 
        
        rll.reorderList(list);
        
        System.out.print("Output: ");
        ListNode curr = list;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
    } 
}

