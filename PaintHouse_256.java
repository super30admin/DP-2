// Time Complexity : O(n) => n = number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class PaintHouse_256 {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        
        int n = costs.length;
        //we start from second house to get min and go to all the way end of last house and update min cost  by taking minimun value at each house
        for(int i=1;i<costs.length;i++){
            //color red
            costs[i][0]=costs[i][0]+Math.min(costs[i-1][1],costs[i-1][2]);
            
            //color blue
            costs[i][1]=costs[i][1]+Math.min(costs[i-1][0],costs[i-1][2]);
            
            //color green
            costs[i][2]=costs[i][2]+Math.min(costs[i-1][0],costs[i-1][1]);
        }
        
        
        return Math.min(Math.min(costs[n-1][0],costs[n-1][1]),costs[n-1][2]);
    }
}