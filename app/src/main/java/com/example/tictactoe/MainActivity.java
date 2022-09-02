package com.example.tictactoe;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


// import android.widget.GridLayout;


public class MainActivity extends AppCompatActivity {
    int activeplayer=0;int x=0;
    //0=zero,1-cross,2-empty
    int[]gamestate={2,2,2,2,2,2,2,2,2};
    int winningpositions[][]={ {0,1,2}, {3,4,5},{6,7,8,},{ 0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}   };
    boolean gameactive=true;
public void dropIn(View view){

ImageView counter=(ImageView)view;
int gamecounter=Integer.parseInt(counter.getTag().toString());
    if(gamestate[gamecounter]==2 && gameactive){
gamestate[gamecounter]=activeplayer ;
counter.setTranslationY(-1500);
if(activeplayer==0){
counter.setImageResource(R.drawable.zero);
activeplayer=1;
}

else{
    counter.setImageResource(R.drawable.cross);
    activeplayer=0;
}
counter.animate().translationY(35).rotation(3600).setDuration(500);

for(int winningposition[] :winningpositions ){
    if(gamestate[winningposition[0]]==gamestate[winningposition[1]] && gamestate[winningposition[1]]==gamestate[winningposition[2]] && gamestate[winningposition[2]]!=2 ){
gameactive=false;
       String winner=" ";
       if(activeplayer==1){
           winner="ZERO";
       }
       else{
           winner="CROSS";
       }

        Toast.makeText(this, winner+" has won!", Toast.LENGTH_SHORT).show();
       Button playagain=(Button)findViewById(R.id.button);
       playagain.setVisibility(View.VISIBLE);
    }}}}



public void playagain(View view){
   // Button playagain=(Button)findViewById(R.id.button);

   Button playagain=findViewById(R.id.button);
//GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
    playagain.setVisibility(View.INVISIBLE);
    GridLayout gridLayout = findViewById(R.id.gridLayout);
    for(int i = 0; i < gridLayout.getChildCount(); i++) {

       ImageView child = (ImageView) gridLayout.getChildAt(i);
        child.setImageDrawable(null);}

    activeplayer=0;
    //0=zero,1-cross,2-empty
    for(int i=0 ;i<gamestate.length;i++){
        gamestate[i]=2;
    }

 gameactive=true;
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}