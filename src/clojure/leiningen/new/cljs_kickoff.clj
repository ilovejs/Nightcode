(ns leiningen.new.cljs-kickoff
  (:require [leiningen.new.templates :as t]))

(defn cljs-kickoff
  [name package-name]
  (let [render (t/renderer "cljs-kickoff")
        main-ns (t/multi-segment (t/sanitize-ns name))
        data {:name name
              :sanitized (t/name-to-path name)}]
    (t/->files data
               ["project.clj" (render "project.clj" data)]
               ["README.md" (render "README.md" data)]
               ["src/clj/{{sanitized}}/server.clj" (render "server.clj" data)]
               ["src/cljs/{{sanitized}}/client.cljs" (render "client.cljs" data)]
               ["resources/public/css/page.css" (render "page.css" data)]
               ["resources/public/help.html" (render "help.html" data)])))
