package com.dp1;

public class HouseRobber {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int skip = 0, take = nums[0];


        for (int i = 1; i < nums.length; i++) {

            int temp = Math.max (skip, take);
            take = skip + nums[i];
            skip = temp;

        }

        return Math.max (skip, take);

    }

    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber ();

        System.out.println (sol.rob (new int[]{1,2,3,1}));
    }


}
