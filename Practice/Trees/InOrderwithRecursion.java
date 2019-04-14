void inOrder(Node root) {
    if(root == null){
        return ;
    }
   
    if(root != null){
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
 
}

}
