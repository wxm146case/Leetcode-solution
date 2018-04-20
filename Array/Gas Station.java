//Gas Station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int start = -1;
        
        
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            
            if (sum < 0) {
                start = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start + 1;
    }
}