package com.davidhowe.playground.algorithms.search


/**
 * Search algorithm for finding an item from a sorted list of items
 */
class BinarySearch {

    fun provideItemIndex(item: Int, data: List<Int>) : Int {
        return binarySearchLogic(item, data)
    }

    private fun binarySearchLogic(item: Int, data: List<Int>) : Int {
        return if(data.size==1) {
            if(data[0]==item)
                data[0]
            else
                -1
        }
        else {
            when {
                item<data[data.size/2] ->
                    binarySearchLogic(item, data.subList(0, data.size/2))
                item>data[data.size/2] ->
                    binarySearchLogic(item, data.subList(data.size/2 + 1, data.size))
                else ->
                    data[data.size/2]
            }
        }
    }

    companion object {
        val SAMPLE_DATA = listOf(2, 4, 5, 7, 8, 9, 10, 11, 13, 15, 17, 22, 24, 45)
    }



}