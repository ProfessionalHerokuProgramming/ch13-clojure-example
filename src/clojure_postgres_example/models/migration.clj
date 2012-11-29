(ns clojure-postgres-example.models.migration
    (:require [clojure.java.jdbc :as sql])
)

(defn create-employees []
    (sql/with-connection (System/getenv "DATABASE_URL")
        (sql/create-table :employees
            [:id :integer "NOT NULL" "CONSTRAINT firstkey" "PRIMARY KEY"]
            [:name "varchar(100)"]
            [:email "varchar(255)"]
        )
    )
)

(defn add-employee-test-data []
    (sql/with-connection (System/getenv "DATABASE_URL")
        (sql/insert-values :employees [:id :name :email] 
            [6440 "Chip Arnaldo" "farnaldo@vandelayenterprises.com"]
            [9567 "Ed Cassola" "ecassola@vandelayenterprises.com"]
            [6603 "Angela Gil" "agil@vandelayenterprises.com"]
        )
    )
)

(defn -main []
    (print "Migrating Employee database...") (flush)
    (create-employees)
    (add-employee-test-data)
    (println " done")
)