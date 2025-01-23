public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 1)
            return nums[0] >= target ? 1 : 0;

        int left = 0;
        int right = 0;
        int minSubArraySize = -1;
        int currentSum = nums[0];
        while (true){

            if(currentSum < target && right != nums.length - 1){
                right++;
                currentSum = currentSum + nums[right];
                continue;
            }

            int subArraySize = right - left + 1;

            if(currentSum >= target &&
                    (subArraySize < minSubArraySize || minSubArraySize == -1)){
                minSubArraySize = subArraySize;
                if(minSubArraySize == 1)
                    return 1;
            }
            if(left == right && left == nums.length - 1)
                break;
            currentSum = currentSum - nums[left];
            left++;
        }
        return minSubArraySize != -1 ? minSubArraySize : 0;

    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(m.minSubArrayLen(7, nums));
    }
}
