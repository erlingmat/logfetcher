(ns jetty
  (:use logfetcher.routes
	ring.adapter.jetty)
  (:require [clojure.contrib.duck-streams :as ds])  
  (:import (org.mortbay.xml XmlConfiguration)
	   (org.mortbay.jetty.webapp WebAppContext)))

(defn init-server [server]
  (try 
    (let [config (XmlConfiguration. (slurp "test/jetty.xml"))]    
      (. config configure server))
    (catch Exception e
      (prn "Unable to load jetty configuration")
      (. e printStackTrace))))


(defn boot []
  (future (run-jetty #'app {:port 8080 :configurator init-server})))

