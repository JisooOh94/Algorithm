# Requirements
### Input
* 오름차순으로 정렬된 두 정수 배열, 각 정수 배열의 길이

### Output
* 두 정수배열이 합쳐진 하나의 오름차순으로 정렬된 배열

### Constraints
* 결과값은 첫번째 배열에 저장되어 반환
    * 이를 위해, 첫번째 배열의 전체 길이는 두번째 배열 길이까지 합친 길이. 앞에서부터 m 번째까지만 값이 채워져있고 이후 n개는 모두 0 으로 설정되어있음
* m, n 은 0 이 될 수 있음


# Solution
### Solution1
* 두 배열을 함께 순회하며 두배열의 값중 더 작은 값을 결과 배열에 저장
* 결과 배열의 값을 첫번째 배열에 복사
* Time complexity : O(m+n)
* Space complexity : O(m+n)

### Solution2
* 첫번째 배열에 두번쨰 배열 요소들을 저장
* 첫번째 배열에 대해 Collections.sort 수행(Timsort)
* Time Complexity : O((m+n)log(m+n))
* Space Complexity : O(m+n)

### Solution3
* 첫번째 배열에서 유효한 값범위만을 복사한 배열 생성
* 복사한 배열과 두번쨰 배열 순회하며 정렬한값 첫번째 배열에 저장
* Time Complexity : O(m+n)
* Space Complexity : O(m)

### Solution4
* 첫번째, 두번째 배열의 마지막부터 역으로 순회하며 더 큰값을 첫번째 배열의 마지막 부터 채워넣음
* Time Complexity : O(m+n)
* Space Complexity : O(1)
