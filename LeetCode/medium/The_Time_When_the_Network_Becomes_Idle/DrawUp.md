# Overview
* Vertex & Edges & StandBy Time
* Find the earliest idle time case

# Conditions
* n vertices(0 indexed)
  * all connected(directional or indirectional)
  * index 0 vertex is master, rest verticies are slave
  * 2 <= 100000
* edges
  * bi-directional
  * no - self edges
  * Cyclic
* costs
  * pass through edge costs 1 sec
  * master processing time costs 0 sec
* stand-by sec
  * slave wait reply for stand-by sec
  * after stand-by sec, send again
  * stop resending when reply arrived

# Architecture
* find min path from each sleves to master
  * usign Dijkstra or BFS >> no edge weight,so using BFS
* get last resend message time of each slaves
  * ((minPath * 2) / standBySec) * standBySec
* get last resend mseeage arrived time of each slaves
  * (last resend message time) + minPath
* get max last resend message arrived time of vertices.