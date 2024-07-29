package com.topQuestions.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointersTrainings {

    public static void main(String[] args) {
//        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
//        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
//        System.out.println(intervalIntersections(firstList, secondList));

//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));

          int[] nums1 = {-1,0,1,2,-1,-4};
          threeSum(nums1);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Skip duplicate elements for j
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }

                    // Skip duplicate elements for k
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }

                    // Move the pointers
                    start++;
                    end--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    start++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    end--;
                }
            }
        }
        return ans;
    }

    private static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int start = i + 1;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[i] + nums[start] + nums[end];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                while (start < end && nums[start] != nums[start - 1]) {
                    start++;
                }
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> intersections = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                //[1,4], [2,3]
                end = Math.max(end, intervals[i][1]);
            } else {
                intersections.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }

            if (i == intervals.length - 1) {
                intersections.add(new int[]{start, end});
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }


    private static int[][] intervalIntersections(int[][] firstList, int[][] secondList) {
        int firstListLength = firstList.length;
        int secondListLength = secondList.length;

        if (firstListLength == 0 || secondListLength == 0) {
            return new int[0][0];
        }

        List<int[]> intersections = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstListLength && secondIndex < secondListLength) {
            //find low and high points of the intersection
            int lowBorder = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            int highBorder = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);

            if (lowBorder <= highBorder) {
                intersections.add(new int[]{lowBorder, highBorder});
            }

            //increment index for interval with the lower endpoint
            if (firstList[firstIndex][1] < secondList[secondIndex][1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }


}
