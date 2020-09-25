class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        """
        #Brute force: Recursive with exponetial time, nested binary tree grows 
        
        #Dynamic Programming
        Bottom up approach.

        #Time complexity: O(nk)
        k = amount

        #Space complexity: O(k+1)
        we are using amount k + 1 array size.

        """
        n = len(coins)
        arr = [0] * (amount + 1)
        arr[0] = 1
        for i in range(n):
            for j in range(1, amount + 1):
                if coins[i] <= j:
                    arr[j] = arr[j] + arr[j - coins[i]]
                    
        return arr[-1]