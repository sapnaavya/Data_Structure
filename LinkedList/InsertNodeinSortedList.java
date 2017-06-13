Node SortedInsert(Node head,int data) {
    Node newData=new Node();
    newData.data=data;
    newData.next=null;
    newData.prev=null;
    if(head==null)
     {
        return newData;
    }  
    else if(data<=head.data)
        {
        newData.next=head;
        head.prev=newData;
        return newData;
       
        }
    else
        {
        Node prev=head;
        Node current=head.next;
        boolean ins = false;
        while(current!=null)
         {
            if(prev.data<=data && data<=current.data)
                {
                prev.next=newData;
                newData.prev=prev;
                newData.next=current;
                current.prev=newData;
                return head;
            }
            prev=current;
            current=current.next;
        }
        prev.next=newData;
        newData.prev=prev;
      
        return head;
    }
}

