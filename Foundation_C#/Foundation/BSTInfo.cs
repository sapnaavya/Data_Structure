using System;
namespace Foundation {
    public class BSTInfo {
        public int num_bst;
        public int min;
        public int max;
        public bool is_bst;
        public BSTInfo(int num_bst, int min, int max, bool is_bst) {
            this.num_bst = num_bst;
            this.min = min;
            this.max = max;
            this.is_bst = is_bst;
        }

        public BSTInfo() {

        }
    }
}