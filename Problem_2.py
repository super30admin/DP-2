# Time Complexity : O(Coins * Amount)
# Space Complexity : O(Coins * Amount)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : Followed approach from the class 
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
   
        m = [0] * (amount + 1)
        a=amount
        m[0]=1
        for j in coins:
            for i in range(1,a+1):
                if i>=j:
                    m[i]+=m[i-j]
        return m[a]
                