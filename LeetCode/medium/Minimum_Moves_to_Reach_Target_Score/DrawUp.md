### Overview
* make number from 1 to target
* can infinitely do add 1 opertaion
* only can do max double time mult 2 operations
* get least needed operation times to make 1 to target

### Conditions
* can do increment operation any number of times
* can only do the double operation at most maxDoubles times
* 1 <= target <= 10^9 
* 0 <= maxDoubles <= 100

### Architecture
* brute force
    * start in reverse order, make target to 1
    * do /2 if number%2 == 0 and maxDoubles > 0
    * otherwise, do -1
    * time complexity: ?