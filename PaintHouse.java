class PaintHouse {
    //time: O(n)
    //space: O(1)
	//Did it run successfully on leetcode: yes
    public int minCost(int[][] costs) {
        //initializing cost variable for each color of colors
        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];
        //looping through cost array
        for(int i=1; i<costs.length; i++){
            //temporary variable to store previous color costs
            int tmpR = r, tmpB=b, tmpG = g;
            //updating red when selected color of previous house was not red
            r = Math.min(tmpB+costs[i][0], tmpG+costs[i][0]);
            //updating blue when selected color of previous house was not blue
            b = Math.min(tmpR+costs[i][1], tmpG+costs[i][1]);
            //updating green when selected color of previous house was not green
            g = Math.min(tmpR+costs[i][2], tmpB+costs[i][2]);
        }
        
        //giving out the least cost among the ree color when we reach the last house
        return Math.min(r, Math.min(b, g));
    }

}