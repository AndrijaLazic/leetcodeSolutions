import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int numOfElements = nums.length;
        int valElements = 0;

        int rightPointer = numOfElements-1;
        for(int i=0;i<=rightPointer;i++){
            if(nums[i] != val)
                continue;
            while(rightPointer > i && nums[rightPointer] == val){
                valElements++;
                rightPointer--;
            }

            int temp = nums[i];
            nums[i] = nums[rightPointer];
            nums[rightPointer] = temp;

            valElements++;
            rightPointer--;
        }
        return numOfElements - valElements;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] nums = {1};
        System.out.println(r.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }
}
