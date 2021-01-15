#Time Complexity :O(amount*n)
#Space Complexity :O(amount) NOT SURE
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def _newArray(self,size):
        return [0]*size
        
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if(coins==None):
            return 0
    
        arr=[]
        for i in range(len(coins)+1):
            arr.append(self._newArray(amount+1))
        
        for i in range(len(arr)):
            arr[i][0]=1
        
        
        for i in range(1,len(arr)):
            for j in range(1,len(arr[0])):
                if(coins[i-1]>j):
                    arr[i][j]=arr[i-1][j]
                else:
                    arr[i][j]=arr[i-1][j]+arr[i][j-coins[i-1]]
        
        return(arr[len(arr)-1][len(arr[0])-1])
        
        
        
        
#         if(len(coins)==0 or coins==None):
#             return 0
        
#         return self.helper(coins,amount,0)
    
#     def helper(self,coins,amount,index):
#         #base case
#         if(amount==0):
#             return 1
#         if(index==len(coins) or amount<0):
#             return 0
            
#             #logic
#             #we choose
#         case1=self.helper(coins,amount-coins[index],index)
#             #we dont choose
#         case2=self.helper(coins,amount,index+1)
            
#         return case1+case2
            