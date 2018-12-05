(ns aoc2018.day2.task1)

(require '[clojure.string :as str])

(defn hasCount
  [str, val]
  (not (nil? (some #{val} (vals (frequencies str))))))

(defn mapCounts
  [map string]
  (let [doubles (get map "doubles")
        triples (get map "triples")
        hasDouble (hasCount string 2)
        hasTriple (hasCount string 3)]
    (cond 
      (and hasDouble hasTriple) (assoc (assoc map "doubles" (+ doubles 1)) "triples" (+ triples 1))
      (true? hasDouble) (assoc map "doubles" (+ doubles 1))
      (true? hasTriple) (assoc map "triples" (+ triples 1))
      :else map)))

(defn readInput
  []
  (into [] (str/split (slurp "src/aoc2018/day2/input.txt") #"\n")))

(defn solve
  []
  (let [counts (reduce mapCounts {"doubles" 0 "triples" 0} (readInput))]
       (* (get counts "doubles") (get counts "triples"))))

(defn countDiffs
  [str1 str2]
  (loop [i 0
         diff 0]
    (if (< i (count str1))
      (recur (inc i) (if (= (get str1 i) (get str2 i))
                       diff
                       (inc diff)))
      diff)))

; (defn diffByOne
;   [str list]
;   (filter #(= 1 (countDiffs str %1)) list))

; (defn reducer
;   [str1 str2]
;   (let [common]))

; (defn solve2
;   []
;   (let [ids (readInput)]
;        (diffByOne "ovfqlbicqeyujztrswxmckgncp" ids)))