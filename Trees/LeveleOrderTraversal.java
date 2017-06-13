void levelOrder(Node root) {
     Queue queue=new LinkedList();
     queue.add(root);
      while(!queue.isEmpty()){
         // Node tempNode = new Node();
        Node tempNode = (Node)queue.poll();
        System.out.print(tempNode.data + " ");
         if(tempNode.left != null)
           queue.add(tempNode.left);
         if(tempNode.right != null)
          queue.add(tempNode.right);
        }
    }
