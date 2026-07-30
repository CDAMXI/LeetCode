from ListNode import ListNode

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    dummy_head = ListNode(0)
    current = dummy_head
    carry = 0
    
    while l1 is not None or l2 is not None or carry != 0:
        val1 = l1.val if l1 is not None else 0
        val2 = l2.val if l2 is not None else 0
        
        # Calculate sum and the carry for the next decimal place
        total = val1 + val2 + carry
        carry = total // 10
        
        # Create new node with the single digit
        current.next = ListNode(total % 10)
        current = current.next
        
        # Move forward in the lists if possible
        if l1 is not None: l1 = l1.next
        if l2 is not None: l2 = l2.next
            
    return dummy_head.next

# --- Main execution ---
if __name__ == "__main__":
    # l1 = 2 -> 4 -> 3
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)

    # l2 = 5 -> 6 -> 4
    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)

    # Calculate and print
    result_head = addTwoNumbers(l1, l2)
    ListNode.printList(result_head)
    