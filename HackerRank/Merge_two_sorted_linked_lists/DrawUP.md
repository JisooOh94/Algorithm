# Requirements
### Parameters
* head of 2 sorted linked lsit

### Conditions
* head == null ? sorted list is empty
* 중복값 존재 가능

### Target
* merged sorted linked list's head

### Constraints
* 1 <= list.length <= 1000
* 1 <= list[i] <= 1000

# Solution
### Solution 1
* 각 list head node 끼리 비교, 더 작은 값을 merged list 에 append
* Time Complexity : O(m + n)
* Space Copmplexity : O(m + n)

### Solution 2
* merged list 사용 없이 기존 node 들의 next pointer 만 바꿔서 merged list 생성
* Time Complexity : O(m + n)
* Space Copmplexity : O(1)
