package searches
/**
 *  Interpolation search is similar to binary search, but unlike binary search that divides the sorted array
 *  in half, in interpolation search the division happen at the position which the element is closer to the search key.
 *
 *  the following is the formula to find the approximate position
 *
 *  pos = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
 *
 *  low = firstIndex
 *  high = lastIndex
 *  key = search value
 *
 *  example:
 *      arr = [1, 2, 4, 5, 8, 13, 23, 27, 32, 39, 44, 51]
 *      searchKey = 4
 *      pos =  0 + ((4 - 1 ) * (11 - 0) / ( 51 - 1)) = 0
 *      low = pos++
 *      pos =  1 + ((4 - 2 ) * (11 - 1) / ( 51 - 2)) = 1
 *      low = pos++
 *      pos =  2 + ((4 - 4 ) * (11 - 2) / ( 51 - 4)) = 2 Found!
 *
 *
 *  Complexity = O(log log n) can take up to O(n)
 *  Space = O(1)
 *
 */
class InterpolationSearch {

    static interpolationSearch(arr, searchValue) {

        def low = 0
        def high = arr.size() - 1
        int pos = 0
        while (pos <= high && pos >= low) {
            pos = low + ((searchValue - arr[low]) * (high - low) / (arr[high] - arr[low]))
            println pos + " = " + "$low + (($searchValue - " + arr[low] + " ) * ($high - $low) / ( " + arr[high] + " - " + arr[low] + "))"

            if (arr[pos] == searchValue)
                return "Found at index: $pos"

            if (arr[pos] < searchValue)
                low = ++pos
            else
                high = --pos
        }

        "Not Found!"
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 5, 8, 13, 23, 27, 32, 39, 44, 51]
        def searchValue = 51
        println interpolationSearch(arr, searchValue)

        arr = (1..2000).step(3)
        println interpolationSearch(arr, searchValue)
    }
}
