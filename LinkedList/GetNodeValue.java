int GetNode(Node head,int n) {
     // This is a "method-only" submission. 
     // You only need to complete this method. 
   if(head.next==null)
         return head.data;
     Node temp=head;
     int count=0;
     while(temp!=null)
         {
         count++;
         temp=temp.next;
     }
    
    int k=count-n-1;
    temp=head;
    while(k>0)
        {
        
         k--;
         temp=temp.next;
    }
    return temp.data;

}

