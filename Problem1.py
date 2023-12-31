"""
Time Complexity : O(mn) m is the number of colors and n is the number of houses
Space Complexity : O(n) we are using another array to store the result of an operation
Did this code successfully run on Leetcode : Yup
Any problem you faced while coding this : No issues faced


Your code here along with comments explaining your approach

We use a double loop and identify that for a certain house, what is the minimum cost with which we can paint it keeping
in mind the fact that we can repaint it with the same color

"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        def list_return(arr,ind):
            return arr[:ind] + arr[ind+1:]

        for i in range(1,len(costs)):
            for j in range(3):
                arr = list_return(costs[i-1],j)
                costs[i][j] += min(arr)

        return min(costs[-1])
