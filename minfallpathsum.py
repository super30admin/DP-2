class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        for i in range(len(A) - 2, -1, -1):
            for j in range(len(A[i])):
                mini = A[i + 1][j]
                if (j == 0):
                    mini = min(A[i + 1][j], A[i + 1][j + 1])
                elif (j == len(A[0]) - 1):
                    mini = min(A[i + 1][j], A[i + 1][j - 1])
                else:
                    mini = min(min(A[i + 1][j - 1], A[i + 1][j]), A[i + 1][j + 1])
                A[i][j] = A[i][j] + mini

        result = 100
        for j in range(0, len(A[0])):
            if A[0][j] < result:
                result = A[0][j]
        return result