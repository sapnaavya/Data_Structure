void inOrder(Node root) {
    Stack<Node> nodes = new Stack<>();
    Node current = root; 
      while (!nodes.isEmpty() || current != null) {
           if (current != null) {
               nodes.push(current); 
               current = current.left; 
           } else {
               Node node = nodes.pop();
               System.out.printf("%s ", node.data); 
               current = node.right;
           } 
      }


}

