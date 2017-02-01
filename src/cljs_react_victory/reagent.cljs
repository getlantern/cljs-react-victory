(ns cljs-react-victory.core
  (:require [cljsjs.victory]
            [camel-snake-kebab.core :as cs :include-macros true]))

(def axis (r/adapt-react-class js/Victory.VictoryAxis))
(def bar (r/adapt-react-class js/Victory.VictoryBar))
(def chart (r/adapt-react-class js/Victory.VictoryChart))
(def group (r/adapt-react-class js/Victory.VictoryGroup))
(def line (r/adapt-react-class js/Victory.VictoryLine))
(def pie (r/adapt-react-class js/Victory.VictoryPie))
(def zoom (r/adapt-react-class js/Victory.VictoryZoom))

(def material-theme js/Victory.VictoryTheme.material)
