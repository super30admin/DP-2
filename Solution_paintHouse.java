/*
// Time Complexity : O(n) as we will traverse this grid n -1 time where n is the number of elements inside the  grid.
// Space Complexity : O(1) as we are not using any auxilary data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

*/

public class Solution_paintHouse {
    
    class Solution {
        public int minCost(int[][] costs) {
            // iterating from the second last row.
            for(int i =costs.length-2; i>=0; i--) {
                
                //  totoal cost of for red color
                
                costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
                
                // totoal cost of for blue color blue
                
                 costs[i][1] = costs[i][1]  + Math.min(costs[i+1][0], costs[i+1][2]);
                
                
                //  totoal cost of for green color 
                
                
                 costs[i][2] = costs[i][2]  + Math.min(costs[i+1][1], costs[i+1][0]);
                
                
            }
            //  returnng the minimum value from the first row beacause we are doing bottom up approcach.
            return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        }
    }}
