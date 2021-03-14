package com.davidhowe.playground

import com.davidhowe.playground.algorithms.sort.QuickSort
import org.junit.Test

import org.junit.Assert.*

class QuickSortUnitTest {
    @Test
    fun sortAscending1() {
        val quicksort = QuickSort()
        val input = listOf(5, 2, 6, 11, 4, 7, 3, 8)
        assertEquals(listOf(2, 3, 4, 5, 6, 7, 8, 11), quicksort.sortAscending(input.toMutableList()))
    }

    @Test
    fun sortAscending2() {
        val quicksort = QuickSort()
        val input = listOf(2, 4, 7, 3, 6, 9, 5, 1, 0)
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6, 7, 9), quicksort.sortAscending(input.toMutableList()))
    }



}