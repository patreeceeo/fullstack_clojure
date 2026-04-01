(ns app.backend.main
  (:gen-class)
  (:require [app.backend.server :as server]))

(defn env-port []
  (when-some [port-value (System/getenv "PORT")]
    (or (parse-long port-value)
        (throw (ex-info "Invalid PORT value"
                        {:port-value port-value})))))

(defn -main [& _args]
  (server/start-server {:port (or (env-port) 8080)
                        :join? true}))
