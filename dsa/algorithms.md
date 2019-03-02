### [Bubble Sort](https://en.wikipedia.org/wiki/Bubble_sort) *&larr; Runtime: O(n2); Memory: O(1)*

### [Selection Sort](https://en.wikipedia.org/wiki/Selection_sort) *&larr; Runtime: O(n2); Memory: O(1)*

### [Radix Sort](https://en.wikipedia.org/wiki/Radix_sort) *&larr; Runtime: O(nk); Memory: O(n+k)*

### [Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm) *&larr; Runtime: O(log n); Memory: O(1)*
```
class MyArray {
    static int binarySearch(Integer[] a, Integer x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            System.out.print(mid);
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                System.out.println();
                return mid;
            }
            System.out.print(" > ");
        }
        return -1; // Error
    }
}
```

### [Merge Sort](https://en.wikipedia.org/wiki/Merge_sort) *&larr; Runtime: O(n log(n)); Memory: O(n)*
```
class MyArray {
    static Integer[] mergeSort(Integer[] list) {
        if (list.length <= 1) {
            return list;
        }
        // Split the array in half in two parts
        Integer[] first = new Integer[list.length / 2];
        Integer[] second = new Integer[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        // Sort each half recursively
        mergeSort(first);
        mergeSort(second);
        // Merge both halves together, overwriting to original array
        merge(first, second, list);
        return list;
    }
    private static void merge(Integer[] first, Integer[] second, Integer[] result) {
        int iFirst = 0, iSecond = 0, iMerged = 0;
        // Compare elements at iFirst and iSecond and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        // Copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
```

### [QuickSort](https://en.wikipedia.org/wiki/Quicksort) *&larr; Runtime: O(n log(n)); Memory: O(log(n))*
The partitioning element is not guaranteed to be the median &rarr; worst case runtime O(n^2^)
```
class MyArray {
    static Integer[] quickSort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }
    private static void quickSort(Integer[] arr, int left, int right) {

        int partition = partition(arr, left, right);

        if (partition - 1 > left) {
            // Sort left half
            quickSort(arr, left, partition - 1);
        }
        if (partition + 1 < right) {
            // Sort right half
            quickSort(arr, partition + 1, right);
        }
    }
    private static int partition(Integer[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        return start;
    }
}
```

### More Information
- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
