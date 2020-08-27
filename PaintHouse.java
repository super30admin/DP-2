// Time Complexity : O(N) where N is the number of houses.
// Space Complexity : O(1) as we are not using any extra/auxillary space.
// Did this code successfully run on Leetcode : ran it on lintcode.com as it is only for premium leetcode users
// Any problem you faced while coding this : When I started the problem, I was only tracking the current minimum cost path.
    // It worked for 40% cases but then I realized that at any point the other path can have a minimum cost and hence
    // came up with this algorigthm of tracking all paths for three possible choices at each house.

public class PaintHouse {
    public int minCost(int[][] costs) {

        //if there are no houses, costs is 0
        if(costs.length == 0) return 0;
        
        //for each house keep track of cost until the last house.
        for(int i = 1; i < costs.length ;i++) {
            //for color red, what was the minimum cost of painting until last house with green or blue.
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);

            //for color green, what was the minimum cost of painting until last house with red or blue.
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);

            //for color blue, what was the minimum cost of painting until last house with red or green.
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        int min = Integer.MAX_VALUE;
        
        //find the minimum cost of all three colors at the end
        for(int i = 0 ; i < costs[0].length; i++) {
            if(costs[costs.length-1][i] < min) {
                min = costs[costs.length-1][i];
            }
        }
        
        //return minimum value
        return min;
    }

}