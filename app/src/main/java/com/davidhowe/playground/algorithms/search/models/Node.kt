package com.davidhowe.playground.algorithms.search.models

class Node (
    val id: Int,
    val value : Int,
    val connectedIds: List<Int>,
    val root: Boolean
) {

    companion object {
        val SAMPLE_DATA = listOf<Node>(
                Node(
                        id = 0,
                        value = 0,
                        root = true,
                        connectedIds = listOf(1, 2)
                ),
                Node(
                        id = 1,
                        value = 5,
                        root = false,
                        connectedIds = listOf(0, 3)
                ),
                Node(
                        id = 2,
                        value = 7,
                        root = false,
                        connectedIds = listOf(0, 4, 5)
                ),
                Node(
                        id = 3,
                        value = 9,
                        root = false,
                        connectedIds = listOf(1)
                ),
                Node(
                        id = 4,
                        value = 2,
                        root = false,
                        connectedIds = listOf(2)
                ),
                Node(
                        id = 5,
                        value = 1,
                        root = false,
                        connectedIds = listOf(2, 6)
                ),
                Node(
                        id = 6,
                        value = 9,
                        root = false,
                        connectedIds = listOf(5)
                )
        )
    }
}