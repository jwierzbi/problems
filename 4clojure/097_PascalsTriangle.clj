; 97. Pascal's Triangle
;
; Pascal's triangle is a triangle of numbers computed using the following rules:
;
; - The first row is 1.
; - Each successive row is computed by adding together adjacent numbers in the
;   row above, and adding a 1 to the beginning and end of the row.
;
; Write a function which returns the nth row of Pascal's Triangle. 
;
; https://en.wikipedia.org/wiki/Pascal%27s_triangle

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

;; solution

(defn solution-97 [n]
  (if (= n 1)
    [1]
    (loop [in 2 out [1 1]]
      (if
        (= in n) out
        (recur
          (inc in)
          (concat [1] (map #(apply + %) (partition 2 1 out)) [1]))))))

;; tests

(deftest test-97
  (is (= (solution-97 1) [1]))
  (is (= (map solution-97 (range 1 6))
         [     [1]
              [1 1]
             [1 2 1]
            [1 3 3 1]
           [1 4 6 4 1]]))
  (is (= (solution-97 11) 
         [1 10 45 120 210 252 210 120 45 10 1])))

(run-tests)
