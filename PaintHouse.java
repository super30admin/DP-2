// Time Complexity : O(N) = O(N) where N is length of costs. 
// Space Complexity :O(1) as we are manipulating costs array itself
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PaintHouse {
    public int minCost(int[][] costs) {
        
        if(costs.length==0) return 0;
        
        for(int i=costs.length-2;i>=0;i--){ // bottom up
            
            costs[i][0]+=Math.min(costs[i+1][1],costs[i+1][2]); // cost of painting red. Choose red and min of blus and green
            costs[i][1]+=Math.min(costs[i+1][0],costs[i+1][2]); // cost of painting blue. Choose blue and min of red and green
            costs[i][2]+=Math.min(costs[i+1][0],costs[i+1][1]); // cost of painting green. Choose green and min of blue and red
            
        }
        
         return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]); // minimum of 3
    }
}