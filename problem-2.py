# Leetcode Execution: YES
#     TimeComplexity: O(n*amount)
#     Space COmplexity: O(amount)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[0 for x in range(amount+1)] 
        dp[0]=1
        
        # we will be using dp technique here we will take the array of size amount +1 and put all as 0 but first index as 1 isnce we can make 0 from 0 in 1 way 
        # then we loop through the array as if it is multi dimentioanl to cover all the cases
        # for each index we gte value by summing up top index and the value from current row and column-coins[column ]
        # the last index value after all the iterations is our final answer
        for i in range(len(coins)):
            
            for j in range(1,amount+1):
                
                case1=0
                if j-coins[i]>=0:
                    case1=dp[j-coins[i]]
                dp[j]=dp[j]+case1

            
            
            
            # using two dimentional array 
                # case0=0
                # if i-1>=0:
                #     case0=dp[i-1][j]
                # case1=0
                # if j-coins[i] >=0:
                #     case1=dp[i][j-coins[i]]
                # dp[i][j]=case0+case1
                
        return dp[amount]
                
            
        
        
        
#         exhaustive approach
        # return self.helper(amount,coins,0)
        
#     def helper(self,amount,coins,index):
#         if index==len(coins) or amount<0:
#             return 0
#         if amount==0:
#             # self.count=self.count+1
#             return 1

#         if f"{index},{amount}" in self.mapp:
#             return self.mapp[f"{index},{amount}"]
        
        
#         case0=self.helper(amount,coins,index+1)
#         case1=self.helper(amount-coins[index],coins,index)
        
#         self.mapp[f"{index},{amount}"]=case0+case1
#         return case0+case1
        
    
    
        