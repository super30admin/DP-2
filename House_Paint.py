class Solution:
    def helper(self,costs, house, color, total):
        
        if(house==len(costs)-1):
            # print("exit", house, color)
            return total+costs[house][color]
        else:
            # print(house, color)
            c=costs[house][color]
            if(color==0):
                next_c1=1
                next_c2=2
            if(color==1):
                next_c1=0
                next_c2=2
            if(color==2):
                next_c1=0
                next_c2=1
            c_t= min(self.helper(costs,house+1, next_c1, total+c), self.helper(costs, house+1, next_c2, total+c))
            return c_t
    
    def minCost(self, costs: List[List[int]]) -> int:
        # exhaustive Solution
        # red=self.helper(costs, 0, 0, 0)
        # blue=self.helper(costs, 0, 1, 0)
        # green=self.helper(costs, 0, 2, 0)
        # ans=min(red, blue, green)
        # return ans

        # Dp Solution
        dp_matrix=[[None for i in range(len(costs[0]))] for i in range(len(costs))]
        for i in range(3):
            dp_matrix[-1][i]=costs[-1][i]

        for i in range(len(costs)-2,-1, -1):
            print(i)
            dp_matrix[i][0]=min(dp_matrix[i+1][1], dp_matrix[i+1][2])+costs[i][0]
            dp_matrix[i][1]=min(dp_matrix[i+1][0], dp_matrix[i+1][2])+costs[i][1]
            dp_matrix[i][2]=min(dp_matrix[i+1][0], dp_matrix[i+1][1])+costs[i][2]
        print(dp_matrix)
        return min(dp_matrix[0][0], dp_matrix[0][1], dp_matrix[0][2])