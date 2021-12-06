(ns zer.ubba.bel.clojure_bible
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str])
  (:gen-class))

(def data-file (io/resource "bible.txt"))

(def boringWords
  (str/split "the,and,of,to,that,for,in,i,his,a,with,it,be,is,not,they,thou" #","))

(defn readTheBible []
  (def text (slurp data-file))
  (def lines (str/split text, #"\n"))
  (def words (mapcat #(str/split % #" ") lines))
  (def noempty (filter #(re-matches #"^\w+" %) words))
  (def lower (map #(str/lower-case %) noempty))
  (defn isboring [word] (some? (some #(= word %) boringWords)))
  (def noboring (remove #(isboring %) lower))
  (frequencies noboring))

