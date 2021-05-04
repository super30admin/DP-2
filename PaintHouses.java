/*
Description: This algoritm calculates the optimal path at every row from the bottom of the input matrix, by choosing
the least cost at that consecutive row other than the current column and update the current cost at that particular index.
Time Complexity : O(n) as we iterate through the whole marix using just a single for loop.
Space Complexity : O(1) as we dont use any extra auxillary space and perform the opeeration on the input matrix right away.
*/

import java.lang.Math;
public class ColorHouseOpt{
    public static void main(String args[]){
        int costs[][] = {{17,2,17},{16,16,5},{14,3,19}};
        for(int i=costs.length-2;i>=0;i--){
            costs[i][0] = costs[i][0]+Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1]+Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2]+Math.min(costs[i+1][0],costs[i+1][1]);
        }
        System.out.println(Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2])));
    }
}
