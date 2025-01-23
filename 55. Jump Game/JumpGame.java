public class JumpGame {
    public boolean canJump(int[] nums) {

        for (int i = nums.length - 2; i >=0 ; i--) {
            if(nums[i] != 0)
                continue;

            int j = i - 1;
            while (j >= 0) {
                if(nums[j]!=0) {
                    if(nums[j] + j > i) {
                        break;
                    }
                }
                j--;
            }
            if(j < 0)
                return false;
            i = j;
        }
        return true;

    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
//        int[] nums = {2,3,1,1,4};
//        System.out.println(j.canJump(nums));

        int[] nums2 = {3,2,1,0,4};
        System.out.println(j.canJump(nums2));
    }
}
