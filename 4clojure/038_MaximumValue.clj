; 38. Maximum value
;
; Write a function which takes a variable number of parameters and returns
; the maximum value.

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

;; solution

(defn solution-38 [& c]
  (reduce #(if (> %1 %2) %1 %2) c))

;; tests

(deftest test-38
  (is (= (solution-38 1 8 3 4) 8))
  (is (= (solution-38 30 20) 30))
  (is (= (solution-38 45 67 11) 67)))

(run-tests)
