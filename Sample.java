// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Paint House
//Using Recursion
//Time complexity -> 3 * exp
//Space Complexity -> 3 * exp
class Solution {

    //Using Recursion
    public int minCost(int[][] costs) {

        if(costs == null || costs.length == 0) return 0;

        int colorRed = helper(costs,0,0,0); //give min cost when we color red the 0th house and cost at starting is 0
        int colorBlue = helper(costs,0,1,0); //give min cost when we color blue the 0th house and cost at starting is 0
        int colorGreen = helper(costs,0,2,0); //give min cost when we color green the 0th house and cost at starting is 0

        return Math.min(colorRed,Math.min(colorBlue,colorGreen)); //return me the minimum between all the costs

        
        
    }

    private int helper(int[][] costs,int i,int color,int costAssociated){

        //Base case

        if(i == costs.length){ //it means if all the houses are colored just returned the costAssociated 
            return costAssociated;
        }

        //Logic
        //colors 
        //0 ->Red,1->Blue,2-> Green
        //int[][] costs -> costs of painting house
        //i -> house to be colored
        //color -> ith house to be colored (ith house can be Red,Blue,Green)
        //costAssociated -> costAssociated tilll now i.e cost associated before painting the house

        if(color == 0){ //i.e if we color ith house with color Red

            int caseBlue = helper(costs,i+1,1,costAssociated + costs[i][0]); //it means give me the cost to color next house with color Blue and cost till now is costAssociated + cost to color ith house with red costs[i][0]
            int caseGreen = helper(costs,i+1,2,costAssociated + costs[i][0]); //it means give me the cost to color next house with color Green and cost till now is costAssociated + cost to color ith house with red costs[i][0]

            //We are doing this because we can't color the next house with the same color i.e Red

            return Math.min(caseBlue,caseGreen); //Return me the min between the 2

        }

         if(color == 1){ //i.e if we color ith house with color Blue

            int caseBlue = helper(costs,i+1,0,costAssociated + costs[i][1]); //it means give me the cost to color next house with color Red and cost till now is costAssociated + cost to color ith house with Blue costs[i][1]
            int caseGreen = helper(costs,i+1,2,costAssociated + costs[i][1]); //it means give me the cost to color next house with color Green and cost till now is costAssociated + cost to color ith house with Blue costs[i][1]

            //We are doing this because we can't color the next house with the same color i.e Red

            return Math.min(caseBlue,caseGreen); //Return me the min between the 2

        }

         if(color == 2){ //i.e if we color ith house with color Green

            int caseBlue = helper(costs,i+1,0,costAssociated + costs[i][2]); //it means give me the cost to color next house with color Red and cost till now is costAssociated + cost to color ith house with Green costs[i][2]
            int caseGreen = helper(costs,i+1,1,costAssociated + costs[i][2]); //it means give me the cost to color next house with color Blue and cost till now is costAssociated + cost to color ith house with Green costs[i][2]

            //We are doing this because we can't color the next house with the same color i.e Red

            return Math.min(caseBlue,caseGreen); //Return me the min between the 2

        }

        return 234567;
    }
}
//Using 2D DP

//Time complexity -> O(n*3) -> O(n)
//Space Complexity ->O(n*3) 
class Solution {

    //Using dp
    public int minCost(int[][] costs) {

        int noOfHouses = costs.length;


    int[][] dp = new int[noOfHouses][3];

    dp[noOfHouses-1][0] = costs[noOfHouses-1][0] ; //last row oth index filled with cost[n-1][0] //Red  
    dp[noOfHouses-1][1] = costs[noOfHouses-1][1] ; //last row 1st index filled with cost[n-1][1] //Blue
    dp[noOfHouses-1][2] = costs[noOfHouses-1][2] ; //last row 2nd index filled with cost[n-1][2] //Green

    for(int i = noOfHouses-2;i>=0;i--){
         dp[i][0] = Math.min(dp[i+1][1],dp[i+1][2]) + costs[i][0]; //getting minimumbetween the other 2 and adding the cost to that level i.e coloring with Red
         dp[i][1] = Math.min(dp[i+1][0],dp[i+1][2]) + costs[i][1]; ///getting minimumbetween the other 2 and adding the cost to that level i.e coloring with Blue
         dp[i][2] = Math.min(dp[i+1][0],dp[i+1][1]) + costs[i][2]; ///getting minimumbetween the other 2 and adding the cost to that level i.e coloring with Green
    }
    
    return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2])); //Returing the minumum between the costs to color the oth house with Red,Blue or Green
    }
       
}

