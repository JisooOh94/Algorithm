package medium.Longest_Happy_String;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Answer {
        class Pair {
            char c;
            int count;
            Pair (char c, int count) {
                this.c = c;
                this.count = count;
            }
        }

        char lastChar = 'd';
        char lastToLastChar = 'd';

        private void updateLastChar(char ch) {
            this.lastToLastChar = this.lastChar;
            this.lastChar = ch;
        }

        public String longestDiverseString(int a, int b, int c) {
            StringBuilder res = new StringBuilder();
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){

                @Override
                public int compare(Pair p1, Pair p2) {
                    return -Integer.compare(p1.count, p2.count);
                }

            });

            if (a > 0) {
                pq.offer(new Pair('a', a));
            }
            if (b > 0) {
                pq.offer(new Pair('b', b));
            }
            if (c > 0) {
                pq.offer(new Pair('c', c));
            }


            while (!pq.isEmpty()) {
                Pair p1 = pq.poll();
                if (lastChar == lastToLastChar && lastChar == p1.c) {
                    if (pq.isEmpty()) {
                        return res.toString();
                    }
                    Pair p2 = pq.poll();
                    res.append(p2.c);
                    updateLastChar(p2.c);
                    p2.count--;
                    if (p2.count > 0) {
                        pq.offer(p2);
                    }

                } else {
                    res.append(p1.c);
                    updateLastChar(p1.c);
                    p1.count--;
                }
                if (p1.count > 0) {
                    pq.offer(p1);
                }
            }

            return res.toString();
        }
}
