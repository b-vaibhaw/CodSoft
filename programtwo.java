import java.util.Scanner;

public class programtwo {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter the Number of Subjects:");
        int subno = sn.nextInt();
        float tm = 0;
        for (float j = 1; j <= subno; j++) {
            System.out.printf("Enter the Subject %.0f marks (in 100):\n", j);
            tm += sn.nextFloat();
        }
        sn.close();
        System.out.printf("Total marks obtained is %.3f in %d .\n", tm, (subno * 100));
        System.out.printf("Your average percentage in %d subject(s) is %.3f .\n", subno, (tm / subno));

        if (marks / subno >= 90) {
            System.out.println("Grade is A+.");
        } else if (tm / subno >= 80) {
            System.out.println("Grade is A.");
        } else if (tm / subno >= 70) {
            System.out.println("Grade is B+.");
        } else if (tm / subno >= 60) {
            System.out.println("Grade is B.");
        } else {
            System.out.println("You are Below 60.");
        }
    }
}
