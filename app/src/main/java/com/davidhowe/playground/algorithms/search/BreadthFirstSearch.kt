package com.davidhowe.playground.algorithms.search

import com.davidhowe.playground.algorithms.search.models.Node
import com.davidhowe.playground.algorithms.search.models.Node.Companion.SAMPLE_DATA

/**
 * BFS Implementation:
 * Uses a FIFO queue to implement search.
 * a. Visits node, adds all nodes neighbours to queue. Adds node id to hashmap.
 * b. Removes current node from queue, moves to next node in queue. Repeats a.
 * c. Search complete once no further nodes in queue.
 * d. Note! Check if node id exists in hashmap before queueing
 *
 * Solves problems:
 * 1. Generating a minimum-spanning tree.
 * 2. Finding potential paths between vertices.
 * 3. Finding the shortest path between two vertices.
*/
class BreadthFirstSearch {

    fun findHighestValueToNode(toNodeId: Int) : Int {
        return bfsLogic(true, toNodeId)
    }

    fun findLowestValueToNode(toNodeId: Int) : Int {
        return bfsLogic(false, toNodeId)
    }

    private fun bfsLogic(highestToNode: Boolean, toNodeId: Int) : Int {

        val fifoQueue = mutableListOf<Int>() //FIFO queue of node ids
        val historyMap = hashMapOf<Int, Int>() //(Map<Id, Value>)

        val startNode = SAMPLE_DATA.first { it.root }
        addToQueue(fifoQueue, startNode.id)
        historyMap.put(startNode.id, startNode.value)

        var currentNode: Node

        do {
            currentNode = SAMPLE_DATA.first { it.id == getFromQueue(fifoQueue)}

            println("currentNode id=${currentNode.id}")

            val nodesOfInterest = findNodesOfInterest(currentNode.id, SAMPLE_DATA)

            //Here we perform any logic relevant to the problem at hand
            //PROBLEM SPECIFIC LOGIC START
            nodesOfInterest.forEach { node ->
                //Looking to add node to fifo queue & weight to historyMap
                if(historyMap.containsKey(node.id)) {
                    val newValue = historyMap[currentNode.id]!! + node.value
                    //Looked at node before, only consider adjusting historyMap
                    if(highestToNode) {
                        if (historyMap.get(node.id)!! < newValue)
                            historyMap[node.id] = newValue
                    } else {
                        if (historyMap.get(node.id)!! > newValue)
                            historyMap[node.id] = newValue
                    }
                } else {
                    historyMap[node.id] = historyMap[currentNode.id]!! + node.value
                    addToQueue(fifoQueue, node.id)
                }
            }
            //PROBLEM SPECIFIC LOGIC END

            removeFromQueue(fifoQueue)

        } while(fifoQueue.isNotEmpty())

        return historyMap[toNodeId] ?: 0
    }

    private fun findNodesOfInterest(nodeId: Int, nodes: List<Node>) : List<Node> {
        return nodes.filter { it.connectedIds.contains(nodeId) }
    }

    private fun getFromQueue(list: List<Int>) : Int? {
        return if(list.isNotEmpty())
            list[0]
        else
            null
    }

    private fun addToQueue(list: MutableList<Int>, nodeId: Int) {
        list.add(nodeId)
    }

    private fun removeFromQueue(list: MutableList<Int>) {
        if(list.isNotEmpty())
            list.removeAt(0)
    }
}