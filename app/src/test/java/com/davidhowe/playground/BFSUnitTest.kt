package com.davidhowe.playground

import com.davidhowe.playground.algorithms.search.Bfs
import org.junit.Test

import org.junit.Assert.*

class BFSUnitTest {
    @Test
    fun findHighestValueToNode() {
        val bfs = Bfs()
        assertEquals(23, bfs.findHighestValueToNode(6))
    }

    @Test
    fun findLowestValueToNode() {
        val bfs = Bfs()
        assertEquals(17, bfs.findLowestValueToNode(6))
    }
}