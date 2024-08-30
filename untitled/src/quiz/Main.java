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