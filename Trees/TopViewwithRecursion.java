void topView(Node root) {
       if(root == null) return;

        printLeftTopView(root.left);
        System.out.print(root.data + " ");
        printRightTopView(root.right);

        System.out.println("");
    }

    public static void printLeftTopView(Node root){
        if(root == null) return;
        printLeftTopView(root.left);
        System.out.print(root.data + " ");
    }

    public static void printRightTopView(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        printRightTopView(root.right);
    }
