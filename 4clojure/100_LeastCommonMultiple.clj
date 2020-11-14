; 100. Least Common Multiple
;
; Write a function which calculates the least common multiple. Your function
; should accept a variable number of positive integers or ratios.
;
; https://en.wikipedia.org/wiki/Least_common_multiple

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

;; solution

(defn solution-100 [& args]
  (letfn [(gcd [a b]
            (let [[a b] (sort [a b])]
              (loop [x b y a]
                (if (= (rem x y) 0)
                  y
                  (recur y (rem x y))))))]
  (reduce #(/ (* %1 %2) (gcd %1 %2)) args)))

;; tests

(deftest test-100
  (is (== (solution-100 2 3) 6))
  (is (== (solution-100 5 3 7) 105))
  (is (== (solution-100 1/3 2/5) 2))
  (is (== (solution-100 3/4 1/6) 3/2))
  (is (== (solution-100 7 5/7 2 3/5) 210))
)

(run-tests)
