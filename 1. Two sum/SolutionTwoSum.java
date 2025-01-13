import java.util.Arrays;

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

    public static void main(String[] args) {
        SolutionTwoSum s = new SolutionTwoSum();
        int[] nums = {2,7,11,15};
        int target = 13;
        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
