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

(def data-error [{:x 15 :y 35000 :error 0.2}
                 {:x 20 :y 42000 :error 0.05}
                 {:x 30 :y 55000 :error 0.1}])


(js/console.log data)

(defn bars-component []
  [:div
   [:h2 "Bar components"]
   [:h4 "Bars Simple"]
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
             :y :earnings}]]]])

(defn error-bars-component []
  [:div
   [:h2 "Error Bars"]
   [:h4 {:style {:color "#f00"}} "Error Bars Simple (doesn't work)"]
   ;; Error bars
   [v/chart
    [v/error-bar {:data data-error
                  :errorX #(* (:error %) (:x %))
                  :errorY #(* (:error %) (:y %))}]]])

(defn scatter-component []
  (let [generate-data (fn []
                        (take 20 (repeatedly (fn [] {:x (rand-int 10)
                                                     :y (rand-int 20)
                                                     :size (rand-int 20)}))))
        scatter-data (r/atom (generate-data))
]
    (js/setTimeout #(reset! scatter-data (generate-data)) 4000)
    (fn []
      [:div
       [:h2 "Scatter Data"]
       [:h4 "Scatter Data (ANIMATED)"]
       [v/chart {:theme v/material-theme
                 :animate {:duration 1000
                           :easing "circleOut"}}
        [v/scatter {:data @scatter-data}]]])))

(defn main-component []
  [:div {:style {:text-align "center"}}
   [:div {:style {:width "500px" :margin "auto"}}
    (bars-component)
    (error-bars-component)
    ((scatter-component))]])

(r/render-component [main-component] (js/document.getElementById "app"))
