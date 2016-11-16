(ns hapi.core
  (:require [ring.adapter.jetty :as jetty]
            [hugsql.core :as hugsql]))

;; (def db (System/getenv "DATABASE_URL"))
(def db "jdbc:postgres://localhost/hapi")

(hugsql/def-db-fns "hapi/sql/database.sql")

(defn create-endpoint [db]
  (:id (create-endpoint* db)))

(defn app [req]
  {:headers {}
   :status 200
   :body "Hello, World!"})

(defn -main []
  (jetty/run-jetty app {:port 8080}))
