/*

## Problem1(https://leetcode.com/problems/paint-house/)
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Follow Up: Optimize for Space

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10

Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 

Minimum cost: 2 + 5 + 3 = 10.
             


*/

/*
    Brute force
    Time Complexity : K *2^N 
                    K =  choice of colors
                    N =  house
    space Complexity : recursive space would be O(N)
    Is worked on leetcode : Haven't checked Locked problem but it is working for cases in REadme
    
 */
public class PaintHouse {
    public int minCost(int[][]costs) {
        int case1=helper(costs,0,0, 0);
        int case2  = helper(costs,0,1,0);
        int case3=helper(costs,0,2, 0);
        return Math.min(case1, Math.min(case2,case3));
    }   

    public int helper(int[][] costs, int row, int prev_color, int min){

        if (row == costs.length) return min;
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE;
        int case3 = Integer.MAX_VALUE;
        if(prev_color == 0){
            case1 = Math.min( helper(costs, row + 1, 1, min +  costs[row][1]),
                            helper(costs, row +1, 2, min +  costs[row][2])
                            );
        }

        if(prev_color == 1){
            case2 = Math.min( helper(costs, row + 1, 0, min +  costs[row][0]),
                            helper(costs, row +1, 2, min +  costs[row][2])
                            );
        }

        if(prev_color == 2){
            case3 = Math.min( helper(costs, row + 1, 0, min +  costs[row][0]),
                            helper(costs, row +1, 1, min +  costs[row][1])
                            );
        }

        return Math.min( case1, Math.min(case2,case3));

        
    }

    public static void main(String[] args) {
        int[][] costs= { {17,2,17},{16,16,5},{14,3,19}};
        PaintHouse obj =  new PaintHouse();
        System.out.println(obj.minCost(costs));
    }   
}