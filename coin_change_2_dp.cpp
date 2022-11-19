/*
 * @Author: Yuvaraj Nagi
 * @Date: 2022-11-16 18:55:59
 * @Last Modified by: Yuvaraj Nagi
 * @Last Modified time: 2022-11-16 19:35:50
 * Time complexity : O(m x n)
 * Space Complexity : O(m x n)
 *
 */

#include <vector>

using namespace std;
class Solution
{
public:
    int change(int amount, vector<int> &coins)
    {
        // coin change 2 : using dynamic programming to solve our problem:
        // first declare a matrix of rows of size amount and columns of size coins

        int r = coins.size() + 1;
        int c = amount + 1;

        int matrix[r][c];

        // initializing everything after first element in row 1 to 0
        for (int i = 0; i < c; i++)
        {
            matrix[0][i] = 0;
        }

        // initializing everything in row 1 to 1
        for (int j = 0; j < r; j++)
        {
            matrix[j][0] = 1;
        }

        for (int i = 1; i < r; i++)
        {
            for (int j = 1; j < c; j++)
            {
                if (j < coins[i - 1])
                {
                    // column index is lesser than coins array element
                    matrix[i][j] = matrix[i - 1][j];
                }

                else
                {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - coins[i - 1]];
                }
            }
        }

        return matrix[r - 1][c - 1];
    }
};