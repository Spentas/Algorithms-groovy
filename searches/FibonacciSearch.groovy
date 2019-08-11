package searches
/**
 *  Like binary search find the element in a sorted array.
 *  Three fibonacci number is needed,
 *      1. fibM = The smallest fibonacci number that is greater than or equal to arr.length,
 *      2. fibM1 = First preceding fibonacci number
 *      3. fibM2 = Second preceding fibonacci number
 *
 *      Therefore: fibM = fibM1 + fibM2
 *
 */
class FibonacciSearch {

    def static fibonacciSearch(arr, searchKey) {
        def len = arr.size()-1
        def fibM2 = 0
        def fibM1 = 1
        def fibM = fibM2 + fibM1

        while (fibM < len) {
            fibM2 = fibM1
            fibM1 = fibM
            fibM = fibM2 + fibM1
        }

        def offset = -1

        while (fibM > 1) {
            def i = Math.min(offset + fibM2, len)

            if (arr[i] > searchKey) {
                fibM = fibM2
                fibM1 = fibM1 - fibM2
                fibM2 = fibM - fibM1
            } else if (arr[i] < searchKey) {
                offset = i
                fibM = fibM1
                fibM1 = fibM2
                fibM2 = fibM - fibM1
            } else
                return "Found at index: $i"
        }

        if (fibM1 == 1 && arr[offset + 1] == searchKey)
            return "Found at index:" + offset + 1

        "Not Found!"
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 5, 8, 13, 23, 27, 32, 39, 44, 51]
        def searchKey = 51
        println fibonacciSearch(arr, searchKey)
    }
}
