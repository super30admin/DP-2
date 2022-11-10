'''
Time Compelxity -->
O(n)

Space Complexity -->
O(n) since number of columns is fixed

Approach -->
Go from bottom to top
make sure to keep the track of the index if suppose we at 1st column the for the next row choose min(0, 2)
and similarly for 2nd and the 0th column and keep updating the particular row and column with min val
'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        #The 0, 1, 2 indicates R, B, G
        n = len(costs) 
        for i in range(n-2, -1, -1):
            for j in range(len(costs[i])):
                if j==0:
                    costs[i][j]+= min(costs[i+1][j+1], costs[i+1][j+2])
                elif j==1:
                    costs[i][j]+= min(costs[i+1][j-1], costs[i+1][j+1])
                else:
                    costs[i][j]+=min(costs[i+1][j-2], costs[i+1][j-1])
        print(costs)
        return min(costs[0])