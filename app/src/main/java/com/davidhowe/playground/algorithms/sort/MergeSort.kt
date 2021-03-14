package com.davidhowe.playground.algorithms.sort


/**
 * MergeSort implementation
 *
 * Worst Case Time complexity: Ο(n log n)
 * Space complexity: O(n)
 *
 * Divide and conquer technique
 *
 * Sub divides input until lists of max size 2 exist
 * For each sub list, sorts list
 * Recursively iterates up, merging sorted left and right lists
 */
class MergeSort {

    fun sortAscending(list: List<Int>) : List<Int> {
        if(list.size<=1)
            return list
        else {
            val leftList = sortAscending(list.subList(0, list.size/2))
            val rightList = sortAscending(list.subList(list.size/2, list.size))
            return mergeListsAscending(leftList, rightList)
        }
    }

    /**
     * Function merges two pre-sorted lists
     */
    private fun mergeListsAscending(list1: List<Int>, list2: List<Int>) : List<Int> {

        if(list1.isEmpty())
            return list2
        else if (list2.isEmpty())
            return list1
        else {

            val resultList = mutableListOf<Int>()
            val finalLength = list1.size + list2.size

            var indexList1 = 0
            var indexList2 = 0

            for (k in 0..finalLength - 1) {
                if(indexList2==list2.size || indexList1<list1.size && (list1[indexList1] < list2[indexList2])) {
                    resultList.add(list1[indexList1])
                    indexList1 += 1
                } else {
                    resultList.add(list2[indexList2])
                    indexList2 += 1
                }
            }

            return resultList
        }
    }

}