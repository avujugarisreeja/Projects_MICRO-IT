import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        String[] questions = {
            "What is the capital of France?\n(a) Berlin\n(b) Madrid\n(c) Paris\n(d) Rome",
            "Who wrote 'Romeo and Juliet'?\n(a) Dickens\n(b) Shakespeare\n(c) Orwell\n(d) Hemingway",
            "Which planet is known as the Red Planet?\n(a) Earth\n(b) Mars\n(c) Venus\n(d) Jupiter"
        };
        char[] answers = {'c', 'b', 'b'};

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q" + (i + 1) + ": " + questions[i]);
            System.out.print("Your answer: ");
            char userAnswer = scanner.next().charAt(0);

            if (userAnswer == answers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + answers[i] + "\n");
            }
        }

        System.out.println("You scored: " + score + " out of " + questions.length);
        scanner.close();
    }
}
