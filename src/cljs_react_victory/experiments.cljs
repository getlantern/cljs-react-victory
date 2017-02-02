(ns cljs-react-victory.experiments
  (:require [clojure.browser.repl :as repl]
            [reagent.core :as r]
            [cljs-react-victory.reagent :as v]
            [camel-snake-kebab.core :as cs :include-macros true]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(println "Hello Clojure!")

(def data [{:quarter 1 :earnings 13000}
           {:quarter 2 :earnings 16500}
           {:quarter 3 :earnings 14250}
           {:quarter 4 :earnings 19000}])

(def data2 [{:quarter 1 :earnings 10000}
            {:quarter 2 :earnings 12500}
            {:quarter 3 :earnings 10250}
            {:quarter 4 :earnings 25000}])

(js/console.log data)

(defn test-component []
  [:div {:style {:text-align "center"}}
   [:h2 "Bar components"]
   [:h4 "Bars Simple"]
   [:div {:style {:width "500px" :margin "auto"}}
    ;; Bars Simple
    [v/chart {;; domainPadding will add space to each side of VictoryBar to
              ;; prevent it from overlapping the axis
              :domainPadding 20
              :theme v/material-theme}
     [v/axis {;; tickValues specifies both the number of ticks and where
              ;; they are placed on the axis
              :tickValues ["Quarter 1" "Quarter 2" "Quarter 3" "Quarter 4"]}]
     [v/axis {:dependentAxis true
              ;; tickFormat specifies how ticks should be displayed
              :tickFormat #(str "$ " (/ % 1000) "k")}]
     [v/bar {:data data
             :x :quarter
             :y :earnings}]]
    ;; Multiple Bars
    [:h4 "Bars Multiple"]
    [v/chart {:domainPadding 20
              :theme v/material-theme}
     [v/axis {;; tickValues specifies both the number of ticks and where
              ;; they are placed on the axis
              :tickValues ["Gold" "Silver" "Titanium" "Ore"]}]
     [v/axis {:dependentAxis true
              ;; tickFormat specifies how ticks should be displayed
              :tickFormat #(str "$ " (/ % 1000) "M")}]
     [v/stack {:colorScale "warm"}
      [v/bar {:data data
              :x :quarter
              :y :earnings}]
      [v/bar {:data data2
              :x :quarter
              :y :earnings}]]]]])

(r/render-component [test-component] (js/document.getElementById "app"))
