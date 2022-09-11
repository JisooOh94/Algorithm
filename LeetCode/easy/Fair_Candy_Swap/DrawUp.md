# Overview
* Player A, B has several candy box individually
* Swap one box each other to make sum of cadies same

# Conditions
* 1 <= box counts <= 10^4
* 1 <= candy counts of each box <= 10^5
* at least one valid answer
* could be many answers, select any of them

# Architecture
* Brute Force
  1. get Gap of two player's candy sum / 2
  2. Traverse smaller sum player's candy lists
  3. Check bigger sum player's candy list contains any of smaller sum player's candy + (Gap of two player's candy sum / 2)
  * Time Complexity : O(n)