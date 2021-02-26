// Time Complexity : O(n) where n is the number of rows of the matrix
// Since there were 3 colors it gives O(3n) which can be referred as O(n)
// If it was m number of colors then the complexity will be O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Used generalized solution to choose the minimum of the previous house paint cost of different color
class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int n=costs.length;
        int m = costs[0].length;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++)
              // Generalized for m number of colors given for n number of houses
                costs[i][j] += Math.min(costs[i-1][(j+2)%m],costs[i-1][(j+1)%m]);
        }
        int min=Integer.MAX_VALUE;
        for(int k:costs[n-1])
            min = Math.min(min,k);
        return min;
    }
}
