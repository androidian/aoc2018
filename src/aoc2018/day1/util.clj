(ns aoc2018.day1.util)

(require '[clojure.string :as str])

(defn toInt
  [numString]
  (let [sign (subs numString 0 1)
        number (read-string (subs numString 1))]
    (if (= sign "-")
      (- 0 number)
      (+ 0 number))))

(defn readInput
  []
  (into [] (map toInt (str/split (slurp "src/aoc2018/day1/input.txt") #"\n"))))