# Requirements
### Input
* target number
* number array

### Output
* number array 의 숫자중 target number 와 동일하지 않은 숫자의 개수
* target number 와 동일하지 않은 숫자들을 number array 의 앞부분부터 채움

### Constraints
* 0 <= number array length <= 100
* 0 <= number <= 50
* 0 <= target number <= 100

# Solution
### Solution 1
* number array 순회하며 target number 와 동일하지 않은 숫자들을 또다른 array 에 저장
* 순회완료후 number array 의 앞부분부터 array 의 숫자들로 update
* array 의 length 반환
* Time complexity : O(n)
* Space complexity : O(n)

### Solution 2
* number array 의 앞부분부터 순회하는것이 아닌, 앞과 뒤 모두에서 순회
* Time Complexity : O(n/2)

### Solution 3
* Solution 1 과 동일하게 시작
* target number 와 동일한 숫자의 idx 를 target idx 로 한다.
* number array 순회하며 target number 와 동일하지 않은 숫자 발견시 target idx 와 swap 한다. target idx 는 다음의 값으로 update 한다.
    * swap 한 idx 와 target idx 가 인접해있으면, target idx 는 swap 한 idx 로 설정
    * swap 한 idx 와 target idx 가 떨어져있으면, 기존 target idx + 1 로 설정
* Time complexity : O(n)
* Space Complexity : O(1)
