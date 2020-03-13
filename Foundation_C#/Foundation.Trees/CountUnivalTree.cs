namespace Foundation.Trees {
    public class CountUnivalTree {
        static  int count = 0;
        public bool UnivalTreeCheck(Node root) {
            if(root == null) {
                return true;
            }
            bool left = UnivalTreeCheck(root.left);
            bool right = UnivalTreeCheck(root.right);
            if(left == false || right == false) {
                return false;
            }
            if(root.left != null && root.left.data != root.data) {
                return false;
            }
            if(root.right != null && root.right.data != root.data) {
                return false;
            }
            count++;
            return true;
        }

        public void printCount() {
            System.Console.WriteLine("count of unival tree: " + count);
        }
    }
}