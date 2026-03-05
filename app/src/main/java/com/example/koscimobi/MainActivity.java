package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button rzuckosci;
    private Button reset;
    private TextView wynikTen;
    private TextView wynikGry;
    private LinearLayout box;

    private int wynikgry = 0;
    private int wynikten = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rzuckosci = findViewById(R.id.rzuckosci);
        reset = findViewById(R.id.reset);
        wynikTen = findViewById(R.id.wynikTen);
        wynikGry = findViewById(R.id.wynikGry);
        box = findViewById(R.id.box);



        rzuckosci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 1; i <= 6; i++)
                {
                    box.removeAllViews();

                    Random rand = new Random();
                    int number = rand.nextInt(6) + 1;

                    int[] imgs = {
                            R.drawable.k1,
                            R.drawable.k2,
                            R.drawable.k3,
                            R.drawable.k4,
                            R.drawable.k5,
                            R.drawable.k6
                    };

                    ImageView img = new ImageView(MainActivity.this);
                    img.setImageResource(imgs[number]);

                    box.addView(img);

                    wynikten = wynikten + number;
                    wynikTen.setText("Wynik tego losowania: " + wynikten);

                    wynikgry = wynikgry+wynikten;
                    wynikGry.setText("Wynik gry: " + wynikGry);

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wynikgry = 0;
                wynikten = 0;
            }
        });
    }
}