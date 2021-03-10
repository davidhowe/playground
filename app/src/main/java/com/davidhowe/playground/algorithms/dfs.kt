package com.davidhowe.playground.algorithms

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
class dfs {
}