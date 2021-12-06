(ns zer.ubba.bel.clojure_bible_test
  (:require [clojure.test :refer :all]
            [zer.ubba.bel.clojure_bible :refer :all]))

(deftest bible-test

  (def bibleDictionary (readTheBible))

  (testing "The Bible should contain many different words"
           (is (= (.size bibleDictionary) 9582)))

  (testing "God should appear a lot of times"
           (is (= (get bibleDictionary "god") 2303)))

  (testing "Jesus should be there too"
           (is (= (get bibleDictionary "jesus") 777)))

  (testing "There's more love than hate in the bible"
           (def love (get bibleDictionary "love"))
           (def hate (get bibleDictionary "hate"))
           (is (> love hate)))

  (testing "There's more sheep than goats in the bible"
           (def sheep (get bibleDictionary "sheep"))
           (def goats (get bibleDictionary "goats"))
           (is (> sheep goats)))

  (testing "Boring words should be removed"
           (is (= (get bibleDictionary "the") nil))
           (is (= (get bibleDictionary "and") nil))
           (is (= (get bibleDictionary "of") nil)))

  (testing "Oh, and there should be a guy named Zerubbabel"
           (is (= (get bibleDictionary "zerubbabel") 11))))




