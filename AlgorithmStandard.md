# ***Algorithm Standart***

* 일반적인 경우에 for-loop 중첩이 recursion 보다 속도 측면에서 더 효율적이다.
* Recursion 을 사용한다면 최대한 back-tracking 을 적용하여 불필요한 객체 생성을 최소화한다.
* 입력샘플이 null 이거나 비어있거나, valid 하지 않은경우의 가지치기는 항상 수행해준다.
* 최대한 가능한 모든 가지치기를 수행하여 loop 횟수를 최소하해준다. 
* 효율적인 알고리즘 솔루션을 생각해내는것보다 브루트포스 + 자잘한 가지치기를 수행해주는것이 성능 및 소요시간 측면에서 더 효율적일 수 있다.
* 넘치는 배열 객체 생성후 Direct Access 하는것보다 딱 맞는 LinkedList 생성 후 Sequentail access 하는것이 더 효율적이다.
* 우선순위 큐에서 큐 내의 요소 수가 적을수록 offer 속도가 빨라진다.(불필요한 요소는 삭제 - K Closest Points to Origin)