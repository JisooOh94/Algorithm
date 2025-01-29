# Requirements
### Inputs
* 양의 정수 n, k

### Outputs
* 1 ~ n 사이의 수중 k 개 선택하여 만들 수 있는 모든 조합

### Constratins
* 1 <= n <= 20
* 1 <= k <= n


# Solutions
### Solution 1
* 재귀함수 사용.
* 파라미터로 fromNumber, toNumber, numberCnt
* 리턴값으로 LinkedList
* fromNumber ~ toNumber - numberCnt 까지 순회하며 재귀함수 호출
* 리턴되는 리스트 목록에 숫자 추가
* 시간복잡도 : 매우 안좋을듯..

### Solution 2
* Solution_1 과 컨셉은 동일
* 다만 재귀함수 인자에 List<List<Integer>> resultList, List<Integer> parentNumber List 추가
* 재귀함수에서 fromNumber ~ toNumber - numberCnt 순회하며 list 에 숫자 추가하여 재귀함수 호출, 재귀함수 끝나면 list 에 추가했던 숫자 삭제
* 시간복잡도 : O(C(n, k)), 여기서 C(n, k)는 조합의 수를 나타내는 이항 계수
* 공간복잡도 : O(k), 여기서 k 는 재귀호출 스택의 최대깊이

### Solution 3
* Solution2 와 동일하나 list 구현체만 LinkedList 에서 ArrayList 사용
* ArrayList가 메모리 사용과 접근 속도에서 LinkedList 보다 더 효율적..?
  * ArrayList 생성시, initialCapacity 에 k 값을 넣어 요소 추가시 배열 복사 방지
