(ns logfetcher.routes
  (:use compojure.core 
        ring.util.response
        clojure.contrib.json)
  (:require [yousee-common.web :as common-web :only load-static-file]
	    [compojure.route :as route]
	    [compojure.handler :as handler]))



(defroutes handler

  (GET ["/:context/ping", :context #".[^/]*"]  []
       {:status 200, :headers {"Content-Type" "text/plain" "expires" "0" "cache-control" "no-cache"} :body "pong" })


  (GET ["/:context/public/:fil" , :context #".[^/]*" :fil #".*\..*"] [fil]
       (common-web/load-static-file fil))

  
    (route/not-found (str "Route not found")))

(def app
     (-> (handler/site handler)))

