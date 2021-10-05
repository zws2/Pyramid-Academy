(ns guess-the-number.core)

(defn playAgain []
  (println "Would you like to play again? (y or n)")
  (let [input (read-line)]
    (= input "y")))

(defn guessCorrect [name numGuesses]
  (println "Good job," name " You guessed my number in " numGuesses " guesses!"))

(defn guessFeedback [guess num]
  (if (= guess num) true
                    (true? (if (> guess num)
                             (println "Your guess is too high.")
                             (println "Your guess was too low.")))))

(defn askForGuess []
  (println "Take a guess")
  (let [guess (read-line)]
    (Integer/parseInt guess)))

(defn greeting []
  (println "Hello! What is your name?")
  (let [name (read-line)]
    (println "Well," name ", I am thinking of a number between 1 and 20.")
    name))

(defn guessTheNumber []
  (let [num 10]
    (loop []
      (let [name (greeting)]
        (loop [numGuesses 1]
          (when (< numGuesses 5)
           (if (and (guessFeedback (askForGuess) num))
             (guessCorrect name numGuesses)
             (recur (+ numGuesses 1))))))
      (if (playAgain)
        (recur)
        (println "Goodbye")))))

(guessTheNumber)