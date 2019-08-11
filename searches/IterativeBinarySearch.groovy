package searches
/**
 *  Repeatedly divide the sorted array, dismiss the half with values less than the
 *  given search value,
 *  continue until reach to the value or emtpy arr
 *
 *  Time Complexity = O(log n) 🤟
 */
class IterativeBinarySearch {

    static binarySearch(arr, int leftIndex, rightIndex, searchValue) {

        while (leftIndex <= rightIndex) {
            def mid = leftIndex + (rightIndex - leftIndex).intdiv(2)

            if (arr[mid] == searchValue)
                return "Found at index: $mid"

            if (arr[mid] < searchValue)
                leftIndex = mid + 1

            else
                rightIndex = mid - 1
        }

        "Not Found!"
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 5, 8, 23, 28, 37, 44, 51]
        def searchValue = 5
        println binarySearch(arr, 0, arr.size() - 1, searchValue)

        arr = (1..2000).step(3)
        println binarySearch(arr, 0, arr.size() - 1, searchValue)
    }
}
