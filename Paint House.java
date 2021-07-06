// Time Complexity : O(n), n is number of houses
// Space Complexity : O(n*3), n is number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Main {
    public static int minCost(int[][] costs){
        //edge
        if(costs == null || costs.length == 0) return 0;
        
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[costs.length -1][0],costs[costs.length -1][1]),       
                costs[costs.length -1][2]);
    }
    public static void main(String[] args) {
       int costs[][]= {{14,2,11},{11,14,5},{14,3,10}};
        System.out.println(minCost(costs));
    }
}