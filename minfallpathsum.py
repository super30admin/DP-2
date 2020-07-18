#time complexity: o(n2)
#it ran on leetcode
#No doubt

#explaination: we need to find the path which sums to  the lowest. So we traverse from the lowest row and find the minimum in their top row and add it
#and keep moving up


class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        for i in range(len(A) - 2, -1, -1): #loop to start from the last row of the matrix
            for j in range(len(A[i])):
                mini = A[i + 1][j]   #marking the minimum as matrix[2][0]
                if (j == 0):   #for first coloumn, since there are no elements towards the left, we just go down and diagonally right, find the
                    mini = min(A[i + 1][j], A[i + 1][j + 1]) #minimum among the two
                elif (j == len(A[0]) - 1): #similarly for the last coloumn, there are no elements towards the right. So just go dowm and  diagon .left
                    mini = min(A[i + 1][j], A[i + 1][j - 1])  #find the minimum among the two
                else:
                    mini = min(min(A[i + 1][j - 1], A[i + 1][j]), A[i + 1][j + 1]) #since this is not the first col or the last col or the first
                                    #col, it will be the the coloumn, we can go diagonally left, down, or diagonally right, find minimum among the three
                A[i][j] = A[i][j] + mini  #after we find the minimum, we add it to the index and again traverse up

        result = 100
        for j in range(0, len(A[0])): #all the sums are brought to the first row
            if A[0][j] < result:
                result = A[0][j] #we find the minimum among the first row
        return result       #return it