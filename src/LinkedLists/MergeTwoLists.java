package LinkedLists;

public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) { 
            this.val = val; 
        }
        
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(0);
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode dummy = prev;

        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                prev.next = current1;
                current1 = current1.next;
                prev = prev.next;
            } 
            else {
                prev.next = current2;
                current2 = current2.next;
                prev = prev.next;
            } 
        } 

        prev.next = (current1 != null) ? current1 : current2;
        return dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoLists mtl = new MergeTwoLists();

        // Build Sorted List 1: 1 -> 2 -> 4 -> null
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Build Sorted List 2: 1 -> 3 -> 4 -> null
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Execute the merge algorithm and display output
        System.out.print("Output: ");
        printList(mtl.mergeTwoLists(list1, list2));
    }
}
