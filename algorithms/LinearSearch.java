class LinearSearch {

    static void print(int[] arr, int n, int arr_size) {
        int result;
        for (int i = 0; i < arr_size; i++) {
            if (arr[i] == n) {
                result = i;
                System.out.print(result);
                break;
            }
        }

    }

    public static void main(String[] argvs) {
        int arr[] = { 9, 11, 12, 13, 21, 36, 37 };
        int n = 21;
        int m = arr.length;
        LinearSearch t = new LinearSearch();
        t.print(arr, n, m);
    }
}