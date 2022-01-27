(ns enrich-test.core
  (:require [clj-docker-client.core :as docker]))

(defn list-images []
  (docker/invoke (docker/client {:api-version "v1.30"
                                 :conn {:uri "unix:///var/run/docker.sock"}
                                 :category :images})
                 {:op :ImageList}))
