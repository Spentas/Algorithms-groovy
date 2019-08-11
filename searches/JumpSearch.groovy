package searches
/**
 * Jump elements in array until arr[pos] > searchKey, then jump back and perform linear search.
 *
 * How many elements to jump?
 *      sqrt(arr.length)
 *
 * Time Complexity : O(√n)
 * Auxiliary Space : O(1)
 *
 */
class JumpSearch {

    static jumpSearch(List arr, searchValue) {

        int jump = Math.sqrt(arr.size() - 1)
        def prev = 0

        while (arr[jump] < searchValue && jump < arr.size()) {
            prev = jump
            jump += Math.sqrt(arr.size() - 1)
        }

        for (def i = prev; i <= jump; i++)
            if (arr[i] == searchValue)
                return "Found at index: $i"

        "Not Found!"
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 5, 8, 13, 23, 27, 31, 39, 44, 51]
        def searchValue = 31
        println jumpSearch(arr, searchValue)

        arr = (1..2000).step(3)
        println jumpSearch(arr, searchValue)
    }
}
