# Overview
* DAG
* make list of all parents(directed or indirected) for all nodes

# Conditions
* Vertex
  * n nodes (0 indexed)
  * 1 ~ 1000
* Edges
  * uni-directional(DAG)
  * from - to
  * 0 ~ 2000
  * 
* make list of all parents
  * include direct and indirect
  * sort asc order

# Architecture
* Using DP
  * make direct parent vertex list of each vertices
  * start from leaf vertices
  * return (ancestor list + itself) recursively
  * 