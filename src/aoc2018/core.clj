(ns aoc2018.core
  (:gen-class))

(require 'aoc2018.day1.task1)
(require 'aoc2018.day2.task1)
(require 'aoc2018.day3.task1)
(require 'aoc2018.day3.task2)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Day 1 - Task 1:" (aoc2018.day1.task1/solve))
  
  (println "Day 2 - Task 1:" (aoc2018.day2.task1/solve))
  
  (println "Day 3 - Task 1:" (aoc2018.day3.task1/solve))
  (println "Day 3 - Task 2:" (aoc2018.day3.task2/solve)))
