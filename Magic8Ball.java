import java.util.Scanner;
/**
 Magic8Ball - Declare several questions and call the method ask8Ball with each
 Author: Allen Rodriguez
 Date: March 26, 2023
 */
public class Magic8Ball{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ask a question: ");
        String question1 = input.nextLine();
        System.out.println("Ask another question: ");
        String question2 = input.nextLine();
        System.out.println("Ask a final question: ");
        String question3 = input.nextLine();

        String[] questions = {question1, question2, question3};

        for (String q : questions) {
            System.out.println(q + " - " + ask8Ball(q));
        }
    }

    /**
     ask8Ball - Takes a question and returns an answer
     @param q the questions
     @return an answer
     */
    public static String ask8Ball(String q) {
        String[] answers = {"It is certain", "It is decidedly so", "Without a doubt", "Yes – definitely", "You may rely on it",
                "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes",
                "Reply hazy, try again", "Ask again later", "Better not tell you now", "Cannot predict now",
                "Concentrate and ask again", "Don't count on it", "Outlook not so good", "My sources say no",
                "Very doubtful", "My reply is no"};

        int index = (int) (Math.random() * answers.length);
        return answers[index];
    }

}
