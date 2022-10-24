# Overview
* given 1 to n numbers in unordered sequence
* number can be longest prefix number when 1 to n (inclusive) numbers had uploaded
* make class that performs upload and get logest prefix number

# Conditions
* given n numbers (1 indexed)
  * 1 <= n 10^5
  * no overlapped. all distinct
* upload, longest could be called maximum 2 * 10^5 counts in totally.
  * longest will be called at least once.

# Architecture
### Union-Find
* Manage uploaded numbers array which value is biggest uploaded number connected with itself
* When upload called,
  1. upload number will find its connected biggest uploaded number usind find
  2. Assign it to itself and its previous number
  3. Update longest prefix number field using union
* When longest called, just return longest prefix number field