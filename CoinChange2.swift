//
//  CoinChange2.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/5/26.
//

class CoinChange2 {
    /*
     Print all the ways in which coins can be selected to form sum 11
     from coins - [2,5,1]
    */
    
    init() {
        selectWaysToFormASum(coins: [1,2,5], amount: 5)
    }
    
    /*
     Brute force - Use exhaustive approach (recursive one). choose or not choose.
     at the end of the path, either we will have amount -ve or the coins are over but amount is remaining -> invalid path
     If the amount left is 0 at the end -> valid path
     
     Time complexity - pow(2, m+n), m -> amount, n -> no of coins , m+n - total depth of the tree.
     every decision node should have coins, amoutn or index of the coin
     */
    func selectWaysToFormASum(coins: [Int], amount: Int) {
        let noOfWays = helper(coins: coins, amount: amount, index: 0)
        print("noOfWays *** \(noOfWays)")
        
        let noOfWaysUsingTabulation = coinChangeUsingTabulation(amount: 5, coins: [1,2,5])
        print("noof ways using tabulation \(noOfWaysUsingTabulation)")
        
        let noOfWaysUsingMemoization = coinChangeUsingMemoization(amount: 5, coins: [1, 2, 5])
        print("no of ways using memoization \(noOfWaysUsingMemoization)")
    }
 
    func helper(coins: [Int], amount: Int, index: Int) -> Int {
        //base
        if (amount == 0) {
            //valid path
            return 1
        }
        //invalid path
        if (amount < 0 || index == coins.count) {
            return 0
        }
        //not choose
        let case1 = helper(coins: coins, amount: amount, index: index + 1)
        //choose
        let case2 = helper(coins: coins, amount: amount - coins[index], index: index)
        
        let totalWays = case1 + case2
        return totalWays
    }
    
    //Using DP - Tabulation
    //time complexity -> O(mn)
    func coinChangeUsingTabulation(amount: Int, coins: [Int]) -> Int {
        let m = coins.count
        let n = amount
        var dp = Array(repeating: Array(repeating: 0, count: n + 1), count: m + 1)
        dp[0][0] = 1
        for i in 1...m {
            dp[i][0] = 1
            for j in 1...n {
                //till the time denomination of coin is smaller than amount, till that time, we have 0 cases only.
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i-1][j]
                } else {
                    //add up 0 cases and 1 cases
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]]
                }
            }
        }
        return dp[m][n]
    }
    
    //using top down DP - memoization
    func coinChangeUsingMemoization(amount: Int, coins: [Int]) -> Int {
        
        let m = coins.count
        let n = amount
        var memo: [[Int]] = Array(repeating: Array(repeating: -1, count: n + 1), count: m + 1)
        let noOfWays = helperForMemoizationApproach(amount: amount, coins: coins,index: 0, memo: &memo)
        print("memo *** \(memo)")
        print("o of ways using memoization \(noOfWays)")
        return noOfWays
    }
    
    func helperForMemoizationApproach(amount: Int, coins: [Int], index: Int, memo: inout [[Int]]) -> Int {
        //valid path
        if (amount == 0) {
            return 1
        }
        //invalid path
        if (amount < 0 || index == coins.count) {
            return 0
        }
        
        if (memo[index][amount] != -1) {
            return memo[index][amount]
        }
        //not choose
        let noOfWaysByExcluding = helperForMemoizationApproach(amount: amount, coins: coins, index: index + 1, memo: &memo)
        //choose
        let noOfWaysByIncluding = helperForMemoizationApproach(amount: amount - coins[index], coins: coins, index: index, memo: &memo)
        
        memo[index][amount] = noOfWaysByExcluding + noOfWaysByIncluding
        return noOfWaysByExcluding + noOfWaysByIncluding
    }
}
/*
 to avoid 2pow n time complexity.
 for 1 input variable - 1-D array
 for 2 -> 2-D array
 if 5 input variables. probme swill be repeating if all 5 parameters are same.
 dimensinal reduction
 for 3 input varibales - do a for loop for 3rd dimension choices. <dp with permutations> - burst balloons
 beyond 3 input variables - it's very difficult to have repeated subproblems. And repeated subproblems are required for a problme to be a dp problmes.
 //If amount - 0, coin - 1-> don't choose this coin,. SO 1 way of choosing
 
 never put your result into the recursion stack. In some case, it works but not a good practice

 */
