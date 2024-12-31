# Requirements
### Input
* 정수 배열
* Target Number

### Output
* 합이 Target Number 보다 크거나 같은 최소 부분배열 의 길이
* 그러한 부분배열이 존재하지 않으면 0 return

### Constraints
* 1 <= Target Number <= 1000000000
* 1 <= 정수 배열 크기 <= 100000
* 1 <= 정수 <= 10000


# Solutions
### Solution 1
* frontIdx, rearIdx 운영
* rearIdx 를 1씩 증가시켜가며 frontIdx ~ rearIdx 의 합이 targetNum 보다 크거나 같은지 확인
* 크거나 같다면, 이번엔 frontIdx 를 1씩 증가시켜가며 부분배열의 크기를 줄여도 targetNum 보다 크거나 같은지 확인
* 위 작업을 반복하며 최소 부분배열 길이 저장
* Time Complexity : O(2n)
* Space Complexity : O(1)

### Solution 2
* 정수 배열 순회하며 각 인덱스별 누적값 계산 및 저장
* 다시 정수 배열 순회하며 누적값 배열을 이용해 각 인덱스별로 Target Number 를 맞추기 위한 인덱스를 binary search 로 탐색 및 그 최소 길이 저장
* Time Complexity : O(n logn)
* Space Complexity : O(n)
