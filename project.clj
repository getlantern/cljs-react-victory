(defproject cljs-react-victory "0.1.0-SNAPSHOT"
  :description "Iterop library for Victory graphing library"
  :url "https://github.com/getlantern/cljs-react-victory"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.456"]
                 [cljsjs/victory "0.13.7-2"]
                 [camel-snake-kebab "0.4.0"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]
            [lein-figwheel "0.5.9"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target"
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/"]
                :figwheel true
                :compiler {:main "cljs-react-victory.experiments"
                           :asset-path "js/out"
                           :output-to "resources/public/js/cljs_react_victory.js"
                           :output-dir "resources/public/js/out" }}]})
