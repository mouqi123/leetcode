import java.util.*;
public class Subset78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets(subsets, new ArrayList<Integer>(), nums, 0);
        return subsets;
    }

    public static void subsets(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int k) {

        if (k == nums.length - 1) {
            List<Integer> l1 = new ArrayList<>(subset);
            List<Integer> l2 = new ArrayList<>(subset);
            l1.add(nums[k]);
            subsets.add(l1);    subsets.add(l2);
            return;
        }

        List<Integer> temp = new ArrayList<>(subset);
        temp.add(nums[k]);

        List<Integer> temp1 = new ArrayList<>(subset);
        subsets(subsets, temp, nums, k+1);
        subsets(subsets, temp1, nums, k+1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<List<Integer>> r = subsets(a);
        for (List<Integer> l : r) {
            System.out.println(l);
        }
    }
}
