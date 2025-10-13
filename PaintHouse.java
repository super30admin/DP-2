// Paint House
// https://leetcode.com/problems/paint-house/description/

// Solution 1 => Recursive


/**
 * Time Complexity: O(2^n), where n is number of houses and we give recursive calls till n is exhausted
 * Space Complexity: O(n)
 */

class Solution{

    public int paintHouse(int [][] cost) {
        int red = helper(cost, 0, 0);
        int blue = helper(cost, 0, 1);
        int green = helper(cost, 0, 2);

        return Math.min(red, Math.min(blue, green));
    }

    private int helper(int[][] cost, int house, int color){

        // base condition
        if(house >= cost.length){
            return 0;
        }

        // logic

        if(color == 0){ // if red color is picked
            int blue = cost[house][color] + helper(cost, house + 1, 1);
            int green = cost[house][color] + helper(cost, house + 1, 2);

            return Math.min(blue, green);
        }

        if(color == 1){ // if blue color is picked
            int red = cost[house][color] + helper(cost, house + 1, 0);
            int green = cost[house][color] + helper(cost, house + 1, 2);

            return Math.min(red, green);
        }

        if(color == 2){ // if green color is picked
            int red = cost[house][color] + helper(cost, house + 1, 0);
            int blue = cost[house][color] + helper(cost, house + 1, 1);

            return Math.min(red, blue);
        }
        
        return -1;
    }
}

// Solution 2 => Memoization/Top-Down

/**
 * Time Complexity: O(n * m)  where n is number of houses and m is no. of colors i.e 3 hence O(n)
 * Space Complexity: O(n * m) ignoring m as its constant O(n)
 */


class Solution{

    int memo[][];

    public int paintHouse(int [][] cost) {

        this.memo = new int[cost.length][3];

        int red = helper(cost, 0, 0);
        int blue = helper(cost, 0, 1);
        int green = helper(cost, 0, 2);

        return Math.min(red, Math.min(blue, green));
    }

    private int helper(int[][] cost, int house, int color){

        // base condition
        if(house >= cost.length){
            return 0;
        }

        if(memo[house][color] != 0) {
            return memo[house][color];
        }

        // logic

        if(color == 0){ // if red color is picked
            int blue = cost[house][color] + helper(cost, house + 1, 1);
            int green = cost[house][color] + helper(cost, house + 1, 2);

            return memo[house][color] = Math.min(blue, green);
        }

        if(color == 1){ // if blue color is picked
            int red = cost[house][color] + helper(cost, house + 1, 0);
            int green = cost[house][color] + helper(cost, house + 1, 2);

            return memo[house][color] = Math.min(red, green);
        }

        if(color == 2){ // if green color is picked
            int red = cost[house][color] + helper(cost, house + 1, 0);
            int blue = cost[house][color] + helper(cost, house + 1, 1);

            return memo[house][color] = Math.min(red, blue);
        }
        
        return -1;
    }
}


// Solution 3.1 => Tabulation/Bottom-Up Approach

/**
 * Time Complexity: O(n) where n is number of houses
 * Space Complexity: 0(n * 3) = O(n)
 */

class Solution {
    public int paintHouse(int [][] cost){

        int dp[][] = new int[cost.length][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i = 1; i < cost.length ; i++){
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[cost.length - 1][0], Math.min(dp[cost.length - 1][1], dp[cost.length - 1][2]));
    }
}

// Solution 3.2 => Tabulation/Bottom-Up Approach (With 3 variables)

/**
 * Time Complexity: O(n) where n is number of houses
 * Space Complexity: 0(1) since we have only 3 variables
 */


class Solution {
    public int paintHouse(int [][] cost){

        int red = cost[0][0];
        int blue = cost[0][1];
        int green = cost[0][2];

        for(int i = 1 ; i < cost.length ; i++){
            int tempRed = red;
            red = cost[i][0] + Math.min(blue, green);

            int tempBlue = blue;
            blue = cost[i][1] + Math.min(tempRed, green);

            green = cost[i][2] + Math.min(tempRed, tempBlue);
        }

        return Math.min(red, Math.min(blue, green));
    }
}