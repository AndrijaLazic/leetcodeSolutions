import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int numsLength = nums.length;
        int numForMajority = numsLength / 2;
        int majorityElement = nums[0];

        Dictionary<Integer, Integer> dictionary = new Hashtable<>();
        dictionary.put(majorityElement, 1);

        for (int i = 1; i < numsLength; i++) {
            Integer value = dictionary.get(nums[i]);
            if (value == null){
                dictionary.put(nums[i], 1);
                continue;
            }
            value = value + 1;
            dictionary.put(nums[i], value);
            if (value > numForMajority){
                majorityElement = nums[i];
                break;
            }

        }
        return majorityElement;
    }

    public int majorityElementOptimal(int[] nums) {
        int numsLength = nums.length;
        int majorityElement = nums[0];
        int majorityCount = 1;

        for (int i = 1; i < numsLength; i++) {
            if(nums[i] == majorityElement){
                majorityCount++;
                continue;
            }
            if(nums[i] != majorityElement)
                majorityCount--;
            if(majorityCount == 0){
                majorityElement = nums[i];
                majorityCount = 1;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(m.majorityElement(nums));
        System.out.println(Arrays.toString(nums));
    }
}
