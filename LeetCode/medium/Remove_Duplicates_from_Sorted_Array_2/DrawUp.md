# Requirements
### Input
* 숫자 배열
* 중복되는 요소 존재
* 오름차순으로 정렬되어있음

### Output
* 중복되지 않는 요소들이 앞에서부터 채워진 배열
* 중복되지 않는 요소들의 개수
* 여기서 중복되지 않는의 개념은 최대 2개까지만 중복을 허용하는것임
* 추가적인 메모리를 사용하면 안되고 주어진 숫자배열만 사용해야함

### Constraints
* 1 <= 숫자 배열 크기 <= 30000
* -10000 <= 숫자 <= 10000


# Solution
### Solution 1
* 순회 idx, 저장 idx 를 모두 2로 초기화
* 순회하며 2개 이전 idx 의 값과 현재 idx 의 값을 비교. 다르다면 저장 idx 의 값을 현재 idx 의 값으로 update. 저장 idx + 1
* Time Complexity : O(n)
* Space Complexity : O(1)
