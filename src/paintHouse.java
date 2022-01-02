public class paintHouse {
  //Brute force
    // Time Complexity : O(2^n)
    // Space Complexity : O(M+n)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this :no

    class Solution {
        public int minCost(int[][] costs) {
            if(costs == null) return 0;
            int min = 999999;
            for(int i=0; i<costs[0].length; i++) {
                int a = helper(costs, 0, 0, i);
                if(a<min)
                {
                    min = a;
                }
            }
            return min;
        }
        private int helper(int costs[][], int costSoFar, int rows, int colorChoose) {
            //baase
            if(rows >= costs.length) return costSoFar;
            //logic
            int min = 9999;
            for(int i=0; i<costs[0].length; i++) {
                if(i !=colorChoose)
                    min = Math.min(min, helper(costs, costSoFar + costs[rows][colorChoose], rows+1, i));
            }
            return min;
        }
    }

    //DP
    // Time Complexity : O(M)
    // Space Complexity : O(M)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
        public int minCost(int[][] costs) {
            for(int i=costs.length-2; i >= 0; i--) {
                costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
                costs[i][1] += Math.min(costs[i+1][0],costs[i+1][2]);
                costs[i][2] += Math.min(costs[i+1][1],costs[i+1][0]);

            }
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
}
