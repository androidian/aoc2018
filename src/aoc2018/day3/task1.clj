(ns aoc2018.day3.task1)

(require '[clojure.string :as str])

(defn mapCoords
  [map x y]
  (let [key (str/join "," [(str x) (str y)])
        currentVal (get map key)]
       (cond
         (nil? currentVal) (assoc map key 1)
         (= currentVal 1) (assoc map key 2)
         :else map)))

(defn mapRow
  [map x y w]
  (let [start (+ x 1)
        end (+ x w)]
       (loop [i start
              max end
              result map]
             (if (< i max)
               (recur (inc i) max (mapCoords result i y))
               (mapCoords result i y)))))

(defn mapSquare
  [map x y w h]
  (let [start (+ y 1)
        end (+ y h)]
    (loop [i start
           max end
           result map]
      (if (< i max)
        (recur (inc i) max (mapRow result x i w))
        (mapRow result x i w)))))

(defn parseSquare
  [str]
  (let [tokens (str/split str #" ")
        id (read-string (subs (get tokens 0) 1))
        cords (get (str/split (get tokens 2) #":") 0)
        dims (get tokens 3)
        x (read-string (get (str/split cords #",") 0))
        y (read-string (get (str/split cords #",") 1))
        w (read-string (get (str/split dims #"x") 0))
        h (read-string (get (str/split dims #"x") 1))]
       {"id" id
        "x" x
        "y" y
        "w" w
        "h" h}))

(defn readInput
  []
  (into [] (map parseSquare (str/split (slurp "src/aoc2018/day3/input.txt") #"\n"))))

(defn mapSquares
  [squares]
  (loop [i 0
         end (count squares)
         result {}]
    (if (< i end)
      (let [square (get squares i)
            x (get square "x")
            y (get square "y")
            w (get square "w")
            h (get square "h")]
        (recur (inc i) end (mapSquare result x y w h)))
      result)))

(defn solve
  []
  (count (filter #(>= (second %) 2) (mapSquares (readInput)))))
