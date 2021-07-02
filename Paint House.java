// time - n
// space - constant

//dp in-place

class Solution {
    public int minCost(int[][] cost) {

    for(int i=cost.length-2 ; i>=0 ; i--)
    {
        cost[i][0] += Math.min(cost[i+1][1],cost[i+1][2]);
        cost[i][1] += Math.min(cost[i+1][0],cost[i+1][2]);
        cost[i][2] += Math.min(cost[i+1][1],cost[i+1][0]);
    }
        return Math.min(cost[0][0] , Math.min(cost[0][1],cost[0][2]));
    }
}

//

class Solution {
    public int minCost(int[][] costs) {

    int red = helper(costs , 0 , 0 , 0);
    int blue =  helper(costs , 0 , 1 , 0);
    int green = helper(costs , 0 , 2 ,0);

    return Math.min(red,Math.min(blue,green));

    }

    private int helper(int[][] cost ,int row , int color , int price)
    {
        //base case

        if(row == cost.length) return price;

        //recursive case

        if(color == 0)
        return Math.min(
            helper(cost , row+1 , 1 , price+cost[row][1]) , helper(cost , row+1 , 2 , price+cost[row][2])
        );

        else if(color == 1)
        return Math.min(
            helper(cost , row+1 , 0 ,  price+cost[row][0]) , helper(cost , row+1 , 2 ,  price+cost[row][2])
        );

        else
        return Math.min(
            helper(cost , row+1 , 0 ,  price+cost[row][0]) , helper(cost , row+1 , 1 ,  price+cost[row][1])
        );

    }
}
