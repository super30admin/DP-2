// Time Complexity : O(n) n refers to the number of houses
// Space Complexity : O(m) m refers to the number of colors, Here 3 is constant, So it can be O(1)
// Did this code successfully run on Leetcode : No, I could not try it on leetcode
// Any problem you faced while coding this : No





class PaintHouse
{
	public int mincost(int[][] costs)
        {
		if(costs.length==0) return 0;
 		int red = costs[0][0]; //Assigning the values of the first house cost of each color
		int blue = costs[0][1];
		int green = costs[0][2];
		int temp_red, temp_blue, temp_green;

		for(int i=1;i<costs.length;i++) //Iterating over the costs of each house
		{
			temp_red=red; //Temporary variables store the costs until the previous house 	
			temp_blue=blue;
			temp_green=green;
			red = costs[i][0] + Math.min(temp_blue,temp_green); //Current color is the chosen one and we add it to the minimum of previous 2 colors
			blue = costs[i][1] + Math.min(temp_red,temp_green);
			green = costs[i][2] + Math.min(temp_red, temp_blue);
		}		
	 return Math.min(red, Math.min(blue,green));
	}
}