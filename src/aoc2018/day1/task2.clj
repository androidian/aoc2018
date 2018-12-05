(ns aoc2018.day1.task2)

(require 'aoc2018.day1.util)

(defn nextIndex
  [list index]
  (if (= (+ 1 index) (count list))
    (identity 0)
    (+ 1 index)))

  (defn findFrequency
    [freqList currentFreqIndex foundFreqs]
    (let [newFreq (+ (get freqList currentFreqIndex) (last foundFreqs))]
      ; (println newFreq)
      (println foundFreqs)
      (if (nil? (some #{newFreq} foundFreqs))
        (recur freqList (nextIndex freqList currentFreqIndex) (conj foundFreqs newFreq))
        (identity newFreq))))

(defn solve
  []
  ; (findFrequency (aoc2018.day1.util/readInput) 0 [0]))
(findFrequency [+7, +7, -2, -7, -4] 0 [0]))