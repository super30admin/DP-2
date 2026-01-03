# Problem1(https://leetcode.com/problems/paint-house/)
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

## no adjacent house can be painted with the same colour
## starting with the greedy selecting smallest value first, can work for some test cases but wont work for many 
## going with the exaustive approach of creating 3 trees and deciding which one will be better. 
## the time complexity will be exponential in that case, can I do any better? 
## trying to convert exuastive to memoization by storing the results of already completed nodes
## We have 3 cases to choose from, and each step we can calculate the cost, by choosing that and one of either two remaining
## storing the results in memo, as we calculate
## finally returning the min of three trees

def helper(i,j,costs,memo):
    ## base case
    if i>=len(costs):
        return 0
    if memo[i][j] != -1:
        return memo[i][j]
    ## case 1 : choose red
    if j ==0:
        res= costs[i][j] + min(helper(i+1,1,costs,memo), helper(i+1,2,costs,memo))
        memo[i][j] = res
        return res

    ## case 2 : choose blue 
    if j ==1:
        res= costs[i][j] + min(helper(i+1,0,costs,memo), helper(i+1,2,costs,memo))
        memo[i][j] = res
        return res
    ## case 3 : choose green
    if j==2:
        res= costs[i][j] + min(helper(i+1,0,costs,memo), helper(i+1,1,costs,memo))
        memo[i][j] = res
        return res

rows = len(costs)
cols = 3 ## 3 colors
memo = [[-1]*(cols+1) for _ in range(rows+1) ]

colr = helper(0,0,costs,memo)
colb = helper(0,1,costs,memo)
colg = helper(0,2,costs,memo)

return min(colr,min(colb,colg))



# Problem2 (https://leetcode.com/problems/coin-change-2/)
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

## starting with the greedy approach again to choose the biggest coin and start decreasing the amount until amount is 0 
## the greedy approach fails for the non conical denomination coins. 
## we can start with exaustive approach to select and not select each coin and build a tree
## the exaustive approach will be O(2^n) because of the depth\
## converting to memoization to save the some complexity


def helper(amount,coins,idx):
    ## base case
    
    if amount ==0:
        return 1
    if amount <0 or idx >= len(coins):
        return 0
    if memo[amount][idx] != -1:
        return memo[amount][idx]
    ## choose the coin
    case1 = helper(amount-coins[idx],coins,idx)
    ## dont choose the coin
    case2 = helper(amount,coins,idx+1)
    res = case1+case2
    memo[amount][idx] = res
    return res

memo = [[-1]*len(coins) for _ in range(amount+1)]
res = helper(amount,coins,0)
return res