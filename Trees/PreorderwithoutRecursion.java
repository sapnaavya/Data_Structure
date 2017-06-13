void preOrder(Node root) {
 Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    while (!stack.isEmpty()){
        Node currentNode = stack.pop();
        if (currentNode.right != null){
            stack.push(currentNode.right);
        }

        if (currentNode.left != null){
            stack.push(currentNode.left);
        }

        System.out.print(currentNode.data+" ");
    }
}
