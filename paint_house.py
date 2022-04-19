class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        '''
        T = O(N)
        S = O(1)
        '''
        if not costs:return 0 
        n = len(costs)
        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0] + min( costs[i+1][1] , costs[i+1][2]  )
            costs[i][1] = costs[i][1] + min( costs[i+1][0] , costs[i+1][2]  )
            costs[i][2] = costs[i][2] + min( costs[i+1][0] , costs[i+1][1]  )
        return min( costs[0][0] , costs[0][1] , costs[0][2]  )
    
    def BruteForceminCost(self, costs: List[List[int]]) -> int:
        '''
        T = O(2^n)
        S = O(1)
        '''
        if not costs: return 0 
        case1 = self.helper( costs , 0 , 0 , 0  )
        case2 = self.helper( costs , 0 , 1, 0  )
        case3 = self.helper( costs , 0 , 2, 0  )
        return min( case1 ,case2 ,  case3 )
        
    def BruteForcehelper( self , costs , row , color , costsofar  ):
        if row == len(costs):
            return costsofar
        
        if color == 0:
            return min( self.helper( costs , row+1, 1, costsofar + costs[row][0] ) , 
                        self.helper( costs , row+1, 2, costsofar + costs[row][0] )  )
        elif color == 1:
            return min(  self.helper( costs , row+1, 0, costsofar + costs[row][1] ) ,  
                         self.helper( costs , row+1, 2, costsofar + costs[row][1]  ) )
        elif color == 2:
            return min(  self.helper( costs , row+1, 0, costsofar + costs[row][2] ) ,  
                         self.helper( costs , row+1, 1, costsofar + costs[row][2] ) )
        
