(defproject enrich-test "0.1.0-SNAPSHOT"
  :description "Demonstrate a problem with enrich-classpath"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [lispyclouds/clj-docker-client "1.0.3"]]
  ;; Without the managed dependency, everything works.
  :managed-dependencies [[com.kohlschutter.junixsocket/junixsocket-core "2.3.4"]]
  :repl-options {:init-ns enrich-test.core}
  :profiles {:repl {:middleware [cider.enrich-classpath/middleware]
                    :plugins    [[mx.cider/enrich-classpath "1.7.0"]]
                    ;; Only fails with "sources" or both active.
                    :enrich-classpath {:classifiers #{"sources" #_"javadoc"}}}})
