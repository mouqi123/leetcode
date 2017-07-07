import java.util.*;
public class Subset78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets(subsets, new ArrayList<Integer>(), nums, 0);
        return subsets;
    }

    public static void subsets(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int k) {

        if (k == nums.length) {
            return;
        }

        for (int i = k; i < nums.length; i++) {
            List<Integer> l1 = new ArrayList<>(subset);
            subsets.add(l1);
            subset.add(nums[
            subsets(subsets, subset
        }

        List<Integer> forkSet = new ArrayList<>(subset);
        subset.add(k);

        List<Integer> l1 = new ArrayList<>(subset);
        List<Integer> l2 = new ArrayList<>(forkSet);
        subsets.add(l1);    subsets.add(l2);

        subsets(subsets, subset, nums, k+1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3};
        System.out.println(subsets(a));
    }
}
