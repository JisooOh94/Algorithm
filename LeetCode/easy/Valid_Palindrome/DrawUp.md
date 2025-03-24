# Requirements
### Input
* 문자열
    * 숫자
    * 문자
    * 그외

### Output
* 다음의 작업들을 수행한 후 문자열이 팰린드롬인지 여부
    * 숫자, 알파벳을 제외한 문자 삭제
    * 대문자 알파벳을 소문자로 변환

### Constraints
* 1 <= 문자열 길이 <= 200000


# Solutions
### Solution 1
* 문자열 순회하며 숫자, 알파벳만 deque 에 enqueue
* deque 에서 pollFisrt, pollLast 하여 (소문자로 치환후)앞뒤값 비교.
* 앞뒤값이 동일하면 위 작업 반복. deque 가 empty 또는 크기가 1 이 되면 true return, 그외엔 false return
* Time Complexity : O(2n)
* Space Complexity : O(n)

### Solution 2
* frontIdx, rearIdx 운영
* 앞에서부터 frontIdx 로 순회하며 첫번쨰 alphanumeric 인 문자 탐색, 탐색 성공시 이번엔 rearIdx 로 뒤에서부터 순회하며 마찬가지로 첫번쨰 alphanumeric 탐색
* 두 값이 동일한지 확인. 동일하다면 다시 위의 작업 반복. frontIdx >= rearIdx 가 되면 true return, 그외엔 false return
* Time Complexity : O(1n)
* Space Complexity : O(1)
