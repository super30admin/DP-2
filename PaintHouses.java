//Paint houses Dp without mutating the array

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int prev[] = costs[costs.length-1];
        
        for(int i = costs.length-2;i>=0;i--){
            
            int cur[] = costs[i].clone();
            cur[0]+= Math.min(prev[1],prev[2]);
             cur[1]+= Math.min(prev[0],prev[2]);
             cur[2]+= Math.min(prev[1],prev[0]); 
            prev = cur;
        }
        return Math.min(Math.min(prev[0], prev[1]), prev[2]);
    }
}


//Paint houses DP by mutating the array
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        
        for(int i = costs.length-2;i>=0;i--){
            costs[i][0]+= Math.min(costs[i+1][1],costs[i+1][2]);
             costs[i][1]+= Math.min(costs[i+1][0],costs[i+1][2]);
             costs[i][2]+= Math.min(costs[i+1][1],costs[i+1][0]); 
        }
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}