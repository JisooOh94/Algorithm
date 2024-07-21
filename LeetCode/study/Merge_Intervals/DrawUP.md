# Requirements
### Parameters
* interval([start, end]) array

### Conditions
* each interval could be overlapped
	1. overlapped : [1, 3], [2, 5]
	2. contains : [1, 6], [2, 5]
* not sorted

### Constraints
* 1 <= intervals.length <= 10^4
* 0 <= start < end <= 10^4

### Targets
* merge overlapped intervals


# Solution
### Solution_1
1. start 값 기준으로 정렬
2. intervals 순회하며 앞 - 뒤 interval 비교 및 merge 수행
	* intervals[i].end > intervals[i+1].start 인경우 overlapped 인상황
	* intervals[i].start, max(intervals[i].end, intervals[i+1].end) 로 merge
* Time Complexity : O(nlogn) --> 정렬에 소요되는 시간복잡도
* 성능을 개선하기 위해선 정렬없이 수행하여 O(n) 으로 수행할 수 있도록 해야함

### Solution_2
* 공간복잡도를 희생하고 시간복잡도를 개선하는 방식
* intervals 의 최대 길이가 10^4 정도로 작은편이다. 충분히 메모리에서 감당가능하다.
* rangeRecord[10^4 + 1] 로 생성, intervals 순회하며 rangeRecord[interval[0]] = interval[1] 로 interval 시작, 종료 지점 기록
* rangeRecord 순회, rangeRecord[i] != null 인 값 만나면 start = i, end = rangeRecord[i] 로 저장
* rangeRecord[i] != null 일때 start, end 가 not null 이라면 start - end 범위와 i - rangeRecord[i] 범위가 overlapped 되는지 확인
    * overlapped 된다면, end 를 max(end, rangeRecord[i]) 로 설정
    * overlapped 되지 않는다면 기존 start, end 를 resultSet 에 저장 후 i, rangeRecord[i] 로 초기화
* Time Complexity : O(n)
* Space Complexity: O(10^4)

### Solution_3
* Solution_2 와 방식은 동일하나, intervals 에서 start 값의 min, max 를 구하여 rangeRecord[max - min] 으로 생성
* rangeRecord 크기가 줄어듦으로서 공간복잡도 개선 및 순회 횟수가 줄어드므로 시간복잡도도 개선
