package searches
/**
 *  Start from index 0 and compare one by one (!),
 *  Time Complexity = O(n)
 */
class LinearSearch {
    static linearSearch(arr, searchValue) {

        for (def i=0; i< arr.size(); i++)
            if (arr[i] == searchValue)
                return "Found at index: $i"

        "Not Found!"
    }

    static void main(String[] args) {
        def arr = [1, 2, 4, 5, 8, 23, 44, 51, 23, 3, 0]
        def searchValue = 23
        println linearSearch(arr, searchValue)

        arr = (1..2000).step(3)
        println linearSearch(arr, searchValue)
    }
}
