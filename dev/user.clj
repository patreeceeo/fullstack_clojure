(ns user
  (:require [app.backend.dev :as dev]
            [clojure.tools.namespace.repl :as repl]))

(repl/set-refresh-dirs "src" "dev" "test")

(comment
  (dev/go)
  (dev/reset)
  (dev/stop))
