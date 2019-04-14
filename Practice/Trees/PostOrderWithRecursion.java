/yelp_training_set_user
stOrder(Node root) {
    
    if(root == null){
        return ;
    }
   
    if(root != null){
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
 }
}
