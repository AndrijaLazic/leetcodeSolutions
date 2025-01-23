import java.util.Arrays;
import java.util.HashMap;

public class SolutionTwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return nums;
    }

    public int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            Integer index = numbers.get(target-nums[i]);
            if(index != null && index != i) {
                return new int[]{i, index};
            }
            numbers.put(nums[i], i);
        }
        return nums;
    }

    public static void main(String[] args) {
        SolutionTwoSum s = new SolutionTwoSum();
        int[] nums = {2,7,11,15};
        int target = 13;
        int[] result = s.twoSumOptimal(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
