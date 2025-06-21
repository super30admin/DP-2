// Question - Given a row of n houses, each house can be coloured with any of the three colours: let these be red blue or
// green. the cost for painting a particular house with a particular colour is going to be different. you have to colour
// the house in such a way that no two adjacent houses will have the same colour. the cost for painting  a house with any
// colour is represented by  n X 3 cost matrix where cost for painting house 0 with colour red is cost[0][0] and cost for
// painting house 4 with green colour is cost[4][2] and so on.....calculate the minimum cost to paint all houses.
// try to optimize it for space !!

// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1) because only 3 element space is taken
// Any problem you faced while coding this : no

public class PaintHouse {

    static int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        dp[0] = costs[n - 1][0];
        dp[1] = costs[n - 1][1];
        dp[2] = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        min = Math.min(min, dp[k]);
                    }
                }
                temp[j] = costs[i][j] + min;
            }
            dp = temp;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int [][] costs = {{17,2,17}, {16, 16, 5},{4,3,19}};
        System.out.println("Minimum costs to paint the houses: " + minCost(costs));
    }

}
