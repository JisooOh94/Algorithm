# Requirements
### Parameters
* 32-bit integer x

### Target
* reversed integer
* reversed integer exceed 32-bit integer range -> return 0

### Conditions
* does not allow you to store 64-bit integers (signed or unsigned).

### Constraints
* -2^31 <= x <= 2^31 - 1


# Solution
### Solution 1
* 수를 문자열로 변환
* 문자열 reverse 수행
* reversed 된 문자열이 32 bit integer range 내인지 비교
* Time Complexity : O(n)
* Space Complexity : O(1)
