## Problem1(https://leetcode.com/problems/paint-house/)


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount 
        my_arr = [0]*(n+1)
        my_arr[0]=1
        for i in range(1,m+1):
            for j in range(n+1):
                if coins[i-1] > j:
                    my_arr[j] = my_arr[j]
                else:
                    my_arr[j] = my_arr[j] + my_arr[j-coins[i-1]]
        return my_arr[n]