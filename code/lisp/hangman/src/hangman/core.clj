(ns hangman.core)

;(def word-progress "")
;(def missed-letters "")
;(def flag false)

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

(defn ask-for-guess []
  (println "Guess a letter")
  (let [letter (read-line)]
    letter))

(defn calculate-progress [codeword word-progress guess missed-guesses]
  (let [flag false]
    (loop [n 0]
      (let [letter (nth codeword n)]
        (def word-progress
          (if (= guess (format "%s" letter))
            (do
              (def flag true)
              (apply str (assoc (vec word-progress) n letter)))
            word-progress)))
      (when (< n (- (count codeword) 1))
        (recur (+ n 1))))
    (if (not flag)
      (def missed-guesses (format "%s%s" missed-guesses guess)))
    (println word-progress)))

(defn print-game-status [word-progress missed-guesses]
  (println "Missed letters: " missed-guesses)
  (println word-progress))

(defn hangman []

  (let [word-progress "" missed-guesses ""]
    (print-hangman 0)
    (let [codeword "hangman"]
      (loop [n 0]
        (def word-progress (format "%s%s" word-progress "_"))
        (when (< n (- (count codeword) 1)) (recur (+ n 1))))
      (loop []
        (print-game-status word-progress missed-guesses)
        (calculate-progress codeword word-progress (ask-for-guess) missed-guesses)
        (print-hangman (count missed-guesses))
        (when (and (< (count missed-guesses) 6) (not= word-progress codeword)) (recur)))
      (if (>= (count missed-guesses) 6)
        (println "You lose!")
        (println "You win!"))
      (println "The secret word was" codeword))))

(hangman)
