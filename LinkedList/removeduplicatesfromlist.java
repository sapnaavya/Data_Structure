Node RemoveDuplicates(Node head) {
  // This is a "method-only" submission. 
  // You only need to complete this method.
    if(head == null || head.next == null){
        return head;
    }
    Node current =  head;
    while(current != null && current.next != null){
        if(current.data == current.next.data){
            current.next = current.next.next;
        }
        else{
            current = current.next;
        }
        
    }
    return head;

}
