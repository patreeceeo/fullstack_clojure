(ns app.frontend.app)

(defn root-html []
  (str "<main>"
       "<h1>Clojure + ClojureScript</h1>"
       "<p>Minimal full-stack scaffold with backend and frontend hot reload.</p>"
       "</main>"))

(defn mount! []
  (set! (.-innerHTML (.getElementById js/document "app"))
        (root-html)))

(defn init []
  (mount!))

(defn ^:dev/after-load reload []
  (mount!))
