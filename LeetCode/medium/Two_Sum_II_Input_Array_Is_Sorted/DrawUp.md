# Requirements
### Input
* 정수 배열
    * 오름차순으로 정렬되어있음
    * 1부터 인덱싱
* Target number

### Output
* 합했을때 Target number 가 되는 정수배열 요소 2개의 인덱스

### Constraints
* 반드시 하나의 답만 존재
* 배열에서 동일한 요소를 두번 사용하면 안됨
* 공간복잡도는 상수시간으로 제한

* 2 <= 정수 배열 크기 <= 30000
* -1000 <= 배열 내 정수 <= 1000
* -1000 <= Target number <= 1000

# Solution
### Solution 1
* 정수 배열 순회, 선택된 정수를 Target number 에서 차감, 나온 값이 정수배열에 존재하는지 탐색
* 시간복잡도 : O(n^2)
* 공간복잡도 : O(1)

### Solution 2
* Solution 1 과 동일, 하지만 정수배열에 존재하는지 탐색할떄 binary search 이용
* 시간복잡도 : O(nlogn)
* 공간복잡도 : O(n)

### Solution 3
* Map 운영, 정수 배열 순회하며 선택된 정수값을 Target number 에서 차감, 나온값이 Map 에 존재하는지 확인.
* Map 에 존재한다면, 현대 idx 와 Map 에 value 로 저장되어있는 idx return. 존재하지 않는다면 선태된 정수값을 key, 선택된 idx 를 value로 map 에 put
* 시간복잡도 : O(n)
* 공간복잡도 : O(1) (최대 2000)

### Solution 4
* Solution 3 과 동일. 하지만 Map 대신 크기 2000 인 배열로 대신 메모이제이션을 수행한다.
* Hashing 으로 인한 오버헤드 해소, Constraints 에 제시된 숫자배열 내 숫자 범위가 -1000 ~ 1000 으로 크지 않다.
* 시간복잡도 : O(n)
* 공간복잡도 : O(1) (항상 2000)
