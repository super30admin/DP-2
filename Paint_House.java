
public class Paint_House {
	public int minCost(int[][] costs) {
		//Approach: Here, the rule is no two adjacent houses should be painted with same color. Hence for every house we can calculate the cost for painting with a dp matrix
		//1. Here every row value depends on the row just above it, so we dont need the whole costs matrix, and to reduce space we can start modifying it.
		//2. initialization, we fill the first with same costs form the costs matrix. From second row, we start with house 1, if it has be painted red, we have to choose the
		//optimal value from blue and green. hence it is cost of painting 1st house with red and 0th house with either blue or green. 
		//Similarly, if am painting house 1 with blue, costs will be cost of painting house1 with blue + optimal(cost of painting house with red or green).
		//3. same way we calculate the cost of painting house1 with green color. 
		//4. we fill dp matrix like below. and calculate the minimum of last row.
		
		//houses/colors |R	 |	B| G
	//				0	|17	 |2  | 17
	//  			1	|18	 |33 | 7
	//				2	|21	 |10 | 37
        if(costs.length == 0 || costs == null)
            return 0;
        for(int i=1;i<costs.length;i++)
        {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }
}


//Time Complexity : O(n) where n is the number of houses 
//Space Complexity : O(1)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :