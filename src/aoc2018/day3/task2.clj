(ns aoc2018.day3.task2)

(require 'aoc2018.day3.task1)
(require '[clojure.string :as str])

(defn doesCordOverlap?
  [map x y]
  (let [key (str/join "," [(str x) (str y)])
        val (get map key)]
    (= val 2)))

(defn doesRowOverlap?
  [map x y w]
  (let [start (+ x 1)
        end (+ x w)]
    (loop [i start
           max end
           result false]
      (if (and (<= i max) (false? result))
        (recur (inc i) max (doesCordOverlap? map i y))
        result))))

(defn doesSquareOverlap?
  [map x y w h]
  (let [start (+ y 1)
        end (+ y h)]
    (loop [i start
           max end
           result false]
      (if (and (<= i max) (false? result))
        (recur (inc i) max (doesRowOverlap? map x i w))
        result))))

(defn findSquare
  [map squares]
  (reduce
   (fn [foundId square]
     (let [id (get square "id")
           x (get square "x")
           y (get square "y")
           w (get square "w")
           h (get square "h")]
       (if (doesSquareOverlap? map x y w h)
         foundId
         id)))
   0
   squares))

(defn solve
  []
  (let [squares (aoc2018.day3.task1/readInput)
        map (aoc2018.day3.task1/mapSquares squares)]
    (findSquare map squares)))