// Time Complexity : O(n.m) where n = number of houses and m = number of paint colors (3 in the leetcode question)
// Space Complexity : O(2m), asymptotically O(m), m = number of paint colors (3 in the leetcode question)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int[] dp = new int[costs[0].length];
        dp = costs[0];
        
        int[] temp = new int[dp.length];
        for(int i = 1; i < costs.length; i++){
            for(int j = 0; j < costs[0].length; j++){
                temp[j] = costs[i][j] + getMin(dp, j);
            }
            dp = Arrays.copyOf(temp, temp.length);
        }
        return getMin(dp, -1);
    }
    private int getMin(int[] cost, int j){
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < cost.length; k++){
            if(k != j && cost[k] < min){
                min = cost[k];
            }
        }
        return min;
    }
}
