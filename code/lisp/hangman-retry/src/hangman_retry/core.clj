(ns hangman-retry.core)

(defn print-hangman [num-wrong]
  (cond
    (= num-wrong 0) (print "  +--+\n"
                           "    |\n"
                           "    |\n"
                           "    |\n"
                           "____|\n")
    (= num-wrong 1) (println "  +--+\n"
                             " O  |\n"
                             "    |\n"
                             "    |\n"
                             "____|\n")
    (= num-wrong 2) (println "  +--+\n"
                             " O  |\n"
                             " |  |\n"
                             "    |\n"
                             "____|\n")
    (= num-wrong 3) (println "  +--+\n"
                             " O  |\n"
                             " |  |\n"
                             " |  |\n"
                             "____|\n")
    (= num-wrong 4) (println "  +--+\n"
                             " O  |\n"
                             " |\\ |\n"
                             " |  |\n"
                             "____|\n")
    (= num-wrong 5) (println "  +--+\n"
                             " O  |\n"
                             "/|\\ |\n"
                             " |  |\n"
                             "____|\n")
    (= num-wrong 6) (println "  +--+\n"
                             " O  |\n"
                             "/|\\ |\n"
                             "/|  |\n"
                             "____|\n")))
;(print-hangman 0)

(defn take-guess []
  (println "Please enter a guess")
  (nth (read-line) 0))
;(take-guess)

(defn calculate-progress [codeword guesses]
  (let
    [progress
     (reduce
       (fn [acc c]
         (if (some (set guesses) (str c))
           (str acc c)
           (str acc "-")))
       ""
       codeword)]
    (println guesses)
    (println progress)
    progress))
;(calculate-progress "cat" "c")

(defn check-guess [codeword guesses]
  (if (= 0 (count guesses))
    true
    (some? (some
             (set codeword)
             (str (nth guesses (- (count guesses) 1)))))))
;(check-guess "cat" "z")

(defn check-state [codeword guesses n]
  (if (= (calculate-progress codeword guesses) codeword)
    (println "You win!")
    (if (check-guess codeword guesses)
      (do (print-hangman n) "pass")
      (if (< n 5)
        (do (print-hangman (+ n 1)) "fail")
        (println "You lose!\nThe secret word was" codeword ".")))))

(defn play-hangman [codeword]
  (loop [n 0 guesses (str (take-guess))]
    (let [state (check-state codeword guesses n)]
      (cond
        (= state "pass") (recur n (str guesses (take-guess)))
        (= state "fail") (recur (+ n 1) (str guesses (take-guess))))))
  (println "Would you like to play again?")
  (let [answer (read-line)]
    (if (or (= answer "yes") (= answer "y"))
      (play-hangman codeword)
      (println "goodbye"))))
(play-hangman "hangman")