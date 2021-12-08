/*
Question is to find out which house to be painted what. Condition given that if a house is painted a color the immediate house below it can't be painted the same.
There's cost for each house to be painted. We need to get the minimum.

R   B   G
17  2   3
16  1   5
5   3   4

Greedy doesn't work as accdg to greedy we can have (2+5+3 = 10)
but min can be (3+1+4 = 8)
Let's try recursive then,

                17
        1           5
    5       4   5       3
(5+1+17)(4+1+17)(5+5+17)(3+5+17)

               3
        16          1
    3       4   5       4

                2
        16          5
    3       4   5       3
As we can se there are multiple subproblems i.e     5
                                                5       3

We will move ahead and choose dynamic programming.
First approach: Mutating approach
In this approach we will start from second last row and add each number with the last row numbers which are allowed and update the second last row with the minimum. It is also called mutating.
Iterate and move ahead.

R   B   G
17  2   3
16  1   5
5   3   4

Let's mutate it step by step
R       B       G
17      2       3
(16+3)  (1+4)   (5+3)
5       3       4

R       B       G
(17+5)  (2+8)   (3+5)
19      5       8
5       3       4

Now take minimum from first row i.e 8
T.C -> O(n) //M*N but since m is only 3 colours we are left with n
S.C -> O(1) //As no space is used. We update in the same array

Second Approach: Keep an array
*/

public class painthouse {
    public int minCost(int[][] costs){
    if(costs == null || costs.length == 0) return 0;
    int n = costs.length;
    for(int i=n-2;i>=0; i--){
        costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
        costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
        costs[i][2] = costs[i][2] + Math.min(costs[i+1][0],costs[i+1][1]);
    }
    return Math.min(costs[0][0],Math.min(costs[0][1],costs[0][2]));
    }
}