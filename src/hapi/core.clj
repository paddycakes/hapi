(ns hapi.core
  (:require [ring.adapter.jetty :as jetty]
            [hugsql.core :as hugsql]))

;; (def db (System/getenv "DATABASE_URL"))
(def db "jdbc:postgres://localhost/hapi")

(hugsql/def-db-fns "hapi/sql/database.sql")

(defn init-db []
  (install-uuid-module db)
  (create-endpoint-table db)
  (create-upload-table db)
  (create-row-table db)
  (create-cell-table db))

(defn reset-db! []
  (init-db)
  (delete-all-cells db)
  (delete-all-rows db)
  (delete-all-uploads db)
  (delete-all-endpoints db))

(defn create-endpoint [db]
  (:id (create-endpoint* db)))

(defn app [req]
  {:headers {}
   :status 200
   :body "Hello, World!"})

(defn -main []
  (init-db)
  (jetty/run-jetty app {:port 8080}))
