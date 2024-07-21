# Requirments
### Parameter
* capaticy
* command array
* key - value / key array

### Conditions
* command : put / get
* get(key)
    * return value / -1 (key not exists)
* put(key, value)
    * add key-value (update if key exists)
    * keys exceed capacity ? evict(LRU entry)
* get / put -> O(1)

### Constraints
* 1 <= capacity <= 3000
* 0 <= command array size <= 200000
* 0 <= key <= 10^4, 0 <= value <= 10^5


# Solution
### Solution 1
* Node(prev, next, key, value), HashMap<Integer, Node> 이용
* put(key, value)
	* capacity 검사 및 evit 수행
	* 새로운 Node 생성 및 HashMap 에 put
	* Node 의 next 를 head 로, head 를 Node 로 update
	* Time Complexity: O(1)
* get(key)
	* HashMap 에서 조회하여 return
	* Time Complexity: O(1)
* evict
	* tail 과 tail.prev 간 연결 삭제 및 tail 을 tail.prev 로 설정
	* tail 의 key 로 HashMap 에서 삭제
	* Time Complexity: O(1)
