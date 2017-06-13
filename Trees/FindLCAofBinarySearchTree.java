static Node lca(Node root,int p,int q)
    {
     Node m = root;
    if(m.data > p && m.data < q){
        return m;  
    }else if(m.data>p && m.data > q){
        return lca(root.left, p, q);
    }else if(m.data<p && m.data < q){
        return lca(root.right, p, q);
    }
 
    return root;
}
  
