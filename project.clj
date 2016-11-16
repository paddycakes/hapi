(defproject hapi "0.1.0-SNAPSHOT"
  :description "RESTful web application in Clojure/ClojureScript"
  :url "http://hapi.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]
                 [com.layerware/hugsql "0.4.7"]
                 [org.postgresql/postgresql "9.4.1207"]]
  :main hapi.core)
