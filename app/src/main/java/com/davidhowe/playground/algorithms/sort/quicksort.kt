package com.davidhowe.playground.algorithms.sort

/**
 * QuickSort implementation
 *
 * Worst Case Time complexity O(n^2)
 * Space complexity: O(n)
 *
 * Divide and conquer technique
 *
 * Choose random pivot point. Usually start with left most value
 * From index left of sort array, move right until value > pivot
 * From index right of sort array, move left until value < pivot
 * Exchange these values.
 * When right index crosses left index, this is final position of pivot in array
 * Iteratively sort left and right of this pivot point
 */
class QuickSort {

    fun sortAscending(data : MutableList<Int>) : List<Int> {
        if(data.size<=1)
            return data
        else {
            val pivotIndex = 0 //Just always choose furthest item left
            var leftIndex = 1
            var rightIndex = data.size - 1
            while(true) {
                while (data[leftIndex] < data[pivotIndex] && leftIndex < data.size - 1) {
                    leftIndex += 1
                    if (leftIndex > rightIndex)
                        break
                }

                while (data[rightIndex] > data[pivotIndex] && rightIndex > 0) {
                    rightIndex -= 1
                    if (rightIndex < leftIndex)
                        break
                }

                if (leftIndex < rightIndex) {
                    //swap elements
                    val tmp = data[leftIndex]
                    data[leftIndex] = data[rightIndex]
                    data[rightIndex] = tmp
                } else {
                    val pivotValue = data[pivotIndex]
                    data.removeAt(pivotIndex)
                    data.add(rightIndex, pivotValue)
                    return sortAscending(data.subList(0, rightIndex)) + listOf(pivotValue) + sortAscending(data.subList(rightIndex+1, data.size))
                }
            }
        }
    }
}