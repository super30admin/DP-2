class Solution {
    public static int minCost(int[][] costs) {
        if(costs==null || costs.length==0){return 0;}

        for(int i=1;i<costs.length;i++)
        {
            costs[i][0]+=(Math.min(costs[i-1][1],costs[i-1][2]));
            costs[i][1]+=(Math.min(costs[i-1][0],costs[i-1][2]));
            costs[i][2]+=(Math.min(costs[i-1][0],costs[i-1][1]));
        }
        int l= costs.length-1;
        return Math.min(Math.min(costs[l][0],costs[l][1]),costs[l][2]);
    }
    public static void main (String[] args) {
        
        int arr[][]=new int[][]{{1,2,1},{3,3,6},{4,1,9},{2,7,1}};
        System.out.println(minCost(arr));
    }
}