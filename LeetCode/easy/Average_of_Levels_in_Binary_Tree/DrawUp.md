# Overview
* return binary tree each layer node's average value

# Conditions
* binary tree
* 1 <= total node's count <= 10000
* -2^31 <= Node.val <= 2^31 - 1

# Architecture
* distribute nodes by layer from array
```java
int layer = 0;
int from = 0;
while(true) {
  int to = from + Math.pow(2, layer);
  for(int i = from; i < to; i++) {}
  from = to;
  layer++;
}
```
* 
* Time Complexity : O(n)

