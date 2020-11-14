; 95. To Tree, or not to Tree
;
; Write a predicate which checks whether or not a given sequence represents
; a binary tree. Each node in the tree must have a value, a left child,
; and a right child.

(ns jwierzbi.4clojure
  (:require [clojure.test :refer :all]))

;; solution

; (defn solution-95? [tree]
;   (reduce
;     #(and
;       %1
;       (if (coll? %2)
;         (= (count %2) 3)
;         ((some-fn number? nil? keyword?) %2)))
;     true
;     (tree-seq coll? identity tree)))
(defn solution-95? [root]
  (or (nil? root)
      (and (coll? root)
           (= (count root) 3)
           (every? solution-95? (rest root)))))

;; tests

(deftest test-95
  (is (= (solution-95? '(:a (:b nil nil) nil)) true))
  (is (= (solution-95? '(:a (:b nil nil))) false))
  (is (= (solution-95? [1 nil [2 [3 nil nil] [4 nil nil]]]) true))
  (is (= (solution-95? [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false))
  (is (= (solution-95? [1 [2 [3 [4 nil nil] nil] nil] nil]) true))
  (is (= (solution-95? [1 [2 [3 [4 false nil] nil] nil] nil]) false))
  (is (= (solution-95? '(:a nil ())) false)))

(run-tests)
