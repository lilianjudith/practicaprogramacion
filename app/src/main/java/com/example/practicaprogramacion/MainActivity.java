package com.example.practicaprogramacion;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    Button blimpiar;
    Button bcalcular;
    EditText enumero1;
    EditText enumero2;
    TextView tresultado;

    String snumero1;
    String snumero2;
    String sresultado = "";

    AlertDialog.Builder dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blimpiar = (Button) findViewById(R.id.limpiar);
        bcalcular = (Button) findViewById(R.id.calcular);
        enumero1 = (EditText) findViewById(R.id.numero1);
        enumero2 = (EditText) findViewById(R.id.numero2);
        tresultado = (TextView) findViewById(R.id.resultado);

        blimpiar.setEnabled(false);

        bcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snumero1 = enumero1.getText().toString();
                snumero2 = enumero2.getText().toString();
                sresultado = "";
                if(snumero1.length() == 0 ){
                    dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Ingresar el primer número");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            enumero1.requestFocus();
                        }
                    });
                    dialog.show();
                }else{
                    if(snumero2.length() == 0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar el segundo número");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                enumero1.requestFocus();
                            }
                        });
                        dialog.show();
                    }else {
                        double suma = Double.parseDouble(snumero1) + Double.parseDouble(snumero2);
                        if (suma % 1 == 0) {
                            sresultado += snumero1 + " + " + snumero2 + " = " + (int) suma + "\n";
                        } else{
                            sresultado += snumero1 + " + " + snumero2 + " = " + suma + "\n";
                        }
                        double resta = Double.parseDouble(snumero1) - Double.parseDouble(snumero2);
                        if (resta % 1 == 0) {
                            sresultado += snumero1 + " - " + snumero2 + " = " + (int) resta + "\n";
                        } else{
                            sresultado += snumero1 + " - " + snumero2 + " = " + resta + "\n";
                        }
                        double multiplicacion = Double.parseDouble(snumero1) * Double.parseDouble(snumero2);
                        if (multiplicacion % 1 == 0) {
                            sresultado += snumero1 + " * " + snumero2 + " = " + (int) multiplicacion + "\n";
                        } else{
                            sresultado += snumero1 + " * " + snumero2 + " = " + multiplicacion + "\n";
                        }
                        if(Integer.parseInt(snumero2) == 0){
                            sresultado += snumero1 + " / " + snumero2 + " = (División entre cero) \n";
                        }else{
                            double division = Double.parseDouble(snumero1) / Double.parseDouble(snumero2);
                            if (division % 1 == 0) {
                                sresultado += snumero1 + " / " + snumero2 + " = " + (int) division + "\n";
                            } else{
                                sresultado += snumero1 + " / " + snumero2 + " = " + division + "\n";
                            }
                        }
                        tresultado.setText(sresultado);
                        blimpiar.setEnabled(true);
                        bcalcular.setEnabled(false);
                    }
                }
            }
        });

        blimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { limpiar_controles();
            }
        });
    }

    public void limpiar_controles(){
        enumero1.setText("");
        enumero2.setText("");
        tresultado.setText("");
        blimpiar.setEnabled(false);
        bcalcular.setEnabled(true);
        enumero1.requestFocus();
    }
}
