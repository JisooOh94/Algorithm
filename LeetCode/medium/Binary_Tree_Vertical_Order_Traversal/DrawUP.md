# Requirements
### Param
* Integer binary tree - root node

### Condition
* vertical order traversal
* left -> right

### Constraints
* 0 <= node cnt <= 100
* -100 <= node.val <= 100

# Solution
### Solution 1
* TreeMap<Integer, List<Intger>
* Time Complexity: O(n)
* Space Complexity : O(n)

### Solution 2
* depth queue, node queue 사용
* BFS 로 탐색하며 verticalOrderedNodes 에 삽입
* 탐색과 동시에 minDepth, maxDepth 기록
* 탐색 완료후, minDepth ~ maxDepth 범위로 for loop 돌며 verticalOrderedNodes 로부터 List 조회해 순차적으로 저장 --> 정렬 대체
* TreeMap 의 정렬 비용(log n) 절약 가능
* Time Complexity : O(n)
