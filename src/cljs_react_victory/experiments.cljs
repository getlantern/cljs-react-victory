(ns cljs-react-victory.experiments
  (:require [clojure.browser.repl :as repl]
            [reagent.core :as r]
            [cljs-react-victory.core :as v]
            [camel-snake-kebab.core :as cs :include-macros true]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(println "Hello Clojure!")

(defn test-component []
  [:div
   [:h1 "Component rendered!"]])

(r/render-component [test-component] (js/document.getElementById "app"))
