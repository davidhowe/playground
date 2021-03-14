package com.davidhowe.playground.algorithms.search

import com.davidhowe.playground.algorithms.search.models.Node
import com.davidhowe.playground.algorithms.search.models.Node.Companion.SAMPLE_DATA

/**
 * DFS Implementation:
 * Uses a LIFO stack to implement search.
 * a. Visits node, pushes next unvisited node onto stack. Adds node id to hashmap.
 * b. Repeats a. until no further unvisited nodes avail, then pops stack and backtracks to find unvisited nodes.
 * c. Search complete once no further nodes in stack.
 * d. Note! Check if node id exists in hashmap before stacking
 *
 * Solves problems:
 * 1. Topological sorting.
 * 2. Detecting a cycle.
 * 3. Pathfinding, such as in maze puzzles.
 * 4. Finding connected components in a sparse graph.
 */
class DepthFirstSearch {

    fun findNodeValue(toNodeId: Int) : Int {
        return dfsLogic(toNodeId)
    }

    private fun dfsLogic(toNodeId: Int) : Int {

        val visitedNodes = hashMapOf<Int, Int>() //HashMap<NodeId, NodeValue>
        val searchStack = mutableListOf<Node>()

        var currentNode = SAMPLE_DATA.first { it.root }
        pushToStack(currentNode, searchStack)

        var stillRunning = true
        var nodeNeighbours : List<Node>

        do {
            println("currentNode id=${currentNode.id}")

            visitedNodes[currentNode.id] = currentNode.value
            nodeNeighbours = getNodeNeighbours(currentNode, SAMPLE_DATA)

            //Here we perform any logic relevant to the problem at hand
            //PROBLEM SPECIFIC LOGIC START

            //PROBLEM SPECIFIC LOGIC END

            var newNode : Node? = null
            nodeNeighbours.forEach {
                if(!visitedNodes.containsKey(it.id)) {
                    newNode = it
                }
            }

            if(newNode!=null) {
                currentNode = newNode!!
                pushToStack(newNode!!, searchStack)
            }
            else if(searchStack.isNotEmpty()) {
                val poppedNode = popFromStack(searchStack)
                if(poppedNode.id!=currentNode.id)
                    currentNode = poppedNode
                else
                    currentNode = popFromStack(searchStack)
            }
            else
                stillRunning = false
        } while(stillRunning)

        return visitedNodes[toNodeId] ?: 0
    }

    private fun getNodeNeighbours(currentNode: Node, stack: List<Node>) : List<Node> {
        return stack.filter { currentNode.connectedIds.contains(it.id)}
    }

    private fun pushToStack(node: Node, stack: MutableList<Node>) {
        stack.add(0, node)
    }

    private fun popFromStack(stack: MutableList<Node>) : Node {
        return stack.removeAt(0)
    }
}