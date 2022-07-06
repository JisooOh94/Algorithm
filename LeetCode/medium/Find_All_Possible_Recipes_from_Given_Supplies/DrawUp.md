# Overview
* Find vertices that all childs reachable

# Conditions
* child lists of each vertices
  * substitute each recipies and ingridients to indexed vertices
  * could be cyclic
  * 1 <= child lists[i] <= vertices.length
* 1 <= vertices <= 100
* ignore lists (supplies)

# Architecture
* DFS + DP
  * (Selectively)substitute each recipies and ingridients to indexed vertices
  * check child vertices rechability recursively
  * memorize visited vertices reachability and reuse
  * handle cyclic case
    * using visited arr or union find
* Bottom-up DFS + minus count
  * make parent list of each vertices
  * add parent's minus count when vertex's minus count == child cnt
* Topological sort(Optimal)