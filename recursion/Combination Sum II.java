//Combination Sum II

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        int[] added = new int[candidates.length];
        helper(candidates, results, new ArrayList<Integer>(),added, 0, 0, target);
        return results;
    }
    
    private void helper(int[] candidates, List<List<Integer>> results, List<Integer> list, int[] added, int sum, int index, int target) {
        if (sum == target) {
            results.add(new ArrayList<Integer>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            if (added[i] == 1) {
                continue;
            }
            if (i != index && candidates[i] == candidates[i - 1] && added[i - 1] == 0) {
                continue;
            }
            list.add(candidates[i]);
            added[i] = 1;
            if (sum + candidates[i] <= target) {
                helper(candidates, results, list, added, sum + candidates[i], i, target);
            }
            list.remove(list.size() - 1);
            added[i] = 0;
            
        }
    }
}