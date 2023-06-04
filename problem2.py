#Time Complexity is: O(m*n) where m is the len(coins)+1 and the n is amount+1
#Space Complexity is: O(m*n) where m is the len(coins)+1 and the n is amount+1
#Code ran sucessfully on leetcode
#Faced no issues while coding this problem

#To find the number of combinations that make up that amount
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        #If the length of the coins array is return we will return 0
        if(len(coins)==0):
            return 0
        #initializing a dimensional array of size amount+1,len(coins)+1
        self.dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        #intializing the dp[0][0] value to 1
        self.dp[0][0]=1
        for i in range(1,len(coins)+1):
            for j in range(0,amount+1):
                #If the value of coin denominaition is greater than amount, we will take previous denomination value
                if(coins[i-1]>j):
                    self.dp[i][j]=self.dp[i-1][j]
                #else we will add the values of self.dp[i-1][j]+self.dp[i][j-coins[i-1]]
                else:
                    self.dp[i][j]=self.dp[i-1][j]+self.dp[i][j-coins[i-1]]
        #finally returning the last value in the 2d array
        return self.dp[len(coins)][amount]

