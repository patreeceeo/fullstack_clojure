(ns app.backend.dev
  (:require [app.backend.server :as server]
            [clojure.tools.namespace.repl :as repl]))

(defonce server-instance (atom nil))

(defn start []
  (swap! server-instance
         (fn [running]
           (or running
               (server/start-server {:port 8080 :join? false})))))

(defn stop []
  (when-let [running @server-instance]
    (.stop running)
    (reset! server-instance nil))
  :stopped)

(defn go []
  (start)
  :ready)

(defn reset []
  (stop)
  (repl/refresh :after 'app.backend.dev/go))
