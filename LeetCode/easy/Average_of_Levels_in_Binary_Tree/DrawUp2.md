# Requirements
### Input
* binarytree

### Output
* 이진 트리 각 layer 의 평균 값
* 소수점 아래 5째 자리까지 표현

### Constraints
* 1 <= node 개수 <= 10000


# Solutions
### Solution 1
* bfs 로 트리 순회
* 순회하며 각 layer 마다 평균값 계산하여 결과 list 에 저장
* Time Complexity : O(n)
* Space Complexity : O(n)
