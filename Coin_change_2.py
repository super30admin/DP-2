#LeetCode Submission: successful
#time compleity:O(n*2) in the worst case where number of coins and amount are same
#space complexity: O(n) where n is the amount 
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        #empty array 
        out=[0]*(amount+1)
        #number of ways of choosing 0 is 1
        
        out[0]=1
        for c in coins:
            for i in range(1,amount+1):
                if i >= c:
                    #print(i)
                    #updatating as per the coin value
                    out[i]+=out[i-c]
                    #print (out[i])
        return out[amount]