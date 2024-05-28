package CODSOFT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String options[];
    char correctAnswer;

    Question(String question, String options[], char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class QuizApp {
    static final int QUESTION_TIME_LIMIT = 10;
    List<Question> questions = new ArrayList<>();
    List<Boolean> results = new ArrayList<>();
    int score = 0;
    Scanner sc = new Scanner(System.in);

    QuizApp() {
        loadQuestions();
    }

    public void loadQuestions() {
        questions.add(new Question("What is the capital of France?",
                new String[] { "A. Paris", "B. London", "C. Rome", "D. Berlin" }, 'A'));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[] { "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn" }, 'B'));
        questions.add(new Question("Who wrote 'The Merchant of Venice'?",
                new String[] { "A. Charles Dickens", "B. J.K. Rowling", "C. William Shakespeare", "D. Mark Twain" },
                'C'));
    }

    public void startQuiz() {
        for (int i = 0; i < questions.size(); i++) {
            boolean answeredCorrectly = askQuestion(i);
            results.add(answeredCorrectly);
            if (answeredCorrectly)
                score++;
        }
        displayResults();
    }

    public boolean askQuestion(int questionIndex) {
        Question question = questions.get(questionIndex);
        System.out.println(question.question);
        for (String option : question.options)
            System.out.println(option);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up!");
                synchronized (sc) {
                    sc.notify();
                }
            }
        };
        timer.schedule(task, QUESTION_TIME_LIMIT * 1000);
        String userAnswer = null;
        synchronized (sc) {
            try {
                userAnswer = sc.nextLine().toUpperCase();
                sc.notify();
            } catch (Exception e) {

            }
        }
        timer.cancel();
        if (userAnswer != null && userAnswer.length() == 1) {
            char answer = userAnswer.charAt(0);
            return answer == question.correctAnswer;
        }
        return false;
    }

    public void displayResults() {
        System.out.println("\nQuiz Over! Your Score: " + score + "/" + questions.size());
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            boolean result = results.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.question);
            System.out.println("Your answer was: " + (result ? "Correct" : "Incorrect"));
            System.out.println("Correct answer: " + question.correctAnswer);
        }
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.startQuiz();
    }
}