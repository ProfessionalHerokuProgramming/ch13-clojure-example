(ns clojure-postgres-example.views.employees
    (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
    )
    (:require [clojure-postgres-example.views.layout :as layout])
)

(defn list-employees [employees]
    [:table
        [:tr
            [:th "Employee ID"] [:th "Name"] [:th "E-mail Address"]
        ]
        (map
            (fn [employee] 
                [:tr
                    [:td (h (:id employee))]
                    [:td (h (:name employee))]
                    [:td (h (:email employee))]
                ]
            )
        employees)
    ]
)

(defn index [employees]
    (layout/common "clojure-postgres-example"
        (list-employees employees)
    )
)