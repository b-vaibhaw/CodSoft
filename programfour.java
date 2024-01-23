import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class programfour {
    Scanner sc;
    public String[] qns;
    String[] option;
    private char[] ans;
    int qn = 5;

    private final int TIME_LIMIT = 10;

    public void quizfn() {
        sc = new Scanner(System.in);
        qns = new String[qn];
        option = new String[qn];
        ans = new char[qn];
        QuizData();
    }

    private void QuizData() {
        qns[0] = "Who is the CEO of BlackRock?";
        qns[1] = "Which of these is a Indian Origin Language?";
        qns[2] = "Which Country has reache on South Pole of Moon?";
        qns[3] = "Who is the Indian President?";
        qns[4] = "What is part of a database that holds only one type of information?";

        option[0] = "A. Larry Fink\nB. Jeff Bezos\nC. Curtis Priem\nD. Ronald Wayne";
        option[1] = "A. Spanish\nB. Bhojpuri\nC. Pastuni\nD. English";
        option[2] = "A. India\nB. Russia\nC. America\nD. China";
        option[3] = "A. Nirmala Sitaraman\nB. Rahul Gandhi\nC. Droupadi Murmu\nD. A.P.J. Abdul Kalam";
        option[4] = "A. Report\nB. Field\nC. Record\nD. File";

        ans[0] = 'A';
        ans[1] = 'B';
        ans[2] = 'A';
        ans[3] = 'C';
        ans[4] = 'B';
    }

    public void displayQuestion(int index) {
        System.out.println("Question " + (index + 1) + ":\n" + qns[index] + "\n" + option[index]);
    }

    public char getAnswer(int index) {
        return ans[index];
    }

    public void sQuiz() {
        int score = 0, correct = 0, incorrect = 0;

        for (int i = 0; i < qn; i++) {
            displayQuestion(i);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time is up!");
                    // incorrect++;
                    timer.cancel();
                }
            };

            timer.schedule(task, TIME_LIMIT * 1000);
            System.out.print("Enter your answer: ");
            char answer = sc.next().toUpperCase().charAt(0);
            task.cancel();

            if (answer == getAnswer(i)) {
                System.out.println("Correct!");
                score += 10;
                correct++;
            } else {
                System.out.println("Incorrect!");
                incorrect++;
            }
        }

        displayResult(score, correct, incorrect);
    }

    public void displayResult(int score, int correct, int incorrect) {
        System.out.println("\nYour final score is: " + score);
        System.out.println(
                "You answered " + correct + " questions correctly and " + incorrect + " questions incorrectly.");
    }

    public static void main(String[] args) {
        programfour quiz = new programfour();
        quiz.quizfn();
        quiz.sQuiz();
        quiz.sc.close();
    }
}
