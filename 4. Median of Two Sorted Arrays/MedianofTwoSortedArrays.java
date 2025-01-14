public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numOfElements = nums1.length + nums2.length;
        int medianElementIndex = numOfElements / 2 + numOfElements%2;

        int i = 0;
        int j = 0;
        int currentElementIndex = 0;
        int currentArray = 0;
        int currentArrayIndex = 0;
        while (currentElementIndex<medianElementIndex){
            if(
                    (j >= nums2.length)
                    || (i < nums1.length && nums1[i] <= nums2[j])
            ){
                currentArray = 0;
                currentArrayIndex = i;
                i++;
            }
            else if(
                    (i >= nums1.length)
                    || (j < nums2.length && nums2[j] <= nums1[i])
            ){
                currentArray = 1;
                currentArrayIndex = j;
                j++;
            }
            currentElementIndex++;
        }

        double sum;
        if(currentArray == 0){
            sum = nums1[currentArrayIndex];
        }else{
            sum = nums2[currentArrayIndex];
        }

        if(numOfElements%2==0){
            if(i >= nums1.length){
                sum += nums2[j];
            }
            else if (j>=nums2.length) {
                sum += nums1[i];
            }
            else if(nums1[i] <= nums2[j]){
                sum += nums1[i];
            }
            else if(nums2[j] <= nums1[i]){
                sum += nums2[j];
            }
            sum = sum/2.0;
        }
        return sum;
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays med = new MedianofTwoSortedArrays();
        System.out.println(med.findMedianSortedArrays(new int[]{}, new int[]{1,2,3}));
    }
}
