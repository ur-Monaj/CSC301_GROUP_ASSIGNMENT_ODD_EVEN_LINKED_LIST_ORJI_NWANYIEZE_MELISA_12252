
class ListNode {
    int val;
    ListNode next;

    // Create a node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    public static ListNode oddEvenList(ListNode head) {

        // Step 1: Handle an empty list or a list with one node
        if (head == null || head.next == null) {
            return head;
        }

        // Step 2: Create pointers
        ListNode odd = head;
        ListNode even = head.next;

        // Remember the beginning of the even list
        ListNode evenHead = even;

        // Step 3: Rearrange the links
        while (even != null && even.next != null) {

            // Connect the current odd node to the next odd node
            odd.next = even.next;

            // Move odd to the next odd node
            odd = odd.next;

            // Connect the current even node to the next even node
            even.next = odd.next;

            // Move even to the next even node
            even = even.next;
        }

        // Step 4: Attach the even list after the odd list
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {

        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Call the method
        head = oddEvenList(head);

        // Print the result
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}
