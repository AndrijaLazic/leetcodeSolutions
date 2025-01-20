import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray2 {
    public int removeDuplicates(int[] nums) {

        //K represents number of duplicates to remain
        int k = 2;
        int leftPointer = k;
        for(int i=k;i<nums.length;i++){
            if(nums[i] > nums[leftPointer-k]){
                nums[leftPointer] = nums[i];
                leftPointer++;
            }
        }
        return leftPointer;
    }


    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray2 r = new RemoveDuplicatesfromSortedArray2();
        int[] nums = {0,0,1,1,1,2,3,3};
        System.out.println(r.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
