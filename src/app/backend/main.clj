(ns app.backend.main
  (:gen-class)
  (:require [app.backend.server :as server]))

(defn -main [& _args]
  (server/start-server {:port 8080 :join? true}))
