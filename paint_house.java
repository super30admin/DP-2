// Time Complexity :o(n) n- length of the array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :N/A 
// Any problem you faced while coding this : logic
class PaintHouse{
		
public int minCost(int[][] costs) {
    if(costs==null||costs.length==0)
        return 0;
 
    for(int i=1; i<costs.length; i++){
		// cumulating best min for all the colors
	   costs[i][0]+=Math.min(costs[i-1][1]+costs[i-1][2]);
       costs[i][1]+=Math.min(costs[i-1][0]+costs[i-1][2]);
	   costs[i][2]+=Math.min(costs[i-1][0]+costs[i-1][1]);
	}
	int m=costs.length-1;
    return Math.min(Math.min(costs[m][0],costs[m][1]),costs[m][2]); // return the mim cost among the three choices
}
}