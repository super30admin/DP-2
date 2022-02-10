/*
Time Complexity: O(n)
Space Complexity: O(1)
Code run on Leetcode: yes
Any difficulties: no

Approach:
1. Dynamic Programming Solution

 */

public class PaintHouse {
    public static int paintHouse(int[][] costs){
        if(costs.length == 0){
            return 0;
        }
        for(int i = costs.length-2; i>=0; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args){
        int[][] costs = { {17,2,17}, {16,16,5}, {14,3,19} };
        System.out.println("Minimum cost to paintHouse: "+ paintHouse(costs));
    }
}
