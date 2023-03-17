package com.topQuestions;

import java.util.*;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,5,6,7,7};
        removeDuplicatesFromSortedArray(nums);
        rotateArrayBySteps1(nums, 2);
    }

    private static int removeDuplicatesFromSortedArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    //Input: nums = [1,2,3,4,5,6,7], k = 3
    //Output: [5,6,7,1,2,3,4]
    //Explanation:
    //rotate 1 steps to the right: [7,1,2,3,4,5,6]
    //rotate 2 steps to the right: [6,7,1,2,3,4,5]
    //rotate 3 steps to the right: [5,6,7,1,2,3,4]
    public static void rotateArrayBySteps1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void rotateArrayBySteps2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    //On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
    //Find and return the maximum profit you can achieve.

    public static int countMaxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }


    public static boolean isContainsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int i = 0;i <= nums.length - 1;i++){
            if (map.contains(nums[i])){
                return true;
            }
            map.add(nums[i]);
        }

        return false;
    }


    public static int isSingleNumberExist1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    public static int isSingleNumberExist2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    //If nums1 is larger than nums2, swap the arrays.
    //For each element in nums1:
    //Add it to the hash map m - increment the count if the element is already there.
    //Initialize the insertion pointer (k) with zero.
    //Iterate along nums2:
    //If the current number is in the hash map and count is positive:
    //Copy the number into nums1[k], and increment k, decrement the count in the hash map.
    //Return first k elements of nums1.
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }


    //Input: digits = [1,2,3]
    //Output: [1,2,4]
    //Explanation: The array represents the integer 123.
    //Incrementing by one gives 123 + 1 = 124.
    //Thus, the result should be [1,2,4].
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; idx--) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            } else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    //Given an integer array nums, move all 0's to the end of it while
    // maintaining the relative order of the non-zero elements.
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    public void moveZeroes1(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i <= nums.length-1; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i <= nums.length-1; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[]result = new int[2];

        for (int i=0; i <= nums.length-1; i++){
            Integer elementIndex = map.get(nums[i]);
            if (elementIndex != null) {
                result[0] = elementIndex;
                result[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }


}



