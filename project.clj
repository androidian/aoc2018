(defproject aoc2018 "0.1.0"
  :description "Advent of Code 2018"
  :url "https://github.com/androidian/aoc2018"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot aoc2018.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
