(ns clj-hh-tesla-sample.page
  (:require
    [com.stuartsierra.component :as c]
    [de.otto.tesla.stateful.routes :as routes]
    [de.otto.status :as status]
    [de.otto.tesla.stateful.app-status :as app-status]
    [de.otto.tesla.zk.zk-observer :as observer]
    [compojure.core :as compojure]
    [hiccup.core :as hic]))

(defn result-page [self]
  (let [data
        (read-string
          (observer/observe! (:zk-observer self) "/liga1/hsv"))]
    (hic/html [:body
               [:h1 "http://www.istderhsvnochinliga1.de/"]
               [:div
                (str "Bruno Labbadia sagt: "
                     (if (< data 1)
                       "Leider nein"
                       (if (> data 15)
                         "Ja. sieht aber nicht so gut aus"
                         "Na klar'")) ".")]])))

(defrecord Page [routes app-status zk-observer]
  c/Lifecycle
  (start [self]
    (routes/register-routes
      routes
      [(compojure/GET "/" [] (result-page self))])
    (app-status/register-status-fun
      app-status
      (fn [] (status/status-detail :example-page :ok "page is always fine")))
    self)
  (stop [self]
    self))

(defn new-page [] (map->Page {}))

