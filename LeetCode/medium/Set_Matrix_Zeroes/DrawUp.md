# Requirements
### Inputs
* m * n 2차원 정수 배열

### Outputs
* 0 이 존재하는 전체 row, column 이 모두 0 으로 수정된 배열

### Constraints
* 추가적인 2차원 배열을 assign 하여 수정하면 안되고 주어진 2차원 배열에 직접 수정해야함
* 1 <= 2차원 배열 width, height <= 200
* -2^31 <= 2차원 배열 정수 <= 2^31 - 1

# Solutions
### Solution 1
* 2개의 set 을 운용
* 2차원 배열 순회하며 0 인 곳의 column, row 를 각각의 set 에 저장
* 0 이 아니라면, 해당 위치의 column, row 가 set 에 존재하는지 확인, 존재한다면 0 으로 수정
* Time Complexity : O(n)
* Space Complexity : O(1)

### Solution 2
* Set 대신 주어진 2차원 배열의 첫번째 row, column 을 memoization 으로 활용
* Time Complexity : O(n)
* Space Complexity : O(1)
