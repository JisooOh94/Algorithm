# Requirements
### Input
* 숫자 배열
* 오름차순으로 정렬되어있음
* 중복되는 요소 존재

### Output
* 중복이 제거된 배열 크기
* 앞에서부터 중복이 제거된 요소로만 오름차순으로 정렬되어 채워진 배열

### Constraints
* 1 <= 숫자 배열 크기 <= 30000
* -100 <= 숫자 <= 100


# Solution
### Solution 1
* Set 을 이용해 중복 체크
* 숫자배열을 순회하며 Set 에 존재하지 않는 요소들만 결과 배열에 저장
* 순회 종료후 결과배열 값을 숫자배열의 앞에서부터 저장
* 결과 배열 크기 반환
* Time Complexity : O(n)
* Space Complexity : O(n)

### Solution 2
* Set 을 이용한 중복 체크를 하지 않고 크기 30000 인 배열로 중복 체크 수행
* 해싱으로 인한 오버헤드를 줄일 수 있어 시간복잡도 측면에서 이득이 있음
* 공간복잡도 손해
* Time Complexity : O(n)
* Space Complexity : O(n)

### Solution 3
* 오름차순으로 정렬되어있다는 말은, 중복된 요소들이 인접해 있다는 의미
* 순회하는 idx 와 저장하는 idx 를 별도로 운영
* 순회하며 중복되지 않는 요소발견시 해당 값을 저장하는 idx 의 값과 swap. 저장 idx + 1
* Time Complexity : O(n)
* Space COmplexity : O(n)

### Solution 4
* 공간복잡도를 상수시간으로 개선하려면 중복 체크도 set 이 아닌 다른 방식 사용 필요
* 오름차순으로 정렬되어있다는 말은, 중복된 요소들이 인접해 있다는 의미
* 즉, 순회하면서 이전값과 현재값이 동일하다면 이는 중복되는 요소, 동일하지 않다면 이는 중복되지 않는 요소
* 이전값 저장 변수를 사용. 순회하며 이전값과 현재값이 동일하지 않다면 swap수행, 이전값 변수에 현재값 저장
* Time Complexity : O(n)
* Space Complexity : O(1)
