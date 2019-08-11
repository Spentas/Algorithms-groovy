package searches
/**
 *  Repeatedly divide the sorted array, dismiss the half with values less than the
 *  given search value,
 *  continue until reach to the value or emtpy arr
 *
 *  Time Complexity = O(log n) 🤟
 */
class BinarySearch {

    static binarySearch(arr, leftIndex, rightIndex, searchValue) {

        if (leftIndex <= rightIndex) {

            def mid = leftIndex + (rightIndex - leftIndex).intdiv(2)

            if (arr[mid] == searchValue) {
                return "Found at index: $mid"

            } else if (arr[mid] > searchValue) {
                return binarySearch(arr, leftIndex, mid - 1, searchValue)

            } else if (arr[mid] < searchValue)
                return binarySearch(arr, mid + 1, rightIndex, searchValue)
        }

        "Not Found!"
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 5, 8, 23, 28, 37, 44, 51]
        def searchValue = 100
        println binarySearch(arr, 0, arr.size() - 1, searchValue)

        arr = (1..2000).step(3)
        println binarySearch(arr, 0, arr.size() - 1, searchValue)
    }
}
