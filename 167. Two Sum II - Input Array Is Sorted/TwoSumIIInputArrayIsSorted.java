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

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted t = new TwoSumIIInputArrayIsSorted();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(t.twoSum(nums, target)));



    }
}
