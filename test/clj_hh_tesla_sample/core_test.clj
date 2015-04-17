(ns clj-hh-tesla-sample.core-test
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as c]
            [clj-hh-tesla-sample.core :as core]))

(deftest a-test
  (testing "the server is running."

    (let [system (core/example-system {})]
      (is (not (nil? (:page system))))

      (let [started (c/start-system (dissoc system :server))]
        (is (not (nil? (:routes (:page started)))))))))
