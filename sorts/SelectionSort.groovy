package sorts

/**
     Find the smallest element in the array then swap it with the first index,
     continue with the second smallest and swap it with the second index and so on.

     Worst Time Complexity: O(n^2)

     Best Time Complexity: O(n^2)

     Space Complexity: O(1)
 **/
class SelectionSort {
    static selectionSort(arr) {
        def l = arr.size()
        l.times { i ->
            def smallest = i
            for (int j = i + 1; j < l; j++)
                if (arr[j] < arr[smallest])
                    smallest = j
            arr.swap(i, smallest)
        }
        arr
    }

    static void main(String[] args) {
        def arr = [2, 3, 5, 1, 6, 4, 7]
        println selectionSort(arr)
        //output [1, 2, 3, 4, 5, 6, 7]

        arr = ['f', 'd', 'a', 'c', 'b', 'e']
        println selectionSort(arr)
        //output [a, b, c, d, e, f]
    }
}
