import java.util.PriorityQueue;

class findKthLargest{
    public int findKthLargest(int[] arr, int k){
        //heap to store the k largest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            if(i<k){
                pq.add(arr[i]); //add the first k elements to the heap
            } else{
                //if the current element is greater than the smallest in the heap(root)
                if(arr[i] > pq.peek()){
                    pq.poll(); //remove the smallest element
                    pq.add(arr[i]); //dd the current element
                }
            }
        }

        return pq.peek(); //return the root (kth largest element)
    }

    public static void main(String[] args){
        findKthLargest sol = new findKthLargest();

        int[] arr = {3,2,1,5,6,4};
        int k = 3;

        int ans = sol.findKthLargest(arr, k);

        System.out.println(ans);
    }
};