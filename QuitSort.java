public class QuitSort {
    public static void partion(int[] a, int p, int q) {
        if (p < q) {
            int k = sort(a, p, q);

            partion(a, p, k-1);
            partion(a, k + 1, q);
        }
    }

    public static int sort(int[] a, int p, int q) {
        int i = p, j = p;
        int key = a[q];
        while (j < q) {
            if ( a[j] < key) {
                int temp = a[i];
                a[i++] = a[j];
                a[j] = temp;
            }
            j++;
        }

        a[q] = a[i];
        a[i] = key;

        return i;

    }

    public static void main(String[] args) {
        int a[] = {3,2,1,5,6};
        partion(a,0, a.length-1);
        for (int i : a) System.out.print(i + " " );
        System.out.println();

        int[] b = {};
        partion(b,0, b.length-1);
        for (int i : b) System.out.print(i + " " );
        System.out.println();
    }

}
