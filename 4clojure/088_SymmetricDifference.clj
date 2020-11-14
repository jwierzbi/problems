; 88. Symmetric Difference
;
; Write a function which returns the symmetric difference of two sets.
; The symmetric difference is the set of items belonging to one but not both
; of the two sets.

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]
            [clojure.set :refer [difference]]))

; solution

(defn solution-88 [s1 s2]
  (into (difference s1 s2) (difference s2 s1)))

; tests

(deftest test-88
  (is (= (solution-88 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
  (is (= (solution-88 #{:a :b :c} #{}) #{:a :b :c}))
  (is (= (solution-88 #{} #{4 5 6}) #{4 5 6}))
  (is (= (solution-88 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})))

(run-tests)
