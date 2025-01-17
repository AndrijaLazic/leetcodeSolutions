import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;

        int pointerA = m - 1;
        int pointerB = n - 1;

        if(n == 0)
            return;
        if(m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (nums1[pointerA] < nums2[pointerB]) {
                nums1[i] = nums2[pointerB];
                pointerB--;
                if(pointerB < 0)
                    break;
            }else{
                nums1[i] = nums1[pointerA];
                pointerA--;
                if(pointerA < 0){
                    i--;
                    while (pointerB >= 0){
                        nums1[i] = nums2[pointerB];
                        pointerB--;
                        i--;
                    }
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
//        m.merge(nums1, 3, nums2, 3);
//        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{2,0};
        nums2 = new int[]{1};
        m.merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
