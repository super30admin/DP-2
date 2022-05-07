import java.util.Arrays;

/* Solution 1 Recursion */
//Time Complexity: O(2^N) permutations, where is the  N is the level of the recursion. At every leafs we will have 2 choices of color for each house.
//Leet code : yes
//Space Complexity : O(2^N) //level of dpeth of recursion tree.
public class PaintHouseLeetcode256 {
        int min_cost = 999;
        public int minCost(int[][] costs) {

            if (costs == null) {
                return 0;
            }

            return helper(costs, 0, -1);

        }

        public int helper(int[][]costs, int r,int lc) {

            if (r >= costs.length) {
                return 0;
            }

            for (int i = 0; i < costs[0].length; i++) {
                //lc is last color by this we know which color was choosen fo previous so we can skip this.
                if (i == lc) continue;
                System.out.println("Before calling helper r : "+r+" i : "+i+" lc : "+lc+" cost : "+ min_cost);
                min_cost = Math.min(min_cost, costs[r][i] + helper(costs, r + 1, i));
                System.out.println("After calling helper  r : "+r+" i : "+i+" lc : "+lc+" cost : "+ min_cost);


            }

            return min_cost;
        }

        /* Solution 2 Memoization */
//Time Complexity: O(N)  where is the  N is the level of recursion or the number of houses..we will calculate each color * each house. (less no of colors we drop it and say O(N)
//Leet code : yes
//Space Complexity : O(N) //level of dpeth of recursion tree.

        int dp[][];
        public int minCost1(int[][] costs) {
             dp = new int[costs.length + 1][3];
            for(int row[]: dp){
                Arrays.fill(row, -1);
            }
            return helper1(costs, costs.length, -1);
        }

        public int helper1(int[][] costs, int n, int prev) {
            if(n == 0){
                return 0;
            }

            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                if(i == prev){
                    continue;
                }
                if(dp[n][i] != -1){
                    ans = Math.min(ans, dp[n][i]);
                }else{
                    int result = costs[n-1][i] + helper1(costs, n - 1, i);
                    dp[n][i] = result;
                    ans = Math.min(ans, result);
                }


            }

            return ans;

        }


}
