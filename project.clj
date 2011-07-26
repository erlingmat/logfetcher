(defproject logfetcher "1.0.0-SNAPSHOT"
  :description "FIXME: Logfetcher fetches data from loggly to be presented in geckoboard"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		 [compojure "0.6.1"]
		 [ring/ring-core "0.3.7" :exclusions [javax.servlet/servlet-api]]
                 [ring/ring-servlet "0.3.7" :exclusions [javax.servlet/servlet-api]]              
                 [ring-json-params "0.1.1"]
                 [clj-json "0.3.1"]
                 [yousee-common "1.0.26"]
                 [ring-common "1.1.1"]
		 [ring/ring-jetty-adapter "0.3.7"]
		 ]
  :dev-dependencies [[ring/ring-jetty-adapter "0.3.7"]
		     [org.mortbay.jetty/jetty-plus "6.1.14"]
		     [org.mortbay.jetty/jetty-naming "6.1.14"]
		     [uk.org.alienscience/leiningen-war "0.0.13"]
		     [ring/ring-devel "0.3.7"]
		     [javax.servlet/servlet-api "2.5"]
		     [com.stuartsierra/lazytest "1.1.2"]
		     [yij/lein-plugins "1.0.2"]            
		     [lein-run "1.0.0"]
		     [oracle/ojdbc "6"] 
		     [org.ccil.cowan.tagsoup/tagsoup "1.2"]]

  
  :aot [logfetcher.servlet]
  :main {:handler logfetcher.servlet/app}
  )