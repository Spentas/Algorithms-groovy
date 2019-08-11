package sorts
/*
    Continuously divide the array into equal halves and then combine them in a sorted manner.

    Time Complexity: O(n log n)

    Auxiliary Space: O(n)

    Paradigm: Divide and Conquer

    l = leftIndex
    r = rightIndex
    m = middleIndex

    [4, 2, 1, 3, 5, 8, 3, 7]
    [4, 2, 1, 3]
    [4, 2]
    [4]
    [2]
    [1, 3]
    [1]
    [3]
    [5, 8, 3, 7]
    [5, 8]
    [5]
    [8]
    [3, 7]
    [3]
    [7]
    [1, 2, 3, 3, 4, 5, 7, 8]

 */

class MergeSort {

    static mergeSort(arr, l, r) {
        println arr[l..r]
        if (l < r) {
            def m = l + (r - l).intdiv(2)
            mergeSort(arr, l, m)
            mergeSort(arr, m + 1, r)
            merge(arr, l, r, m)
        }
        arr
    }

    static merge(arr, l, r, m) {
        // sortedArrIndex
        def key = l
        // firstHalfIndex
        def i = 0
        // secondHalfIndex
        def j = 0

        def firstHalve = arr[l..m]
        def secondHalve = arr[m + 1..r]

        while (i < firstHalve.size() && j < secondHalve.size()) {
            if (firstHalve[i] < secondHalve[j])
                arr[key++] = firstHalve[i++]
            else
                arr[key++] = secondHalve[j++]
        }

        if (i < firstHalve.size())
            firstHalve[i..firstHalve.size() - 1].each { it ->
                arr[key++] = it
            }

        if (j < secondHalve.size())
            secondHalve[j..secondHalve.size() - 1].each { it ->
                arr[key++] = it
            }
    }

    static void main(String[] args) {
        def arr = [4, 2, 1, 3, 5, 8, 7]

        println mergeSort(arr, 0, arr.size() - 1)
        //output [1, 2, 3, 4, 5, 6]

        arr = ['f', 'd', 'a', 'c', 'b', 'e']
        println mergeSort(arr, 0, arr.size() - 1)
        //output [a, b, c, d, e, f]
    }
}