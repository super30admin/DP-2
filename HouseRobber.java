package s30.dp;


//Algo: At each point we have a decision to select and not select the current element.

//TC: O(n)
//SC: O(n)
public class HouseRobber {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];

        for(int index=0; index < nums.length; ++index){
            int select = index -2 < 0 ? (nums[index]) : dp[index-2]+ nums[index];

            int notSelect = index-1< 0 ? 0: dp[index-1];

            dp[index] = Math.max(select, notSelect);
        }
        return  dp[nums.length-1];
    }
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
