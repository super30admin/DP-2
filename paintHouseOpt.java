//Compare previous row other two color min value
//and update the current value
public class painHouseDP {
    public  int minCost(int[][] costs)
    {
        //null
        if(costs == null || costs.length == 0 )return 0;
        int n = costs.length;
        //create a new dp with rows = no. of houses
        //columns = no of colors
        //first initialize the last row of dp with the array values as it is
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];
        //start from the 2nd last row from bottom and populate
        for(int i=n-2;i>=0;i--)
        {
            int tempR = costR;
            costR = costs[i][0] + Math.min(costB, costG)
            //if color 0 is selected then take the min cost of selecting colr 1 or color 2 from other row above
            int tempB = costB;
            costB = costs[i][1] + Math.min(tempR,costG);
            costG = costs[i][2] + Math.min(tempR,tempB);
            
        }
        return Math.min(costR, Math.min(costB, costG));
    }
}
