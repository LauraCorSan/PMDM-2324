package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.ViewFlipper;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.example.pmdm_2324.R;

public class u2a5PedirCita extends AppCompatActivity {
    EditText etDni, etNombre;
    Button btPediCita, btFecha, btHora;
    TextView tvErrorNombre, tvErrorDni, tvFecha, tvErrorFecha, tvHora, tvErrorHora, tvInfoCita;
    ViewFlipper vfConfirmacion;
    public static final String VACIO="";
    public static final String MSG_ERROR_NOMBRE="No ha introducido su nombre";
    public static final String MSG_ERROR_DNI="El DNI introducido no es valido";
    public static final String MSG_ERROR_HORARIO="La hora seleccionada no es valida\n(Horario: 9:00-14:00)";
    public static final String MSG_HORA_VACIA="Debe seleccionar una hora";
    public static final String MSG_ERROR_DIA="El dia seleccionado no es valido\n(Horario: Lunes-Viernes)";
    public static final String MSG_FECHA_VACIA="Debe seleccionar una fecha";
    String  dni, nombre,fechaCita, horaCita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a5_pedir_cita);

        etNombre=findViewById(R.id.u2a5etNombre);
        tvErrorNombre=findViewById(R.id.u2a5tvErrorNombre);
        etDni=findViewById(R.id.u2a5etDni);
        tvErrorDni=findViewById(R.id.u2a5tvErrorDni);

        btFecha=findViewById(R.id.u2a5btFecha);
        tvFecha=findViewById(R.id.u2a5tvFecha);
        tvErrorFecha=findViewById(R.id.u2a5tvErrorFecha);

        btHora=findViewById(R.id.u2a5btHora);
        tvHora=findViewById(R.id.u2a5tvHora);
        tvErrorHora=findViewById(R.id.u2a5tvErrorHora);

        btPediCita=findViewById(R.id.u2a5btPediCita);

        vfConfirmacion=findViewById(R.id.u2a5vfConfirmacion);
        tvInfoCita=findViewById(R.id.u2a5tvInfoCita);

        btFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        u2a5PedirCita.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                Calendar selectedDate = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                                int dayOfWeek = selectedDate.get(Calendar.DAY_OF_WEEK);

                                if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                                    // Mostrar un mensaje de error y no actualizar la fecha.
                                    tvErrorFecha.setText(MSG_ERROR_DIA);
                                } else {
                                    // on below line we are setting date to our text view.
                                    tvFecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                    fechaCita = tvFecha.getText().toString();
                                    tvErrorFecha.setText(VACIO);
                                }
                            }
                        },
                        // on below line we are passing year, month and day for selected date in our date picker.
                        year, month, day);
                // Obtener el DatePicker del DatePickerDialog y establecer la fecha minima
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                // at last we are calling show to display our date picker dialog.
                datePickerDialog.show();
            }
        });


        btHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(u2a5PedirCita.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // on below line we are setting date to our text view.


                                if (hourOfDay >= 9 && hourOfDay < 14) {
                                    //Formatear hora
                                    String horaFormat = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                                    tvHora.setText(horaFormat);
                                    horaCita=horaFormat;
                                    tvErrorHora.setText(VACIO);
                                    //Sin formato (original) = tvHora.setText(hourOfDay + ":" + minute);
                                }else{
                                    tvErrorHora.setText(MSG_ERROR_HORARIO);
                                }


                            }
                        }, hour, minute, false);
                // at last we are calling show to display our time picker dialog.
                timePickerDialog.show();
            }
        });


        btPediCita.setOnClickListener ((View v)->{
            nombre=etNombre.getText().toString();
            dni=etDni.getText().toString();
            //ValidarDNI
            if(dni.matches("[0-9]{1,8}[A-Z]")&& !dni.isEmpty() && !nombre.isEmpty() && fechaCita!=null && horaCita!=null){
                tvErrorNombre.setText(VACIO);
                tvErrorDni.setText(VACIO);
                tvInfoCita.setText(nombre+" con DNI "+dni+ " tiene su cita el dia "+fechaCita+" a las "+horaCita+"h ");

                btFecha.setVisibility(View.GONE);
                btHora.setVisibility(View.GONE);
                btPediCita.setVisibility(View.GONE);
                vfConfirmacion.setVisibility(View.VISIBLE);
                vfConfirmacion.showNext();

            }else{
                if(nombre.isEmpty()){
                    tvErrorNombre.setText(MSG_ERROR_NOMBRE);
                }else{
                    tvErrorNombre.setText(VACIO);
                }

                if(!(dni.matches("[0-9]{1,8}[A-Z]")) || dni.isEmpty()){
                    tvErrorDni.setText(MSG_ERROR_DNI);
                }else{
                    tvErrorDni.setText(VACIO);
                }

                if(fechaCita==null){
                    tvErrorFecha.setText(MSG_FECHA_VACIA);
                }else{
                    tvErrorFecha.setText(VACIO);
                }

                if(horaCita==null){
                    tvErrorHora.setText(MSG_HORA_VACIA);
                }else{
                    tvErrorHora.setText(VACIO);
                }
            }
        });


    }
}