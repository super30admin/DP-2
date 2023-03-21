class Solution {
	
	//Time: O(n)
	//Space: O(n)
    public int minCost(int[][] costs) {
        int[][] cache = new int[costs.length][3];
        int first =  dfs(0, 0, costs.length, costs, cache);
        int second =  dfs(1, 0, costs.length, costs, cache);
        int third =  dfs(2, 0, costs.length, costs, cache);

        int result = Math.min(first, second);
        result = Math.min(result, third);

        return result;
    }

    public int dfs(int selected_index, int house_no, int n, int[][] costs, int[][] cache){

        //base case. 

        if(house_no == n){
            return 0;
        }

        if(cache[house_no][selected_index] != 0){
            return cache[house_no][selected_index];
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){

            if(i == selected_index){
                continue;
            }

            int call_result = dfs(i, house_no + 1, n, costs, cache);
            result = Math.min(result, costs[house_no][i]+ call_result);

        }
        cache[house_no][selected_index] = result;

        return result;
    }
}