package sorts
/*
    Continuously swapping the adjacent elements if they are in wrong order.

    Worst Time Complexity: O(n^2)

    Best Time Complexity: O(n)

    Space Complexity: O(1)
 */

class BubbleSort {

    static bubbleSort(arr) {
        def l = arr.size()
        l.times { it ->
            (l - it - 1).times { j ->
                arr[j] > arr[j + 1] ?
                        arr.swap(j, j + 1) : 0
            }
        }
        arr
    }

    static optimisedBubbleSort(arr) {
        def l = arr.size()
        def swapped = false
        for (int i = 0; i < l; i++) {
            (l - i - 1).times { j ->
                if (arr[j] > arr[j + 1]) {
                    arr.swap(j, j + 1)
                    swapped = true
                }
            }
            if (!swapped)
                break
        }
        arr
    }

    static void main(String[] args) {
        def arr = [2, 3, 5, 1, 6, 4, 7]
        println bubbleSort(arr)
        //output [1, 2, 3, 4, 5, 6, 7]

        arr = [2, 3, 5, 1, 6, 4, 7]
        println optimisedBubbleSort(arr)
        //output [1, 2, 3, 4, 5, 6, 7]

        arr = ['f', 'd', 'a', 'c', 'b', 'e']
        println bubbleSort(arr)
        //output [a, b, c, d, e, f]
    }
}
