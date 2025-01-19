# Requirements
### Input
* 이진트리

### Output
* 이진트리를 오른쪽에서 바라봤을때 보이는 요소들 배열

### Constraints
* 0 <= 트리내 노드 개수 <= 100
* -100 <= 노드 value <= 100


# Solutions
### Solution 1
* BFS 로 트리 순회
* 순회하며, 각 레이어의 가장 마지막 값을 결과 리스트에 저장
* Time complexity : O(n)
* Space Complexity : O(h)

### Solution 2
* DFS 로 트리 순회
* 순회하며 결과 리스트의 layer 에 해당하는 idx 의 값을 노드 값으로 update --> 결국 가장 마지막에 조회한 노드 값으로 최종 update 되게 될듯
* Time Complexity : O(n)
* Space Complexity : O(h)
