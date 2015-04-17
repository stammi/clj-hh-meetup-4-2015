(ns clj-hh-tesla-sample.core
  (:require
    [com.stuartsierra.component :as c]
    [de.otto.tesla.system :as system]
    [de.otto.tesla.zk.zk-observer :as observer]
    [clj-hh-tesla-sample.page :as page])
  (:gen-class))

(defn example-system [runtime-config]
  (-> (system/empty-system (assoc runtime-config :name "foo"))
      (assoc :zk-observer
             (c/using (observer/new-zkobserver) [:config]))
      (assoc :page (c/using (page/new-page) [:routes :zk-observer :app-status]))
      (c/system-using {:server [:page]})))

(defn -main
  "starts up the production system."
  [& args]
  (system/start-system (example-system {})))

