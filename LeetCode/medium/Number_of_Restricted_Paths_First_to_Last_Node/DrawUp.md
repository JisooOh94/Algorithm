# Overview
* given undirected weighted graph
* get restricted path from 1 to n
  * redstricted path from a to b : path from a to b which also satisfies that nodes conatained in path are distanceToLastNode(i) > distanceToLastNode(i + 1)
  * distanceToLastNode(i) : shorted path from i to n

# Conditions
* undirected edges
* n nodes labeled from 1 to n
* 1 <= n <= 2 * 10^4
* n - 1 <= edges.length <= 4 * 10^4
* no self edge
* at most one edge between any two nodes
* at lesat on path between any two nocdes

# Architecture
* Dijksrtra + (DFS + DP)
  * get all node's distanceToLastNode using dijkstra
  * find path from 1 to n which satisfies distanceToLastNode(i) > distanceToLastNode(i + 1) using BFS
  * Time Complexity : O(ElogE) + O(E + V)