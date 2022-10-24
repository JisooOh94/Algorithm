# Overview
* check graph form exactly one? b-tree
  * exactly one -> probably all connected

# Conditions
* Valid B-Tree
  * each nodes childs <= 2
  * not overlapped childs
  * no cycle
* exactly one B-Tree
* 1 <= n <= 10^4

# Architecture
* brute-force
  * check incoming edge(except root) count is 1.
    * checking cycle, overlapped childs, all connected... clear?
    * failed..
* union-find
  * make group
  * check cycle > group num == child
  * check overlapped childs > already has group
  * check all connected > only one group