//Coin change 2
//Time Complexity -> exp
//Space Complexity -> exp
class Solution {
    //Using recursion
    public int change(int amount, int[] coins) {

        if(coins == null || coins.length ==0) return 0;

        return helper(coins,amount,0); //it means return me the desired path from coins[0] i.e from first coin
        
    }

    private int helper(int[] coins,int amount,int i){
        //base case

       if(amount ==0 ) return 1; //if amount becomes 0 we have found a valid path thats why we return 1
        if( i == coins.length) return 0; //if the coins are finished no valid path to create amounnt 

        if( amount< 0 ) return 0; //It means there is no valid path to create the amount using the amount
 

        //logic
        //Choose 
        int case1 = helper(coins,amount,i+1); //Not choosing the coin hence going to next index i.e next coin

        //Not choose
        int case2 = helper(coins,amount - coins[i],i); //Choosing the coin hence amount available will be amount - coin[i]

        return case1 + case2;
    }
}
//Time Complexity -> O(row * column)
//Space Complexity ->O(row *column)
class Solution {
    //using 2D DP Solution
    public int change(int amount, int[] coins) {

        if(coins == null || coins.length == 0) return 0;

        int row = coins.length;
        int columns = amount;

        int[][] dp = new int[row + 1][columns +1]; //+1 in both row and column because we have to see 0 case also
        dp[0][0] = 1; // Number of ways to make amount 0 with coin 0 will be 1 because whenever the amount becomes 0 it is a valid path hence it is possible to make 0 with coin 0
        for(int i=1;i<= columns;i++){
            dp[0][i] = 0; //we are doing it because it is not possible to make 1,2,3,4, etc with coin 0 thats why we are make the entries as 0
        }


        for(int i=1;i<=row;i++ ){
            for(int j=0;j<=columns;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[row][columns]; //returning the number of ways to make amount which is column and with coins till row i.e  for example [1,2,5]
        
    }
}
//Time complexity -> O(row *column)
//Space Complexity ->O(column)
class Solution {
    //Using 1 D dp
    public int change(int amount, int[] coins) {

        if(coins == null || coins.length ==0) return 0;

        int rows = coins.length;
        int columns = amount;

        int[] dp = new int[columns + 1];
        dp[0] = 1 ; // 0 amount can be made with 0 coins, Basically when there is amount 0, it means it is a valid path
        for(int i=1;i<=rows;i++){
            for(int j= 0;j<=columns;j++)
            if(j<coins[i-1]){ //if amount is less than the the coin at i, just use the previous value
                 dp[j] = dp[j]; //overiding the prevous value

            }
            else{
                dp[j] = dp[j] + dp[j-coins[i-1]]; //we are overiding by the previous value
            }
        }

        return dp[columns]; // just returning the last value
        
    }

   
}

//House Robber
//Using Recursion
class Solution {
    //Using Recursion
    public int rob(int[] nums) {

        return helper(nums,0,0);
        
    }

    private int helper(int[] nums,int i,int robbings){
        //base
        if(i>= nums.length) return robbings;

        //logic
        //dont choose
        int case1 = helper(nums,i+1,robbings); //I can rob the next house
        
        //choose
        int case2 = helper(nums,i+2,robbings + nums[i]) ; //I can not rob the next house that's why I did i+2 and add the cost of robbbery to the robbings

        return Math.max(case1,case2); //return the maximum robbings 
    }
}

//Using 1D Dp
class Solution {
    //Using Recursion
    public int rob(int[] nums) {

        if(nums == null || nums.length<2) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }

        return dp[n-1];
        
    }

    
}

//Using No extra Space
class Solution {
    //Using no space
    public int rob(int[] nums) {

        if(nums == null || nums.length<2) return nums[0];

        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int temp = curr;
            curr = Math.max(curr,nums[i] + prev);
            prev= temp;
        }

        return curr;
        
    }

    
}




