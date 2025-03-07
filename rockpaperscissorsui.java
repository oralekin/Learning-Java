import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class rockpaperui {

    public static String game(Integer user, String[] answers){
        Integer computer =  new Random().nextInt(3);

        String str2return = "";
        if (user.equals(computer)){
            str2return += ("You both chose " + answers[user]);
        } else if ((user + 1) % 3 == computer) {
            str2return += ("Computer chose " + answers[computer] + ". Computer Wins");
        } else {
            str2return += ("Computer chose " + answers[computer] + ". You Win");
        }

        return str2return;
    }

    public static void main(String[] args){
        String[] answers = {"ROCK", "PAPER", "SCISSORS"};
        JFrame j = new JFrame();

        JLabel label = new JLabel("CHOOSE");
        label.setBounds(30, 100, 500, 40);
        j.add(label);

        JButton rock = new JButton(answers[0]);
        rock.setBounds(30,200,100, 40);
        rock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gamePlay = game(0, answers);
                label.setText("You chose ROCK. " + gamePlay);
            }
        });


        JButton paper = new JButton(answers[1]);
        paper.setBounds(140,200,100, 40);
        paper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gamePlay = game(1, answers);
                label.setText("You chose PAPER. " + gamePlay);
            }
        });

        JButton scissors = new JButton(answers[2]);
        scissors.setBounds(250,200,100, 40);
        scissors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gamePlay = game(2, answers);
                label.setText("You chose SCISSORS. " + gamePlay);
            }
        });

        j.add(rock);
        j.add(paper);
        j.add(scissors);

        j.setSize(600, 400);
        j.setLayout(null);
        j.setVisible(true);
    }

}
