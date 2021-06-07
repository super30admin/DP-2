// Time Complexity : O(n)
// Space Complexity : O(1) in the most efficient solution
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach

public class PaintHouse {
public int minCost(int[][] costs) {
    if(costs==null||costs.length==0)
        return 0;
    /*
    0=blue
    1=green
    2=red
    */
    /*
   //3 trees: recursive approch is top down
    //minimum cost when 1st house is blue
    int case1=helper(costs,0,0,0);
     //minimum cost when 1st house is green
     int case2=helper(costs,1,0,0);
    //minimum cost when 1st house is red
     int case3=helper(costs,2,0,0);*/

     //DP approch is bottom up
    int lastRow=costs.length-1;
    int prevB=costs[lastRow][0];
    int prevG=costs[lastRow][1];
    int prevR=costs[lastRow][2];
    //Starting at the second last row and finding minimum paths that can be added while going up

    for(int i=costs.length-2;i>=0;i--)
    {
        int tempB=prevB, tempG=prevG, tempR=prevR;
        /*costs[i][0]=costs[i][0]+ Math.min(costs[i+1][1],costs[i+1][2]);
        costs[i][1]=costs[i][1]+ Math.min(costs[i+1][0],costs[i+1][2]);
        costs[i][2]=costs[i][2]+ Math.min(costs[i+1][0],costs[i+1][1]);*/
        prevB=costs[i][0]+ Math.min(prevG,prevR);
        prevG=costs[i][1]+ Math.min(tempB,prevR);
        prevR=costs[i][2]+ Math.min(tempB,tempG);
    }
    
    //return Math.min(case1,Math.min(case2,case3));
    return Math.min(prevB,Math.min(prevR,prevG));
}

public int helper(int[][] costs,int color,int row,int mincost)
{
    //base
    if(row==costs.length)
        return mincost;
    
    //logic
    if(color==0)
    {
        return Math.min(helper(costs,1,row+1,mincost+costs[row][0]),
                        helper(costs,2,row+1,mincost+costs[row][0]));
    }
    if(color==1)
    {
        return Math.min(helper(costs,0,row+1,mincost+costs[row][1]),
                        helper(costs,2,row+1,mincost+costs[row][1]));
    }
    if(color==2)
    {
        return Math.min(helper(costs,0,row+1,mincost+costs[row][2]),
                        helper(costs,1,row+1,mincost+costs[row][2]));
    }
    
    return 3453;
} 

}