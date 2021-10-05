(ns hangman.macro)

(defmacro hello []
  `(+ 1 2))

(macroexpand-1 `(hello))

(defmacro hello
  [& args]
  `(list ~@args))

(defmacro my-if
  [& args]
  (if (= 3 (count args))
    `(if ~@args)
       `(cond ~@args)))