package com.example.inmobiliaria.ui.perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.inmobiliaria.vistas.MainActivity;
import com.example.inmobiliaria.vistas.Principal;
import com.example.inmobiliaria.R;

public class PerfilFragment extends Fragment {
    EditText dni, apellido, nombres, tel, mail, pass;
    Button aceptar,editar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        ((Principal) getActivity()).setActionBarTitle("Perfil");

        dni=root.findViewById(R.id.dni);
        apellido=root.findViewById(R.id.apellido);
        nombres=root.findViewById(R.id.nombres);
        tel=root.findViewById(R.id.tel);
        mail=root.findViewById(R.id.mail);
        pass=root.findViewById(R.id.pass);

        aceptar=root.findViewById(R.id.aceptar);
        editar=root.findViewById(R.id.editar);

        fijarDatos();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea guardar los datos?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aceptar();
                        fijarDatos();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fijarDatos();
                    }
                }).show();
            }
        });

        return root;
    }

    public void editar(){
        dni.setEnabled(true);
        apellido.setEnabled(true);
        nombres.setEnabled(true);
        tel.setEnabled(true);
        mail.setEnabled(true);
        pass.setEnabled(true);

        editar.setVisibility(View.GONE);
        aceptar.setVisibility(View.VISIBLE);

    }

    public void aceptar(){
        MainActivity.sesion.setDni(Integer.parseInt(dni.getText().toString()));
        MainActivity.sesion.setApellido(apellido.getText().toString());
        MainActivity.sesion.setNombre(nombres.getText().toString());
        MainActivity.sesion.setTelefono(Integer.parseInt(tel.getText().toString()));
        MainActivity.sesion.setMail(mail.getText().toString());
        MainActivity.sesion.setPassword(pass.getText().toString());
    }

    public void fijarDatos(){
        dni.setText(String.valueOf(MainActivity.sesion.getDni()));
        apellido.setText(String.valueOf(MainActivity.sesion.getApellido()));
        nombres.setText(String.valueOf(MainActivity.sesion.getNombre()));
        tel.setText(String.valueOf(MainActivity.sesion.getTelefono()));
        mail.setText(String.valueOf(MainActivity.sesion.getMail()));
        pass.setText(String.valueOf(MainActivity.sesion.getPassword()));

        dni.setEnabled(false);
        apellido.setEnabled(false);
        nombres.setEnabled(false);
        tel.setEnabled(false);
        mail.setEnabled(false);
        pass.setEnabled(false);

        editar.setVisibility(View.VISIBLE);
        aceptar.setVisibility(View.GONE);

    }
}