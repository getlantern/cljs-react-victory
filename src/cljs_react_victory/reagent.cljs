(ns cljs-react-victory.reagent
  (:require [cljsjs.victory]
            [reagent.core :as r]
            [camel-snake-kebab.core :as cs :include-macros true]))

(def area (r/adapt-react-class js/Victory.VictoryArea))
(def axis (r/adapt-react-class js/Victory.VictoryAxis))
(def bar (r/adapt-react-class js/Victory.VictoryBar))
(def candlestick (r/adapt-react-class js/Victory.VictoryCandlestick))
(def chart (r/adapt-react-class js/Victory.VictoryChart))
(def error-bar (r/adapt-react-class js/Victory.VictoryErrorBar))
(def group (r/adapt-react-class js/Victory.VictoryGroup))
(def line (r/adapt-react-class js/Victory.VictoryLine))
(def pie (r/adapt-react-class js/Victory.VictoryPie))
(def scatter (r/adapt-react-class js/Victory.VictoryScatter))
(def stack (r/adapt-react-class js/Victory.VictoryStack))
(def voronoi (r/adapt-react-class js/Victory.VictoryVoronoi))
(def voronoi-tooltip (r/adapt-react-class js/Victory.VictoryVoronoiTooltip))
(def zoom (r/adapt-react-class js/Victory.VictoryZoom))

(def material-theme js/Victory.VictoryTheme.material)
