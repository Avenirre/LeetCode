package com.topQuestions;

public class SortSearchProblems {

    public static void main(String[] args) {

    }

    //You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    // and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    //Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //Output: [1,2,2,3,5,6]
    //Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
   //The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int arr1Index = m - 1;
        int arr2Index = n - 1;

        // And move i backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int i = m + n - 1; i >= 0; i--) {
            if (arr2Index < 0) {
                break;
            }
            if (arr1Index >= 0 && nums1[arr1Index] > nums2[arr2Index]) {
                nums1[i] = nums1[arr1Index--];
            } else {
                nums1[i] = nums2[arr2Index--];
            }
        }
    }

}
