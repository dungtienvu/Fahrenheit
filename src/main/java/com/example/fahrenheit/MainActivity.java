package com.example.fahrenheit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;

public class MainActivity extends Activity {
    EditText edtFar, edtCel;
    Button btnF, btnCel, btnClear;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFar = findViewById(R.id.txtFar);
        edtCel = findViewById(R.id.txtCel);
        btnF = findViewById(R.id.btnF);
        btnCel = findViewById(R.id.btnCel);
        btnClear = findViewById(R.id.btnClear); // Thêm dòng này để khởi tạo btnClear

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtFar.setText("");
                edtCel.setText("");
            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = edtCel.getText().toString();
                if (!doC.isEmpty()) {
                    double C = Double.parseDouble(doC);
                    edtFar.setText(dcf.format(C * 1.8 + 32));
                }
            }
        });

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doF = edtFar.getText().toString();
                if (!doF.isEmpty()) {
                    double F = Double.parseDouble(doF);
                    edtCel.setText(dcf.format((F - 32) / 1.8));
                }
            }
        });
    }
}
