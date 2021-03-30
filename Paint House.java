//Time Complexity : O(n) . i.e O(n*3)= O(n) as the number of cols (which are 3 colors) is fixed.
//space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        if(costs.length==0||costs==null){
            return 0;
        }
        //iterate through the array from last 2nd row
        for(int i = costs.length-2;i>=0;i--){
            //calculating the minimum cost for each home
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);//first choosing red and adding the minimum of the blue and green from other house
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);//then choosing blue and adding the minimum of the red and green from other house
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1],costs[i+1][0]);//choosing green and adding the minimum of the red and blue from other house
            
        }
        //returning the min value from the first row as the final res lies in the top row due to bottom up approach
        return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}