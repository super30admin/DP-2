
# Recursive Programming
# 17/27 test cases passes
# time complexity =O(2^N)
#space complexity=O(N)
class Solution():
    def change(self, amount, coins):
        return self.helper_func(amount, coins,0)

    def helper_func(self, amount, coins, i):
        #basecase
        if (amount == 0 )  or (amount == 0 and coins == []): #2nd or condition s for edge case
            return 1
        if (amount < 0 or i > len(coins)-1):
            return 0
        case1 = self.helper_func(amount - coins[i], coins, i) #coin included
        case2 = self.helper_func(amount, coins, i+1) #coin included
        return case1+case2



class Solution_2(object):
    def change(self, amount, coins):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        count = 0
        return self.helper_function(coins,amount,0)
    def helper_function(self,coins,amount,i): #min is miimum coins
        count = 0
        if (amount < 0) or (i > (len(coins) -1)) :
            if coins == [] and amount == 0:
                count += 1
                return count
            # not (coins edgae when 0,[] and output has to be 1)
            return count
        elif amount == 0 :

            count += 1
            return count
        case1 = self.helper_function(coins,amount-coins[i],i) #this if the coin is to be included
        case2 = self.helper_function(coins,amount,i+1) #this if we have to move to next     #coin

        return case1+case2


class Solution_1(object):
    def change(self, amount, coins):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        count = 0
        return self.helper_function(coins,amount,0,0,count)
    def helper_function(self,coins,amount,i,min_coins,count): #min is miimum coins
        if (amount < 0) or (i > (len(coins) -1)) :
            if coins == [] and amount == 0:
                count += 1
                return count
            # not (coins edgae when 0,[] and output has to be 1)
            return count
        elif amount == 0 :

            count += 1
            return count
        case1 = self.helper_function(coins,amount-coins[i],i,min_coins+1,count) #this if the coin is to be included
        case2 = self.helper_function(coins,amount,i+1,min_coins,count) #this if we have to move to next     #coin

        return case1+case2
#v= Solution_1()
#print(v.coinChange([1,2,3,4],4))