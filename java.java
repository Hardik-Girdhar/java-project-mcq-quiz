import java.util.ArrayList;

import java.util.Scanner;

class Quiz {

    private ArrayList<Question> questions;

    public Quiz() {

        questions = new ArrayList<Question>();

    }

    public void addQuestion(Question q) {

        questions.add(q);

    }

    public void runQuiz() {

        Scanner scanner = new Scanner(System.in);

        User user = new User();

        

        String reset = "\u001B[0m";

        String red = "\u001B[31m";

        String green = "\u001B[32m";

        String yellow = "\u001B[33m";

        String blue = "\u001B[34m";

        String purple = "\u001B[35m";

        String cyan = "\u001B[36m";

        String border = "===================================";

        System.out.println(purple + border);

        System.out.println("Welcome to the Math Quiz!");

        System.out.println(border + reset);

        System.out.print(yellow + "\nPlease enter your name: " + reset);

        String name = scanner.nextLine();

        user.setName(name);

        for (Question q : questions) {

            System.out.println(blue + "\n" + border);

            System.out.println(q.getQuestionText());

            System.out.println(border + reset);

            for (int i = 0; i < q.getAnswerChoices().size(); i++) {

                System.out.println((i+1) + ". " + q.getAnswerChoices().get(i));

            }

            System.out.print(yellow + "\nEnter your answer: " + reset);

            int answer = scanner.nextInt();

            scanner.nextLine(); // consume the newline character

            if (q.isCorrect(answer)) {

                System.out.println(green + "\nCorrect!" + reset);

                user.incrementScore();

            } else {

                System.out.println(red + "\nIncorrect. The correct answer was " + q.getCorrectAnswer() + reset);

            }

        }

        System.out.println(purple + "\n" + border);

        System.out.println("Quiz complete! Your score is " + user.getScore() + " out of " + questions.size());

        System.out.println("Here are the correct answers:");

        for (Question q : questions) {

            System.out.println(q.getQuestionText() + " - " + q.getCorrectAnswer());

        }

        System.out.println(border + reset);

    }

}

class Question {

    private String questionText;

    private ArrayList<String> answerChoices;

    private int correctAnswer;

    public Question(String questionText, ArrayList<String> answerChoices, int correctAnswer) {

        this.questionText = questionText;

        this.answerChoices = answerChoices;

        this.correctAnswer = correctAnswer;

    }

    public String getQuestionText() {

        return questionText;

    }

    public ArrayList<String> getAnswerChoices() {

        return answerChoices;

    }

    public int getCorrectAnswer() {

        return correctAnswer;

    }

    public boolean isCorrect(int answer) {

        return answer == correctAnswer;

    }

}

class User {

    private String name;

    private int score;

    public User() {

        score = 0;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void incrementScore() {

        score++;

    }

    public String getName() {

        return name;

    }

    public int getScore() {

        return score;

    }

}

public class QuizRunner {

    public static void main(String[] args) {

        Quiz quiz = new Quiz();

        ArrayList<String> q1Choices = new ArrayList<String>();

        q1Choices.add("--> 1");

        q1Choices.add("--> 2");

        q1Choices.add("--> 3");

        q1Choices.add("--> 4");

        Question q1 = new Question("What is 2 + 2?", q1Choices, 4);

        quiz.addQuestion(q1);

        ArrayList<String> q2Choices = new ArrayList<String>();

        q2Choices.add("--> 1");

        q2Choices.add("--> 2");

        q2Choices.add("--> 3");

        q2Choices.add("--> 4");

        Question q2 = new Question("What is 5 - 3?", q2Choices, 2);

        quiz.addQuestion(q2);

        ArrayList<String> q3Choices = new ArrayList<String>();

        q3Choices.add("--> 8");

        q3Choices.add("--> 10");

        q3Choices.add("--> 12");

        q3Choices.add("--> 14");

        Question q3 = new Question("What is 4 * 3?", q3Choices, 12);

        quiz.addQuestion(q3);

        ArrayList<String> q4Choices = new ArrayList<String>();

        q4Choices.add("--> 2");

        q4Choices.add("--> 4");

        q4Choices.add("--> 5");

        q4Choices.add("--> 10");

        Question q4 = new Question("What is 10 / 2?", q4Choices, 5);

        quiz.addQuestion(q4);

        ArrayList<String> q5Choices = new ArrayList<String>();

        q5Choices.add("--> 10");

        q5Choices.add("--> 12");

        q5Choices.add("--> 14");

        q5Choices.add("--> 15");

        Question q5 = new Question("What is 7 + 7?", q5Choices, 14);

        quiz.addQuestion(q5);

        ArrayList<String> q6Choices = new ArrayList<String>();

        q6Choices.add("--> 10");

        q6Choices.add("--> 12");

        q6Choices.add("--> 14");

        q6Choices.add("--> 16");

        Question q6 = new Question("What is 6 * 2 + 4?", q6Choices, 16);

        quiz.addQuestion(q6);

        ArrayList<String> q7Choices = new ArrayList<String>();

        q7Choices.add("--> 2");

        q7Choices.add("--> 3");

        q7Choices.add("--> 4");

        q7Choices.add("--> 5");

        Question q7 = new Question("What is 12 / 3 - 2?", q7Choices, 2);

        quiz.addQuestion(q7);

        ArrayList<String> q8Choices = new ArrayList<String>();

        q8Choices.add("--> 15");

        q8Choices.add("--> 18");

        q8Choices.add("--> 21");

        q8Choices.add("--> 24");

        Question q8 = new Question("What is 9 + 3 * 2?", q8Choices, 15);

        quiz.addQuestion(q8);

        ArrayList<String> q9Choices = new ArrayList<String>();

        q9Choices.add("--> 5");

        q9Choices.add("--> 10");

        q9Choices.add("--> 15");

        q9Choices.add("--> 20");

        Question q9 = new Question("What is 20 / 4 + 5?", q9Choices, 10);

        quiz.addQuestion(q9);

        ArrayList<String> q10Choices = new ArrayList<String>();

        q10Choices.add("--> 12");

        q10Choices.add("--> 24");

        q10Choices.add("--> 36");

        q10Choices.add("--> 48");

        Question q10 = new Question("What is 2 * 3 * 4?", q10Choices, 24);

        quiz.addQuestion(q10);

        quiz.runQuiz();

    }

}
