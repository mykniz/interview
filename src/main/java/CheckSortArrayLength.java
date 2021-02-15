public class CheckSortArrayLength {
    public static void main(String[] args) {
        int[] arr1 = {2, 1, 4, 1, 2, 3, 4, 5, 6, 7, 3, 1};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int[] arr3 = {3, 2, 1};
        checkSortArrayLength(arr1);
        checkSortArrayLength(arr2);
        checkSortArrayLength(arr3);
    }

    static void checkSortArrayLength(int[] array) {

        int k = 1;
        int m = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] >= array[i]) {
                k++;
            } else {
                k = 1;
            }
            if (k > m) {
                m = k;
            }
        }
        System.out.println(m);

    }
}
