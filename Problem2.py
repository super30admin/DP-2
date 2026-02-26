#Coin Change II

#Time complexity = O(n+1*m+1) where n is length of coins and m is the amount
#Space complexity O(m+1)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        arr = [0]*(amount+1)
        arr[0] = 1

        for coin in coins:
            for j in range(0,amount+1):
                noChoose = arr[j]
                choose = 0
                if j >=coin:
                    choose = arr[j-coin]
                arr[j] = choose + noChoose
        return arr[amount]
