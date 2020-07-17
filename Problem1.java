// There are three approaches.
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

// Approach: Brute force
// Time Complexity : O(3*2^n) = O(2^n)
//      n : number of houses
//      The 3 signifies 1st house has 3 choices
// Space Complexity : O(n)
//      n : number of houses
//  Here it is recursive space. Technically it is O(1).
class Problem1BruteForce{

    // member variables 
    // color represents index
    private int red = 0;
    private int blue = 1;
    private int green = 2;

    /** find minimum cost for painting house with either color red, blue, grren */
    public int minCost(int[][] costs) {

        // cost for painting house
        int redCost = helper(costs, 0, red, 0);
        int blueCost = helper(costs, 0, blue, 0);
        int greenCost = helper(costs, 0, green, 0);
        
        return Math.min(redCost,Math.min(blueCost, greenCost));  
    }
    
    /**
     *  Helper function
     * @param costs house matrix with cost of painting house
     * @param houseIndex current house to be painted
     * @param colorCase current color painted
     * @param paintCost total cost incurred
     * @return int
     */
    private int helper(int[][] costs, int houseIndex, int colorCase, int paintCost){

        // Base Case: all the houses are painted
        if(houseIndex==costs.length)
            return paintCost;
        
        // minimum cost
        int minCost=0;
        
        // Adding cost of painting current house
        paintCost += costs[houseIndex][colorCase];
        // for next house
        houseIndex += 1;

        // case red
        if(colorCase == red)
            // get min by painting next house blue or green
            minCost = Math.min(helper(costs, houseIndex, blue, paintCost),
                               helper(costs, houseIndex, green, paintCost));
        // case blue
        else if(colorCase == blue)
            // get min by painting next house red or green
            minCost = Math.min(helper(costs, houseIndex, red, paintCost),
                               helper(costs, houseIndex, green, paintCost));
        // case green                       
        else if(colorCase == green)
            // get min by painting next house red or blue
            minCost = Math.min(helper(costs, houseIndex, red, paintCost),
                               helper(costs, houseIndex, blue, paintCost));
        
        // return min
        return minCost;         
    }
}

// Approach: Dynamic Programming
// Time Complexity : O(n*3) = O(n)
//      n : number of houses
//      The 3 signifies 3 choices of color
// Space Complexity : O(1)
//      Here we are using the cost matrix itself.
class Problem1DP1 {
    public int minCost(int[][] costs) {
        if(costs!=null && costs.length!=0){
            
            for(int i=1; i<costs.length; i++){
              
                costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);         
            }
            
            return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2] ) );
        }else
            return 0;
         
    }
}

// Approach: Dynamic Programming for coloring with any color (GENERAL)
// Time Complexity : O(n*m*(m-1)) = O(n*m^2)
//      n : number of houses
//      m :number of color
// Here m-1 is to find minimum cost from previous coloured houses
// Space Complexity : O(1)
//      Here we are using the cost matrix itself.
class Problem1DP2 {

    public int minCost(int[][] costs) {
        if(costs!=null && costs.length!=0){
            
            // iterate all houses
            for(int i=1; i<costs.length; i++){

                // iterate all colors
                for(int j=0; j<costs[i].length;j++){
                   // find minimum of previous cost 
                   costs[i][j] += minOfArray(costs[i-1], j);
                } 
            } 
            // find minimum of all the cost
            // -1 means all the elements of array are considered 
            return minOfArray(costs[costs.length-1], -1);
        }else
            return 0;
         
    }
    
    /**
     * Find min value of the array
     * @param arr int array
     * @param index excludes particular index
     * @return int
     */
    private int minOfArray(int[] arr, int index){
        // initialize MAX value
        int minValue = Integer.MAX_VALUE;

        // iterate
        for(int i=0; i<arr.length; i++)
            if(i!=index && minValue >= arr[i])
                minValue = arr[i];
        // minimum value
        return minValue;
    }
}