(ns clojure-postgres-example.core
    (:use [compojure.core :only [defroutes]])
    (:require [compojure.route :as route]
        [compojure.handler :as handler]
        [ring.adapter.jetty :as ring]
        [clojure-postgres-example.controllers.employees]
        [clojure-postgres-example.views.layout :as layout]
    )
)

(defroutes routes
    clojure-postgres-example.controllers.employees/routes
    (route/resources "/")
    (route/not-found (layout/four-oh-four))
)

(def application (handler/site routes))

(defn start [port]
    (ring/run-jetty #'application {:port (or port 8080) :join? false})
)

(defn -main []
    (let [port (Integer. (System/getenv "PORT"))]
        (start port)
    )
)