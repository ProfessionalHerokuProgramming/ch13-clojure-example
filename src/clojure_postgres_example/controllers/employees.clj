(ns clojure-postgres-example.controllers.employees
    (:use [compojure.core :only [defroutes GET POST]])
    (:require [clojure.string :as str]
        [ring.util.response :as ring]
        [clojure-postgres-example.views.employees :as view]
        [clojure-postgres-example.models.employee :as model]
    )
)

(defn index []
    (view/index (model/all))
)

(defroutes routes
    (GET  "/" [] (index))
)