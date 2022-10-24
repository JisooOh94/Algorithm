# Overview
* given edges, number of nodes
* find existence of path from source to target (true / false)

# Conditions
* edges[i] = [ui, vi]
    * bi-directional edge
    * ui > vi, vi > ui
* n nodes(0 indexed)
  * min : 1, max : 2 * 10^5
  * return false immediately when n == 1 (no edge to self)
* node has at least one edge
    * 0 < edges.size
* no edge to self
* posiibility of cycle
  * need visited check

# Architecture
* using BFS
* boolean array for visitation check
* root : source, return true when reacehd target / false when all reachable nodes visited
* expected time complexity : O(logn)
\