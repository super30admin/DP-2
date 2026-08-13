// Paint House

// time complexity: o(n)
//space complexity(o(mxn))

import java.util.Scanner;

class Solution {

    public static int paintHouse(int[][] costs) {

        int minCost = 0;

        int m = costs.length;
        int n = costs[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < m; i++) {

            dp[i][0] = costs[i][0]
                    + Math.min(dp[i - 1][1], dp[i - 1][2]);

            dp[i][1] = costs[i][1]
                    + Math.min(dp[i - 1][0], dp[i - 1][2]);

            dp[i][2] = costs[i][2]
                    + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(
                dp[m - 1][0],
                Math.min(dp[m - 1][1], dp[m - 1][2])
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int costsLength = Integer.parseInt(scanner.nextLine());

        int[][] costs = new int[costsLength][3];

        for (int i = 0; i < costsLength; i++) {

            String[] values = scanner.nextLine().split(" ");

            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(values[j]);
            }
        }

        scanner.close();

        int res = paintHouse(costs);

        System.out.println(res);
    }
}