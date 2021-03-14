package com.davidhowe.playground

import com.davidhowe.playground.algorithms.search.BinarySearch
import com.davidhowe.playground.algorithms.search.DepthFirstSearch
import org.junit.Test

import org.junit.Assert.*

class BinarySearchUnitTest {

    @Test
    fun findNodeValue() {
        val binarySearch = BinarySearch()
        assertEquals(-1, binarySearch.provideItemIndex(12, BinarySearch.SAMPLE_DATA))
    }
}