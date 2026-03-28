(ns app.backend.server-test
  (:require [app.backend.server :as server]
            [clojure.test :refer [deftest is testing]]))

(deftest health-endpoint-shape
  (testing "the health endpoint returns a successful response"
    (let [response (server/health-handler nil)]
      (is (= 200 (:status response)))
      (is (= "{\"status\":\"ok\"}" (:body response))))))
