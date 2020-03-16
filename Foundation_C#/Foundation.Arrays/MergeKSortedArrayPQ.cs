namespace Foundation.Arrays {
    public class MergeKSortedArrayPQ {
        public int[] Merge_kSorted_UsingPQ(int[][] arr) {
            PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
            int size = 0;

            //add first elements of each array in priority queue.. i.e. add every row's first element
            //every row represents one array
            for(int i = 0; i < arr.Length; i++) {
                size += arr[i].Length;
                if(arr[i].Length > 0) {
                    pq.Enqueue(new QueueNode(i, 0, arr[i][0]));
                }
            }
            int[] result = new int[size];
            for(int i = 0; pq.Count() != 0; i++) {
                QueueNode node = pq.Dequeue();
                result[i] = node.Value;
                int newIndex = node.Index + 1 ;
                if(newIndex < arr[node.Array].Length) {
                    pq.Enqueue(new QueueNode(node.Array, newIndex, arr[node.Array][newIndex]));
                }
            }
            return result;
        }
    }
}