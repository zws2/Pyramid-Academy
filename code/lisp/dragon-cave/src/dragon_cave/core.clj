(ns dragon-cave.core)

(defn greeting []
  (println "cave1 or cave2? (1 or 2)"))

(defn cave1 []
  (println "Cave1"))

(defn cave2 []
  (println "Cave2"))

(greeting)
(let [input (read-line)]
  (if (= input "1") (cave1)
                      (if (= input "2") (cave2))))