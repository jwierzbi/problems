; 90. Cartesian Product
;
; Write a function which calculates the Cartesian product of two sets.

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

;; solution

(defn solution-90 [s1 s2]
  (set (for [x s1 y s2] [x y])))

;; tests

(deftest test-90
  (is (= (solution-90 #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
         #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
           ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
           ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
  (is (= (solution-90 #{1 2 3} #{4 5}) #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
  (is (= 300 (count (solution-90 (into #{} (range 10))
                                 (into #{} (range 30)))))))

(run-tests)
