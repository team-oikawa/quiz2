package quiz;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {

        List<Quiz> quizzes = new ArrayList<Quiz>();
        List<Choice> q1Choices = new ArrayList<Choice>();
        q1Choices.add(new Choice(1, "食パン"));
        q1Choices.add(new Choice(2, "あんパン"));
        q1Choices.add(new Choice(3, "フライパン"));
        quizzes.add(new Quiz(1, "パンはパンでも食べられないパンは?", q1Choices, 3));

        List<Choice> q2Choices = new ArrayList<Choice>();
        q2Choices.add(new Choice(1, "近畿地方"));
        q2Choices.add(new Choice(2, "関東地方"));
        q2Choices.add(new Choice(3, "九州地方"));
        quizzes.add(new Quiz(2, "群馬県は何地方?", q2Choices, 2));

        List<Choice> q3Choices = new ArrayList<Choice>();
        q3Choices.add(new Choice(1, "1960年"));
        q3Choices.add(new Choice(2, "1940年"));
        q3Choices.add(new Choice(3, "1964年"));
        quizzes.add(new Quiz(3, "最初の東京オリンピックは何年?", q3Choices, 3));

        Player player = new Player();
        for (Quiz quiz : quizzes) {
            quiz.showQuiz();
            String input = null;
            try {
                BufferedReader inputuser = new BufferedReader(
                        new InputStreamReader(System.in)
                );
                input = inputuser.readLine();
            } catch (IOException e) {
                System.out.print("システムエラー");
                System.exit(0);
                return;
            }
            //inputをint型にする
            int inputInt = 0;
            try {
                inputInt = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("1-3の数字を入力してください。");
                System.exit(0);
                return;
            }
            //1-3であることをチェックする
            if (inputInt > 3 || inputInt < 1) {
                System.out.println("1-3の数字を入力してください。");
                System.exit(0);
                return;
            }
            if(quiz.isCorrect(inputInt)) {
                player.setCorrectQuizNum(player.getCorrectQuizNum() + 1);
            }
        }
        System.out.println("[結果]");
        player.showCorrectQuizNum();
    }
}