# Requirements
### Parameters
* 문자열

### Target
* longest substring without repeating characters
	* without repeating characters --> ~동일한 문자의 연속이 없는것인지?~ / 연속성과는 관련없이 중복문자가 존재하면 안되는것인지?

### Constraints
* 0 <= s.length <= 5 * 10^4
*  English letters, digits, symbols and spaces.

# Solution
### Solution_1
* 문자열 순회하며, 문자마다 index 를 map 에 저장, 현재 index 를 substring endIdx 로 저장
* 문자가 이미 map 에 존재할경우, value 값인 index + 1 을 다시 substring startIdx 로 설정후 map update
* Time Complexity : O(n)
* Space Complexity : O(n)

### Solution_2
* map 대신 array 사용, 문자를 array의 특정 index 로 사상시키는 맵핑 함수 활용
* 문자 수만큼 hashing 수행으로 인한 오버헤드를 해소
