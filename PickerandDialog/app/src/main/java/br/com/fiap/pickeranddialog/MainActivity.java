package br.com.fiap.pickeranddialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dtpDataNasc;
    TimePicker tmpHoraNasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dtpDataNasc = findViewById(R.id.dtpDataNasc);
                tmpHoraNasc = findViewById(R.id.tmpHoraNasc);
                }

public void salvar(View view) {

        int dia = dtpDataNasc.getDayOfMonth();
        int mes = dtpDataNasc.getMonth() + 1;
        int ano = dtpDataNasc.getYear();

        int hora = tmpHoraNasc.getCurrentHour();
        int minuto = tmpHoraNasc.getCurrentMinute();

        String msg = String.format("%d/%d/%d %d:%d", dia, mes, ano, hora, minuto);

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        }

public void abrirAlertDialog(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle(R.string.eu_sou_um_alert2);
        alert.setMessage(R.string.conteudo_do_alert);
        alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.cliquei, Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
        }

    public void abrirProgressDialog(View view) {
        ProgressDialog pd = new ProgressDialog(this);

        pd.setTitle(R.string.progress);
        pd.setMessage(getString(R.string.aguarde));
        pd.show();
    }

    public void AbrirDatePickerDialog(View view) {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
            }
        }, 2018, 4, 17);
        dialog.show();
    }

    public void AbrirDialogPersonalizado(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setTitle(R.string.dialogPersonalizado);
        dialog.setContentView(R.layout.dialog_personalizado);
        dialog.show();
    }
}
