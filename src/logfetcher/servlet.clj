(ns logfetcher.servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:require [compojure.route :as route])
  (:use ring.util.servlet [logfetcher.routes :only [app]]))

(defservice app)