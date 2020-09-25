class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if not coins and amount == 0:
            return 1
        if not coins and amount != 0:
            return 0
        
        
        subsets = []
        
        
        def backtrack(amount,index,path):
            if amount == 0:
                subsets.append(list(path))
                return
            if amount<0 or index>len(coins):
                return
            for i in range(index,len(coins)):
                path.append(coins[i])
                backtrack(amount-coins[i],i,path)
                path.pop()
                
        backtrack(amount,0,[])
        
        return len(subsets)
    
    # tc ---> o(n^((a/m)+1))
    # sc ---> o(a/m), a = amount, m = min(coins)
    #here i am using backtracking, return the length of the subset which had lists of denominations whose sum is equal to 
    # time limit exceeded on Leetcode
    
