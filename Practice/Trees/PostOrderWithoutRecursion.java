void postOrder(Node root) {
    
  Stack<Node> nodes = new Stack<>();
     nodes.push(root); 
     while (!nodes.isEmpty()) {
      Node current = nodes.peek();
     if (current.isLeaf()) { 
      Node node = nodes.pop(); 
      System.out.printf("%s ", node.data); 
      }
      else {
    if (current.right != null) {
      nodes.push(current.right); 
         current.right = null; 
       } 
    if (current.left != null) {
       nodes.push(current.left);
        current.left = null; 
      }
     }
    }
   }
boolean isLeaf(){
    return left == null ? right == null : false; 
} 

