#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if(len(costs)==0 or costs==None):
            return 0
        leng=len(costs)-1
        b=costs[leng][0]
        g=costs[leng][1]
        r=costs[leng][2]
        print(b,g,r)
        for i in range(len(costs)-2,-1,-1):
            tb=b
            tg=g
            b=costs[i][0]+min(r,g)
            g=costs[i][1]+min(tb,r)
            r=costs[i][2]+min(tg,tb)
            
        return min(b,g,r) 
        
        
#         if(len(costs)==0 or costs==None):
#             return 0
        
#         for i in range(len(costs)-2,-1,-1):
#             costs[i][0]+=min(costs[i+1][1],costs[i+1][2])
#             costs[i][1]+=min(costs[i+1][0],costs[i+1][2])
#             costs[i][2]+=min(costs[i+1][0],costs[i+1][1])
        
#         return min(costs[0][0],costs[0][1],costs[0][2])
            
        
        
#         if(costs==None or len(costs)==0):
#             return 0
        
#         case1=self.helper(costs,0,0,0)
#         case2=self.helper(costs,0,1,0)
#         case3=self.helper(costs,0,2,0)
#         return min(case1,case2,case3)
        
#     def helper(self,costs,index,color,amount):
#         #base
#         if(index==len(costs)):
#             return amount
        
#         #logic
#         if(color==0):
#             return min(self.helper(costs,index+1,1,amount+costs[index][0]),
#             self.helper(costs,index+1,2,amount+costs[index][0]))
            
#         elif(color==1):
#             return min(self.helper(costs,index+1,0,amount+costs[index][1]),
#             self.helper(costs,index+1,2,amount+costs[index][1]))
#         else:
#             return min(self.helper(costs,index+1,0,amount+costs[index][2]),
#             self.helper(costs,index+1,1,amount+costs[index][2]))
            
        
                
                