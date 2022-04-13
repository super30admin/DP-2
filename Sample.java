// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//740. Delete and Earn
// class Solution {

//     //TC O(Max(nums or Max+1))
//     //SC O(n) which is max+1
//     public int deleteAndEarn(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         int n = nums.length;
//         int max=0;
//         for(int num : nums){
//                if(max<num){
//                    max= num;
//                }
//             }
//         int[] newnums = new int[max+1];

//             for(int num : nums){
//                newnums[num] += num;}

//         int[][] dp = new int[max+1][2];

//             dp[0][1] = newnums[0];

//         for(int i = 1; i < max+1; i++){
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

//             dp[i][1] = newnums[i] + dp[i-1][0];
//         }
//        return Math.max(dp[max][0], dp[max][1]);
//     }
// }

//256. Paint House



// class Solution {
//     // TC O(n)
//     // SC(n)
//     public int minCost(int[][] costs) {
//         //base case
//         if(costs==null||costs.length==0) return 0;

//         int[][] dp = new int[costs.length][costs[0].length];

//         for(int i =0;i<costs.length;i++){
//             for(int j =0;j<costs[0].length;j++){
//                 dp[i][j] = costs[i][j];
//             }
//         }
//         for(int i = costs.length -2; i>=0; i--){


//                 dp[i][0] = dp[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);


//                 dp[i][1] = dp[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);



//                 dp[i][2] = dp[i][2] + Math.min(dp[i+1][0],dp[i+1][1]);

//             }
//         return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));       }

//     }


// 198. House Robber

// class Solution {
//     // TC O(N)
//     // SC O(N)
//     public int rob(int[] nums) {
//         if(nums == null || nums.length ==0) return 0;
//         int n = nums.length;
//         int[][] dp = new int[n][2];
//         dp[0][1] = nums[0];
//         for(int i =1;i<n;i++){
//             //not robbed
//             dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//             //robbed
//             dp[i][1] = dp[i-1][0] + nums[i];
//         }

//         return Math.max(dp[n-1][0], dp[n-1][1]);
//     }
// }



