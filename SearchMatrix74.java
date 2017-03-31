public class SearchMatrix74 {
    
    public static boolean binarySearch(int[] a, int key) {

        int i = 0, j = a.length ;

        while (i < j) {
            
            int middle = (i + j) / 2;

            if (a[middle] > key) { j = middle ; }

            else if (a[middle] < key) { i = middle + 1; }

            else return true;

        }
        
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return false;

        int rows = matrix.length;

        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            int rowMax = matrix[i][cols-1];

            if (target < matrix[i][0]) return false;

            if (target == matrix[i][cols-1] || target == matrix[i][0]) return true;

            if (target > matrix[i][cols-1]) continue;

            return binarySearch(matrix[i], target);
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1,3,5,7}};
        int[] b = {1,3,5,7};
        int[] c = {3};
        int[] d = {3,5};

        System.out.println(searchMatrix(a, 3));
        System.out.println(binarySearch(b, 3));
        System.out.println(binarySearch(c, 1));
        System.out.println(binarySearch(c, 4));
        System.out.println(binarySearch(c, 3));
        System.out.println(binarySearch(c, 2));
        System.out.println(binarySearch(c, 4));
        System.out.println(binarySearch(c, 6));
    }

}
