package sorts

/*
    1. Generate a max heap from the given array. First element of the heap will be the largest element.
    2. Move the root of the heap(first element the array) to the end of the array(tracked by var heapSize)
    3. Reduce the heap size
    4. Repeat

    Time complexity = O(logn)
*/

class HeapSort {

    def static heapSort(arr) {
        def len = arr.size()
        def heapSize = len
        def middle = len.intdiv(2)

        // iterate through the heap to get the first maxHeap
        middle.downto(0) { it ->
            maxHeap(arr, heapSize, it)
        }

        (len - 1).downto(0) { it ->
            arr.swap(0, it)
            heapSize--
            maxHeap(arr, heapSize, 0)
        }
        arr
    }

    /*
        parent node = i
        left node = 2 * i + 1
        right node = 2 * i + 2
        every thing after heapSize is already sorted
    */

    def static maxHeap(arr, heapSize, i) {
        int leftNode = i * 2 + 1
        int rightNode = i * 2 + 2
        int largest = i

        if (leftNode < heapSize && arr[leftNode] > arr[largest])
            largest = leftNode

        if (rightNode < heapSize && arr[rightNode] > arr[largest])
            largest = rightNode

        if (largest != i) {
            arr.swap(i, largest)
            maxHeap(arr, heapSize, largest)
        }
    }


    static void main(String[] args) {
        def arr = [2, 3, 4, 6, 8, 5, 1, 7, 9]

        println heapSort(arr)
        //output [1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr = ['f', 'd', 'a', 'c', 'b', 'e']
        println heapSort(arr)
        //output [a, b, c, d, e, f]
    }
}
