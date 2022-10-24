# Overview
* given n vertices, edges
* numbering 1 to n for each vertices
* maximize the sum of adjacent vertices number

# Condition
* n vertices(0 idexed)
  * 2 <= n <= 5 * 10^4
* m bidirectional edge
  * 1 <= m <= 5 * 10^4
  * no self edge
  * no duplicated edge
  * could be acyclic edge
* numbering each vertices from 1 to n 

# Architecture
### Brute force
* find all combination cases of numbering vertices and calculate sum of adjacent vertices number
* pick up maximized sum
* Time complexity : O(n!^E)

### Sort
* big number > maximize usage > numbering biggest number to vertex which has most neighbors
* sort vertices by number of neighbors(edges) and numbering in order
* calculate sum of adjacent vertices number
* Time complexity: O(E + nlogn)

