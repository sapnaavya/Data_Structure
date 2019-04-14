int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
  
    Node temp = new Node();
    while(headA != null)
        {
        temp=headB;
        while(temp!=null)
            {
        if(headA==temp)
            {
              return temp.data;
            }
            temp=temp.next;
            
        }
        
        headA=headA.next;
    }
    
    return headA.data;

}

