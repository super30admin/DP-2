//Time: O(m*n)
// where m = no of rows, n = no of columns = 3 in this case ==> O(n)

//Space = O(1), when modifying existing array; O(m*n) if used new dp array

class Solution {
    public int minCost(int[][] cost) {
        if(cost.length == 0 || cost == null){
            return 0;
        }
        
        int n = cost.length;
        
        for(int i = 1; i < cost.length; i++){
            //cost for red
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            
            //cost for green
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            
            //cost for blue
            cost[i][2] += Math.min(cost[i - 1][1], cost[i - 1][0]);
        }
        
        return Math.min(Math.min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]);
    }
}