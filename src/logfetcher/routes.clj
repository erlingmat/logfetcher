(ns logfetcher.routes
  (:use compojure.core 
        ring.util.response
        clojure.contrib.json
	logfetcher.core)
  (:require [yousee-common.web :as common-web :only load-static-file]
	    [compojure.route :as route]
	    [compojure.handler :as handler]))

;(def afsaetningurl "http://thenge.loggly.com/api/facets/date/?q=json.app:afsaetning%20-json.request.path:alive&from=NOW-7DAYS&until=NOW")
(def afsaetningurl "http://localhost:41001/docs/afsaetning.json")

(defroutes handler

  (GET ["/:context/ping", :context #".[^/]*"]  []
       {:status 200, :headers {"Content-Type" "text/plain" "expires" "0" "cache-control" "no-cache"} :body "pong" })

  (GET ["/:context/afsaetning", :context #".[^/]*"] []
       (prn (:data (read-json (fetch-url afsaetningurl)))))
  
  (GET ["/:context/public/:fil" , :context #".[^/]*" :fil #".*\..*"] [fil]
       (common-web/load-static-file fil))

  
    (route/not-found (str "Route not found")))

(def app
     (-> (handler/site handler)))

