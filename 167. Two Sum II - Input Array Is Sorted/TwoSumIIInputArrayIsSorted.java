import java.util.Arrays;
import java.util.HashMap;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = numbers.length - 1; i >= 0 ; i--) {
            Integer index1 = map.get(target - numbers[i]);
            if (index1 != null) {
                return new int[]{i + 1, index1 + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public int[] twoSumOptimal(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left <= right){
            int value = numbers[left] + numbers[right];
            if(value > target){
                right = Arrays.binarySearch(numbers , target - numbers[left]);
                if(right < 0)
                    right = -right - 2;
            } else if (value < target) {
                left = Arrays.binarySearch(numbers , target - numbers[right]);
                if(left < 0)
                    left = -left - 1;
            }else {
                if(left == right){
                    //this is only because of possibility of duplicates
                    if (left - 1 >= 0 && numbers[left - 1] == numbers[left]){
                        left--;
                    }else {
                        right++;
                    }
                }

                return new int[]{left + 1, right + 1};
            }
        }

        return null;
    }

//    twoPointersSolution{
//        int l = 0, r = nums.length - 1;
//
//        while (nums[l] + nums[r] != target) {
//            if (nums[l] + nums[r] < target) l++;
//            else r--;
//        }
//
//        return new int[] {l+1, r+1};
//    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        int[] nums = {-1,-1,1,1,1,1,1,1,1,1,1};
        int target = -2;
        System.out.println(Arrays.toString(t.twoSumOptimal(nums, target)));
    }
}
