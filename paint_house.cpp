// Time Complexity : O(mn) : m being no of paints, n being no of houses
// Space Complexity : O(m);
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : Implementing this without using any extra space apart form the O(m) was a bit confusing for me


// Your code here along with comments explaining your approach
//1.Edge case
//A. costs size 0 then return 0

//2. Calculate cost : Array method for the DP is implemented
//A. when we deal with first house we have no reference so copy initial cost as is.
//B. fill other house cost with reference to minimum value in the previous cost calculation


class Solution {

    int  calculate_minimum_cost (vector<vector<int>> &costs){
        //2.A
        vector<int> cost_calculation_for_each_house(costs[0].begin(), costs[0].end());
        
        //2.B
        for(int house_num =1 ; house_num<costs.size(); house_num++ ){
            int cost_prev_red = cost_calculation_for_each_house[0], cost_prev_blue= cost_calculation_for_each_house[1], cost_prev_green= cost_calculation_for_each_house[2];
            cost_calculation_for_each_house[0] = costs[house_num][0] + min(cost_prev_blue, cost_prev_green);
            cost_calculation_for_each_house[1] = costs[house_num][1] + min(cost_prev_red, cost_prev_green);
            cost_calculation_for_each_house[2] = costs[house_num][2] + min(cost_prev_red, cost_prev_blue);
        }
      
        // return min_element(cost_calculation_for_each_house.begin(),cost_calculation_for_each_house.end());
        return min(cost_calculation_for_each_house[0], min(cost_calculation_for_each_house[1], cost_calculation_for_each_house[2]));
    }

public:
int minCost(vector<vector<int>> &costs) {
    //1.A
    if(costs.size()==0){
        return  0;
    }
    //2.
    return calculate_minimum_cost(costs);
}
};

