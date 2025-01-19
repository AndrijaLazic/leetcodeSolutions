import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int currentValue = -101;
        int i = 0;
        for (; i < length; i++) {
            if(nums[i] != currentValue && nums[i]!=-101){
                currentValue = nums[i];
                continue;
            }
            int rightPointer = i;
            while (rightPointer < length &&
                    (nums[rightPointer] == currentValue || nums[rightPointer] == -101)){
                nums[rightPointer] = -101;
                rightPointer++;
            }

            if(rightPointer == length)
                return i;
            nums[i] = nums[rightPointer];
            currentValue = nums[i];
            nums[rightPointer] = -101;

            if(rightPointer == length-1)
                return i + 1;
        }

        return i;
    }

    public int removeDuplicatesOptimal(int[] nums){
        int leftPointer = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[leftPointer]){
                continue;
            }
            leftPointer++;
            nums[leftPointer] = nums[i];
        }
        return leftPointer+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
        int[] nums = {-50,-50,-49,-48,-47,-47,-47,-46,-45,-43,-42,-41,-40,-40,-40,-40,-40,-40,-39,-38,-38,-38,-38,-37,-36,-35,-34,-34,-34,-33,-32,-31,-30,-28,-27,-26,-26,-26,-25,-25,-24,-24,-24,-22,-22,-21,-21,-21,-21,-21,-20,-19,-18,-18,-18,-17,-17,-17,-17,-17,-16,-16,-15,-14,-14,-14,-13,-13,-12,-12,-10,-10,-9,-8,-8,-7,-7,-6,-5,-4,-4,-4,-3,-1,1,2,2,3,4,5,6,6,7,8,8,9,9,10,10,10,11,11,12,12,13,13,13,14,14,14,15,16,17,17,18,20,21,22,22,22,23,23,25,26,28,29,29,29,30,31,31,32,33,34,34,34,36,36,37,37,38,38,38,39,40,40,40,41,42,42,43,43,44,44,45,45,45,46,47,47,47,47,48,49,49,49,50};
        System.out.println(r.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
