#Time Complexity:O(n*m)
#Space Complexity:O(n*m)
#n-Number of coins
#m-Amount
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        amt=[[0]*(amount+1)]*(len(coins)+1)
        for i in range(len(coins)):
            amt[i][0]=1
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if coins[i-1]>j:
                    amt[i][j]=amt[i-1][j]
                else:
                    amt[i][j]=max(amt[i-1][j],amt[i-1][j]+amt[i][j-coins[i-1]])
        return amt[len(coins)][amount]