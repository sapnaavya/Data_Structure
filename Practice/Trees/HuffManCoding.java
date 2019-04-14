void decode(String S ,Node root)
    {
   Node n = root;
    for (int i = 0; i < S.length(); i++) {
        n = S.charAt(i) == '0' ? n.left : n.right;
        if (n.left == null && n.right == null) {
            System.out.print(n.data);
            n = root;
        } 
    }
}

