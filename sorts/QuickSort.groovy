package sorts
/**
    Quick Sort

    Continuously split the array into two sub arrays in a way that all elements
    in the first subarray are less than the elements in the second subarray.

    We need to find the Pivot/splitting point in order to break the array in half. How?

    first:
        Choose the pivot by following:
        Choose the first or last item in the array. NOT A GOOD CHOICE, can lead to an empty sub array,
        or arr[RandomIndex],
        or arr[arr.size/2]

    second:
        Move the Left/Low and Right/High indexes with following comparison:

            leftIndex < pivot < rightIndex ? swap the elements, continue as far as leftIndex is less than rightIndex

    The array will be manipulated by Left/Low and Right/High indexes, so there will be no additional spaces used.

    After moving the pivot to the right position, split the array and keep the pivot separated.

    Continue recursively until the array gets sorted.

    AVOID SPLITTING TO EMPTY SUBARRAY.

    Worst Time Complexity : O(n^2)

    Best Time Complexity : O(n log n)

    Space Complexity: O(n log n)

**/

class QuickSort {

    static def quickSort(arr, low, high) {
        if (low < high) {
            def pi = partition(arr, low, high)
            quickSort(arr, 0, pi - 1)
            quickSort(arr, pi + 1, high)
        }
        arr
    }

    static def partition(arr, low, high) {
        def pivotValue = arr[high]
        def pi = low - 1
        for (low; low <= high - 1; low++) {
            if (arr[low] <= pivotValue) {
                pi++
                arr.swap(pi, low)
            }
        }
        arr.swap(++pi, high)
        pi
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 6, 8, 3]

        println quickSort(arr, 0, arr.size() - 1)
        //output [1, 2, 3, 4, 5, 6, 7]

        arr = ['f', 'd', 'a', 'c', 'b', 'e']
        println quickSort(arr, 0, arr.size() - 1)
        //output [a, b, c, d, e, f]
    }
}
