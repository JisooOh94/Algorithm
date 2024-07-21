# Requirements
### Parameter
* 2d array compose of 1, 0 (1 : land, 0 : water)

### Conditions
* island -> (horizontally, vertically) connected land's group
* get island number

### Constraints
* 1 <= array.rows, array.cols <= 300

# Solution
### Solution 1
* DFS 이용
	1. grid 순회, land(1) 를 만나면, visited 인지 검사
	2. visited 가 아니라면 landCnt 를 1 증가 및 해당 land 를 visited 에서 true 로 설정후 connected land 탐색 시작
	3. land 로부터 사방의 인접 노드를 검사, land 가 있다면 visited 를 true 로 설정후 그 노드를 기준으로 재귀적으로 다시 인접노드 검사
	4. 마지막 노드를 순회할때까지 3~4 반복
* Time Complexity : O(n)
* Space Complexity : O(n)

### Solution 2
* BFS 이용

### Solution 3
* Union-Find 이용
	1. grid 내 존재하는 land 수 로 islandCnt 초기화
	2. grid 순회, land(1) 를 만나면 0으로 update 후 인접 노드들과 union-find 수행
	3. 인접노드중 lane(1) 가 존재한다면, find 로 서로 같은 parent 에 속해있는지 검사, 서로같은 parent 에 속해있지 않다면 union 후 islandCnt - 1 수행
* Time Complexity : O(n)
* Space Complexity : O(n)
