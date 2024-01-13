// Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

// Approached problem recursively, then 2D Dp to 1D Dp to optimizing it to use three variables

import java.util.ArrayList;

public class paintHouse {
    public class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {

            int m = A.size();

            int costR = A.get(m - 1).get(0);
            int costB = A.get(m - 1).get(1);
            int costG = A.get(m - 1).get(2);

            for (int i = m - 2; i >= 0; i--) {
                int tempR = costR;
                costR = A.get(i).get(0) + Math.min(costB, costG);
                int tempB = costB;
                costB = A.get(i).get(1) + Math.min(tempR, costG);
                costG = A.get(i).get(2) + Math.min(tempR, tempB);
            }
            return Math.min(costR, Math.min(costB, costG));
        }

        // Dp 1-D
        // public int solve(ArrayList<ArrayList<Integer>> A) {

        // int m = A.size();
        // int n = A.get(0).size();

        // int[]dp = new int[n];

        // for(int i=0;i<n;i++) {
        // dp[i] = A.get(m-1).get(i);
        // }

        // for(int i=m-2;i>=0;i--) {
        // int tempR = dp[0];
        // dp[0] = A.get(i).get(0) + Math.min(dp[1],dp[2]);
        // int tempB = dp[1];
        // dp[1] = A.get(i).get(1) + Math.min(tempR,dp[2]);
        // dp[2] = A.get(i).get(2) + Math.min(tempR,tempB);
        // }
        // return Math.min(dp[0],Math.min(dp[1],dp[2]));

        // }

        // Recursive solution
        // private int helper(ArrayList<ArrayList<Integer>> A,int idx,int cIdx) {

        // if(idx == A.size()) return 0;

        // if(cIdx == 0) {
        // return A.get(idx).get(0) + Math.min(helper(A,idx+1,2),helper(A,idx+1,1));
        // }
        // if(cIdx == 1) {
        // return A.get(idx).get(1) + Math.min(helper(A,idx+1,2),helper(A,idx+1,0));
        // }
        // if(cIdx == 2) {
        // return A.get(idx).get(2) + Math.min(helper(A,idx+1,0),helper(A,idx+1,1));
        // }
        // return -1;
        // }
    }

}
