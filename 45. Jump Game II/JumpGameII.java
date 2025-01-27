public class JumpGameII {
    public int jump(int[] nums) {
        int minJumps = 0;

        for (int i = nums.length - 1; i > 0; i--) {

            int farthestIndex = 0;
            int leftPointer = i - 1;
            while (leftPointer >= 0) {
                if(nums[leftPointer] != 0 ) {
                    if(nums[leftPointer] + leftPointer >= i){
                        farthestIndex = leftPointer;
                    }
                }
                leftPointer--;
            }
            i = farthestIndex + 1;
            minJumps++;
        }

        return minJumps;
    }

    public int jumpOptimal(int[] nums){
        int minJumps = 0;
        int numsLength = nums.length - 1;

        int furthestIndex = 0;
        int rightScopeIndex = 0;

        for (int i = 0; i < numsLength; i++) {

            int currentFurthestIndex = nums[i] + i;
            if (currentFurthestIndex >= numsLength) {
                return minJumps + 1;
            }
            furthestIndex = Math.max(currentFurthestIndex, furthestIndex);

            if(rightScopeIndex == i){
                minJumps++;
                rightScopeIndex = furthestIndex;
            }
        }

        return minJumps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new JumpGameII().jumpOptimal(nums));
    }
}
