class Solution {
    public int change(int amount, int[] coins) {
        int[] p = new int[amount+1];
        p[0] = 1;
        for (int coin : coins) {
            for(int a = coin; a<=amount; ++a){
                p[a] += p[a-coin];
            }
        }
        return p[amount];
}
}
//tc=O(an)
//sc=O(a)
