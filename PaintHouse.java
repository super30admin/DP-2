// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We are given a 2D array `costs` where each row represents a house and each column is the cost of painting that house with Red, Blue, or Green.
// The goal is to paint all houses with minimum total cost such that no two adjacent houses have the same color.
// Starting from the second last house, we calculate and update the minimum cost for each color by adding the cost of painting the current house
// plus the minimum cost of painting the next house with a different color.
// Finally, we return the minimum of the three values in the first row, representing the min cost starting from the first house.



public class PaintHouse {
    public int minCost(int[][] costs){
        if(costs==null || costs.length==0){
            return 0;
        }
        int n = costs.length;
        for(int i=n-2;i>=0;i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));

    }
    public static void main(String[] args) {
        PaintHouse ob = new PaintHouse();
        int[][] costs1 = {
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
        };
        System.out.println("Minimum cost to paint all houses: " + ob.minCost(costs1));  
        int[][] costs2 = {
        {7, 6, 2}
         };
        System.out.println("Minimum cost to paint all houses: " + ob.minCost(costs2)); 

        
    }
    
}
