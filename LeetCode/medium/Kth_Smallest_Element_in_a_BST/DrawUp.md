# Requirements
### Input
* 이진탐색트리
* 정수 k

### Output
* 이진탐트리 요소중, k 번째로 작은 요소 값

### Constraints
* 1 <= k <= 10000
* 1 <= 이진탐색트리 노드 개수 <= 10000
* 0 <= 이진탐색트리 노드 값 <= 10000


# Solutions
### Solution 1
* 이진탐색트리를 mid traverse?(left child 조회, 이후 자기자신 조회, 이후 right child 조회)
* 자기 자신 노드 조회할때 순번 값 + 1 씩 수행
* 자기 자신 노드 조회할때 순번 값이 k 와 동일할경우 해당 노드의 값 Return
* Time Complexity : O(n), 여기서 n 은 트리 내의 노드 개수
* Space Complexity : O(n)
