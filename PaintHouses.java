// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :O(n*3) = O(n)  ---> because of extra 2d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Confused as to how to use dp before the session.


// Your code here along with comments explaining your approach
public class PaintHouses {
    public static int painthouses(int[][] nums){
        int[][] dp = new int[nums.length][3];
        for(int i = 0;i<dp[0].length;i++)
            dp[0][i] = nums[0][i];
        for(int i = 1;i<nums.length;i++){
            dp[i][0] = nums[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = nums[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = nums[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[nums.length-1][0],Math.min(dp[nums.length-1][1],dp[nums.length-1][2]));
    }
    public static void main(String[] args) {
        int[][] nums = new int[][]{{2,3,1},{3,5,3},{7,100,101},{3,400,500}};
        System.out.println(painthouses(nums));
    }
}
