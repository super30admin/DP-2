// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class PaintHouse {
    public int minCost(int[][] costs) {
        
        //Bottom down, store minimum of non adjucent house costs from previous row inclusing the cost of current house
        for(int i = costs.length - 2; i >=0; i--){
            for(int j = 0; j < costs[0].length; j ++){
                if(j==0){
                    costs[i][j] = Math.min(costs[i+1][1]+costs[i][j],costs[i+1][2]+costs[i][j]);
                }else if(j==1){
                    costs[i][j] = Math.min(costs[i+1][0]+costs[i][j],costs[i+1][2]+costs[i][j]);
                }else{
                    costs[i][j] = Math.min(costs[i+1][0]+costs[i][j],costs[i+1][1]+costs[i][j]);
                }
            }
        }
        return Math.min(costs[0][0],Math.min(costs[0][1], costs[0][2]));
    }
}
