package com.davidhowe.playground

import com.davidhowe.playground.algorithms.search.DepthFirstSearch
import org.junit.Test

import org.junit.Assert.*

class DFSUnitTest {
    @Test
    fun findNodeValue() {
        val dfs = DepthFirstSearch()
        assertEquals(9, dfs.findNodeValue(6))
    }
}