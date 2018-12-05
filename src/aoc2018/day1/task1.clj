(ns aoc2018.day1.task1)

(require 'aoc2018.day1.util)

(defn solve
  []
  (reduce + 0 (aoc2018.day1.util/readInput)))