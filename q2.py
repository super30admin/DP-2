from typing import List
# Time Complexity : O(m*n), Where m is number of elements in the coins, n is target
# Space Complexity : O(m*n), Where m is number of elements in the coins, n is target 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

class Solution:
    def actualsol(self,ind: int,coins: List[int],target: int,memo)->int:
        if(ind==len(coins)):
            if(target==0):
                return 1
            if(target!=0):
                #This combination is not possible, Therefore return 0
                return 0
        if(target<0):
            #This combination is not possible, Therefore return 0
            return 0
        if(memo[ind][target]!=None):
             return memo[ind][target]
            
        #Actual logic apart from base case
        #This is including the coin at that index
        l=self.actualsol(ind,coins,target-coins[ind],memo)
        #This is not including the coin at that index
        r=self.actualsol(ind+1,coins,target,memo)
        
        
        memo[ind][target]=l+r
        return l+r
    def change(self, amount: int, coins: List[int]) -> int:
        if(len(coins)==0 ):
            #Here there is no coins denomination
            #This is default case where there is no combination possible
            return -1
        elif(amount<0):
            #Here the given amount is negative
            #This is default case where there is no combination possible
            return -1
        else:
            memo=[[None for i in range(amount+1)] for j in range(len(coins))]
            #print(memo)
            ans=self.actualsol(0,coins,amount, memo)
            #print(memo)
            
            return ans
        