# Requirements
### Inputs
* 숫자 배열

### Outputs
* 숫자 배열에서 숫자를 선택하여 나올 수 있는 최대 합
* 숫자 하나를 선택했을때, 그 숫자와 인접해있는 앞뒤 수는 선택할 수 없음

### Constraints
* 1 <= 숫자배열 길이 <= 100
* 0 <= 숫자 값 <= 400


# Solutions
### Solution 1
* 재귀함수 활용
* 인자로 startIdx, numberArray 설정
* 반환값으로 해당 startIdx 에서 나올 수 있는 최대 숫자 합
* 재귀함수 내에서 startidx 부터 끝까지 순회하며 숫자 선택 및 선택한 숫자 idx + 2 를 startIdx 로 다시 재귀함수 호출
* Time Complexity :

### Solution 2
* Solution 1 과 컨셉은 동일
* memoization 을 이용해 이미 한번 최대 숫자 합이 나온 idx 에 대해선 재귀 수행하지 않음
