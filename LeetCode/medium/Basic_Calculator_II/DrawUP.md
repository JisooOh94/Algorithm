# Requirements
### parameters
* 수식 문자열

### Conditions
* 중간 연산 결과값의 범위는 -2^31 ~ 2^31 - 1
* 나누기 연산은 몫만 사용(나머지 무시)

### Constraints
* eval 과 같은 문자열 기반 수식 연산 라이브러리 사용 금지
* 1 <= 수식 문자열 <= 3 * 10^5
* 수식 문자열은 정수, 연산자(+, -, *, /) 로 구성. 수식 / 연산자간 공백 문자 n개 포함 가능
* 수식 문자열에 사용되는 정수는 0과 양의 정수만 사용 (0 ~ 2^31 -1)
* 수식 문자열의 결과값은 32 bit integer 밤위내
* 연산자 우선순위 고려 필요

### Target
* 수식 문자열 계산 결과


# Solution
### Solution_1
* number stack 운용. 수식 문자열 순회하며
    * 문자가 숫자일시 : currentNumber 에 accumulate
    * 문자가 연산자일시 : currentNumber 를 stack 에 push
* 연산자 우선순위를 지키기 위해, 연산자가
    * +/- 일시 : stack 에 push
    * *// 일시 : stack 에서 pop 하여 이전 숫자와 currentNumber 를 *// 연산 수행후 다시 stack 에 push
* 수식 문자열 순회 완료시, stack 에 저장된 모든 수 더하여 결과값 출력
* Time Complexity: O(n)
* Space Complexity : O(n) --> stack

### Solution_2
* Solution_1 의 마지막 단계인 stack 을 순회하며 모든 수 더하는 과정을 생략하면 성능 개선 가능
* stack 을 사용한 이유는 수식 문자열 순회중 *// 연산자 처리를 위해 이전 숫자 가져오는 용도로 사용되었다.
* 따라서 이전 숫자를 stack 에 저장하여 불러오는것이 아닌, 따로 lastNumber 변수에 저장하여 사용
* 수식 문자열 순회하며
    * 문자가 숫자일시 : currentNumber 에 accumulate
    * 문자가 연산자일시 : 
        * +// 일시 : lastNumber 를 result 에 더한후 currentNubmer 를 lastNumber 에 저장
        * *// 일시 : lastNumber *(/) currentNubmer 한 결과를 lastNumber 에 저장
* Time Complexity : O(n)
* Space Complexity : O(1)
