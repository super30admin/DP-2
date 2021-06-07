//Time Complexity: O(3N) = O(N)
//Space Complexity: O(3N) = O(N)
//Runtime: 2 ms, faster than 27.28% of Java online submissions for Paint House.
//Memory Usage: 40 MB, less than 29.66% of Java online submissions for Paint House.

class Solution {
    public int minCost(int[][] costs) {
        
        int row = costs.length;
        int col = costs[0].length;
        
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                if(j == 0){
                    costs[i][j] = costs[i][j] + Math.min(costs[i-1][1],costs[i-1][2]);
                }else if(j == 1){
                    costs[i][j] = costs[i][j] + Math.min(costs[i-1][0],costs[i-1][2]);
                }else{
                    costs[i][j] = costs[i][j] + Math.min(costs[i-1][0],costs[i-1][1]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            ans = Math.min(costs[row-1][i], ans);
        }
        
        return ans;
    }
}











/*
Recursive solution
class Solution {
    public int minCost(int[][] costs) {

        int red = helper(costs, 0, 0, 0);
        int green = helper(costs, 1, 0, 0);

        int blue = helper(costs, 2, 0, 0);

        int min12 = Math.min(red, green);
        int minFinal = Math.min(min12, blue);

        return minFinal;

    }

    private int helper(int[][] costs, int color, int index, int total) {

        total = costs[index][color];

        if (index == costs.length - 1)
            return total;

        if (color == 0) {
            total += Math.min(helper(costs, 1, index + 1, total + costs[index][0]),
                    helper(costs, 2, index + 1, total + costs[index][0]));

        }
        //case 1:
        if (color == 1) {

            total += Math.min(helper(costs, 0, index + 1, total + costs[index][1]),
                    helper(costs, 2, index + 1, total + costs[index][1]));

        }

        if (color == 2) {

            total += Math.min(helper(costs, 0, index + 1, total + costs[index][2]),
                    helper(costs, 1, index + 1, total + costs[index][2]));

        }

        return total;

    }

}*/












