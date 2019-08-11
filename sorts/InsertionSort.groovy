package sorts
/*
    Insertion Sort
        Starts from the second element (i) assign it to (key) and compare it with the elements to the left side
        if it is less than the left side element then swap it
        else continue going to the left until you reach to the index 0
        then advance the (i) until the end of the array
*/

class InsertionSort {

    static insertionSort(arr) {
        1.upto(arr.size() - 1) { i ->
            //second element
            def key = arr[i]
            //first element's index to the left of the second element
            def j = i - 1
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key
        }
        arr
    }

    static void main(String[] args) {
        def arr = [2, 3, 5, 1, 6, 4, 7]
        println insertionSort(arr)
        //output [1, 2, 3, 4, 5, 6, 7]

        arr = ['f', 'd', 'a', 'c', 'b', 'e']
        println insertionSort(arr)
        //output [a, b, c, d, e, f]
    }

}
