# Requirments
### Parameters
* integer array

### Target
* interger array 내 양의정수, 음의정수, 0 의 비율

### Condition
* 10^-4 까지의 오차 허용?

### Constraints
* 0 < integer array size <= 100
* -100 <= number in array <= 100
* 소수점 아래 6자리까지 출력(값이 없을시, 0 으로 채워서 출력)

# Solution
### Solution 1
* array 순회하며, 양의 정수, 음의정수, 0 개수 counting
* 양의 정수 개수(float 으로 casting) / array size ... 출력

### Solution 2
* counting 한 개수 변수 * 10^6 수행
* 수행한 결과값을 array size 로 divide
* divide 한 결과값을 다시 10^6 으로 나누어 출력
* Time Complexity : O(n)
* Space Complexity : O(1)
