// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class paintHouse{

public int minCost(int[][] cost) {
    if(cost==null || cost.length==0)
        return 0;
        
    for(int i=cost.length-2;i>=0;i--){
        cost[i][0]= cost[i][0] + Math.min(cost[i+1][1],cost[i+1][2]);
        cost[i][1]= cost[i][1] + Math.min(cost[i+1][0],cost[i+1][2]);
        cost[i][2]= cost[i][2] + Math.min(cost[i+1][1],cost[i+1][0]);
        
    }
    
    return Math.min(cost[0][0], Math.min(cost[0][1],cost[0][2]));
    
}
}