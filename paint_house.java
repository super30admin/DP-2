// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : It's a premium problem
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public int minCost(int[][] costs) {
    if(costs==null||costs.length==0)
        return 0;
    int m = costs.length;

 //If we start from the first row, we need to generate all the possible sub trees which is very similar
 //to brute force approach. So, to optimise, we start from the next row.
 
 //if we choose red for the first house, for the next house we have to choose the minimum cost between
 // the blue and the green house. This step is followed for both blue(min of red and green) and green
 //(min of red and blue) houses. 
    for(int i=1; i<costs.length; i++){
        costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
        costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
        costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
    }
    //The last row will have all the min for the paths we have chosen(started with red, blue or green house). 
    //We need to return the minimum of the three
    return Math.min(Math.min(costs[m - 1][0], costs[m - 1][1]), costs[m - 1][2]);
}