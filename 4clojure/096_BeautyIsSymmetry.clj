; 96. Beauty is Symmetry
;
; Let us define a binary tree as "symmetric" if the left half of the tree is
; the mirror image of the right half of the tree. Write a predicate to determine
; whether or not a given binary tree is symmetric. (see To Tree, or not to Tree
; for a reminder on the tree representation we're using).

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

;; solution

(defn solution-96? [[_ lt rt]]
  ((fn mirror? [[_, ll, lr :as l] [_, rl, rr :as r]]
    (if (every? nil? [l r])
      true
      (and (= (first l) (first r))
           (mirror? ll rr)
           (mirror? lr rl)))) lt rt))

;; tests

(deftest test-96
  (is (= (solution-96? '(:a (:b nil nil) (:b nil nil))) true))
  (is (= (solution-96? '(:a (:b nil nil) nil)) false))
  (is (= (solution-96? '(:a (:b nil nil) (:c nil nil))) false))
  (is (= (solution-96? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                       [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
      true))
  (is (= (solution-96? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                       [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
      false))
  (is (= (solution-96? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                       [2 [3 nil [4 [6 nil nil] nil]] nil]])
      false))
)

(run-tests)
