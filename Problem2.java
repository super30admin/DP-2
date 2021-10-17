class Solution {
    public int change(int amount, int[] coins) {
        int data[] = new int[amount+1];
        data[0] = 1;
        for(int i:coins)
            for(int j=i;j<amount+1;j++)
                data[j] += data[j-i];
        return data[amount];
    }
}