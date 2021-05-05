package DynamicProgramming;

/*
    Time complexity : exponential
    space complexity: exponential
    Did this code run successfully in leetcode : yes
    problems faces : no
    at every step either choose the element or not,
    if you have chosen an element  from the coin, reduce the total amount by coins[index] and increase the number of coins by one
    if you are not choosing the element at index, increase the index by one and keep the amount and number of coins as same
*/
public class CoinChange2WithRecursion {

    public int change(int amount, int[] coins) {

        if (coins == null || coins.length == 0)
            return 0;

        return findCoinChangeWaysForGivenSum(coins, amount, 0);
    }

    public int findCoinChangeWaysForGivenSum(int[] coins, int amount, int index) {
        if (amount == 0)
            return 1; //valid

        if (index == coins.length || amount < 0)
            return 0;

        //choosing a coin  
        int case1 = findCoinChangeWaysForGivenSum(coins, amount - coins[index], index);

        //not choosing a coin
        int case2 = findCoinChangeWaysForGivenSum(coins, amount, index + 1);

        return case1 + case2;
    }

}
