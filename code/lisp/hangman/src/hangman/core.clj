(ns hangman.core)

(defn hangman [])
(defn printHangman [numWrong]
  (cond
    (= numWrong 0) (print   " +--+\n"
                            "    |\n"
                            "    |\n"
                            "    |\n"
                            "____|\n")
    (= numWrong 1) (println " +--+\n"
                            " O  |\n"
                            "    |\n"
                            "    |\n"
                            "____|\n")
    (= numWrong 2) (println " +--+\n"
                            " O  |\n"
                            " |  |\n"
                            "    |\n"
                            "____|\n")
    (= numWrong 3) (println " +--+\n"
                            " O  |\n"
                            " |  |\n"
                            " |  |\n"
                            "____|\n")
    (= numWrong 4) (println " +--+\n"
                            " O  |\n"
                            " |\ |\n"
                            " |  |\n"
"____|\n")
    (= numWrong 5) (println " +--+\n"
                            " O  |\n"
                            "/|\ |\n"
                            " |  |\n"
                            "____|\n"))

    ))
;
;case 0: System.out.print(
;                          " +--+\n" +
;                          "    |\n" +
;                          "    |\n" +
;                          "    |\n" +
;                          "____|\n");
;break;
;case 1: System.out.print(
;                          " +--+\n" +
;                          " O  |\n" +
;                          "    |\n" +
;                          "    |\n" +
;                          "____|\n");
;break;
;case 2: System.out.print(
;                          " +--+\n" +
;                          " O  |\n" +
;                          " |  |\n" +
;                          "    |\n" +
;                          "____|\n");
;break;
;case 3: System.out.print(
;                          " +--+\n" +
;                          " O  |\n" +
;                          " |  |\n" +
;                          " |  |\n" +
;                          "____|\n");
;break;
;case 4: System.out.print(
;                          " +--+\n" +
;                          " O  |\n" +
;                          " |\\ |\n" +
;                          " |  |\n" +
;                          "____|\n");
;break;
;case 5: System.out.print(
;                          " +--+\n" +
;                          " O  |\n" +
;                          "/|\\ |\n" +
;                          " |  |\n" +
;                          "____|\n");
;break;
;case 6: System.out.print(
;                          " +--+\n" +
;                          " O  |\n" +
;                          "/|\\ |\n" +
;                          "/|  |\n" +
;                          "____|\n");