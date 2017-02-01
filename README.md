# cljs-react-victory

Interop for [Victory](http://formidable.com/open-source/victory)

This library depends on React bindings. Currently only Reagent is supported.

## Usage as library

### Installation

Add `[cljs-react-victory "0.1.0"]` to your dependencies.

### Usage

```clojure
(ns cljs-react-victory-example.core
  (:require [cljs-react-victory.core :as vic]))
```

## Development and experiments

### Setup

Run

    lein figwheel

Open `localhost:3449` with a browser

Clean project specific out:

    lein clean
