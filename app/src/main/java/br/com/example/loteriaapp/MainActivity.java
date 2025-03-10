package br.com.example.loteriaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

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
    }

    public void sortearNumero(View view){
        TextView resultado = findViewById(R.id.resultTxt);
        HashSet<Integer> num = new HashSet<>();
        while(num.size() < 6){
            int nums = new Random().nextInt(60) + 1;
            num.add(nums);
        }

        resultado.setText("Números: \n" + num.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }

    public void limparNumero(View view){
        TextView resultado = findViewById(R.id.resultTxt);
        resultado.setText("------");
    }
}