; 66. Greatest Common Divisor
;
; Given two integers, write a function which returns the greatest common
; divisor.

;; solution
;; using Euclid's algorithm
;; https://en.wikipedia.org/wiki/Greatest_common_divisor

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

(defn solution-66 [a b]
  (let [[a b] (sort [a b])]
    (loop [x b y a]
      (if (= (rem x y) 0)
        y
        (recur y (rem x y))))))

;; tests

(deftest test-66
  (is (= (solution-66 2 4) 2))
  (is (= (solution-66 10 5) 5))
  (is (= (solution-66 5 7) 1))
  (is (= (solution-66 1023 858) 33)))

(run-tests)
