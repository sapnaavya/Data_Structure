static int height(Node root) {
      	// Write your code here.
    if (null == root){
        return 0;
    }
    int hLeftSub = heightOfTree(root.left);
    int hRightSub = heightOfTree(root.right);
    return Math.max(hLeftSub, hRightSub) + 1;
}

