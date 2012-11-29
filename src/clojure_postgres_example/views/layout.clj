(ns clojure-postgres-example.views.layout
    (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype include-css]]
    )
)

(defn common [title & body]
    (html
        (doctype :html5)
        [:head [:meta {:charset "utf-8"}]]
        [:body
            [:div {:id "header"}
                [:h1 {:class "container"} "Employee List"]
            ]
            [:div {:id "content" :class "container"} body]
        ]
    )
)

(defn four-oh-four []
    (common "Page Not Found"
        [:div {:id "four-oh-four"} "The page you requested could not be found"]
    )
)