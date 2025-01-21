import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int numsLength = nums.length;
        k = k % numsLength;

        for (int i = 0; i < k; i++) {
            int transferValue = nums[0];
            int index = 0;
            int numOfRotations = 0;
            while (numOfRotations <= numsLength){
                int temp = nums[index];
                nums[index] = transferValue;
                transferValue = temp;

                index = index + 1;
                if(index >= numsLength)
                    index = index % numsLength;

                numOfRotations++;
            }
        }
    }

    public void rotateOptimal(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        r.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
