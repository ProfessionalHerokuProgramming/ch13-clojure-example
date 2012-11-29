(ns clojure-postgres-example.models.employee
    (:require [clojure.java.jdbc :as sql])
)

(defn all []
    (sql/with-connection (System/getenv "DATABASE_URL")
        (sql/with-query-results results
            ["select * from employees"]
            (into [] results)
        )
    )
)