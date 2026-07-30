class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def printList(head):
        while head is not None:
            print(head.val, end="")
            if head.next is not None:
                print(" -> ", end="")
            head = head.next
        print()  # Prints a newline at the end

    @staticmethod
    def buildList(values):
        if not values:  # Checks if the list is empty
            return None

        head = ListNode(values[0])
        current = head
        for i in range(1, len(values)):
            current.next = ListNode(values[i])
            current = current.next
            
        return head
