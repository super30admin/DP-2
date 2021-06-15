class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
    
    
        #Initializinng the Matrix array M with value 0's
        M = [0]*(amount +1)

        #defining the First column with value 1
        M[0] = 1

        #Defining loops for getting total no of ways.
        for j in coins:

            for i in range(j,amount+1):
                #addding all the possible ways of amount
                M[i] = M[i] + M[i-j]

        return M[amount]
    

#This problem involves getting the total number wa ways in which combination of coin add upto the the given amount.
#Time complexity - O(N*amount) 
#Space complexity - O(amount)  storing the M array matrix

