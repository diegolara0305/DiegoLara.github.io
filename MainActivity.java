package com.example.rockpaperscissor;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button rockbtn,paperbtn,scissorbtn;
    TextView scoretv;
    ImageView humanchoice, computerchoice;
    int ComputerScore=0,HumanScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockbtn=findViewById(R.id.rockbtn);
        paperbtn=findViewById(R.id.paperbtn);
        scissorbtn=findViewById(R.id.scissorbtn);

        scoretv=findViewById(R.id.scoretv);
        humanchoice=findViewById(R.id.imageViewHuman);
        computerchoice=findViewById(R.id.imageViewcomputer);



        rockbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanchoice.setImageResource(R.drawable.rock);
                String message=playerTurn("rock");
                scoretv.setText("Human Score: "+HumanScore +" Computer Score"+ ComputerScore);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });

        paperbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanchoice.setImageResource(R.drawable.paper);
                String message=playerTurn("paper");
                scoretv.setText("Human Score: "+HumanScore +" Computer Score"+ ComputerScore);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });

        scissorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                humanchoice.setImageResource(R.drawable.scissors);
                String message=playerTurn("scissors");
                scoretv.setText("Human Score: "+HumanScore +" Computer Score"+ ComputerScore);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();

            }
        });




    }

    public String playerTurn(String player_choice) {

        String computer_choice="";

        Random r=new Random();

        int computervalue=r.nextInt(3)+1;


        if(computervalue==1)
        {
            computer_choice="rock";
            computerchoice.setImageResource(R.drawable.rock);

        } else if (computervalue==2) {
            computer_choice="paper";
            computerchoice.setImageResource(R.drawable.paper);

        }
        else {
            computer_choice="scissors";
            computerchoice.setImageResource(R.drawable.scissors);
        }



        // computer human and computer choice to dtermine who won.
        if (computer_choice == player_choice) {
            return "Draw.  Nobody won.";
        }
        else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "Rock crushes scissors. You win!";
        }
        else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Paper covers rock. Computer wins!";
        }
        else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Rock crushes scissors. Computer wins!";
        }
        else if (player_choice == "scissors" && computer_choice == "paper") {
            HumanScore++;
            return "Scissors cuts paper. You win!";
        }

        else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Paper covers rock. You win!";
        }
        else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Scissors cuts paper. Computer wins!";
        }
        else return "Not sure";



    }
}