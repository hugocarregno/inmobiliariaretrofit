package com.example.inmobiliaria.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Contrato;
import com.example.inmobiliaria.model.Inquilino;
import com.example.inmobiliaria.model.Pago;
import com.example.inmobiliaria.model.Propiedad;
import com.example.inmobiliaria.model.Propietario;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText name,pass;
    private TextView error;
    public static Propietario sesion;
    public static List<Propiedad> propiedades=new ArrayList<>();
    public static List<Pago> pagos=new ArrayList<>();
    public static List<Inquilino> inquilinos=new ArrayList<>();
    public static List<Contrato> contratos=new ArrayList<>();
    private MainViewModel mainViewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurarVista();


    }

    public void configurarVista(){
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        error=findViewById(R.id.error);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.getPropietarioMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                Log.d("token",s);

            }
        });
    }

    public void ingresar(android.view.View view){
        String usuario=name.getText().toString();
        String contra=pass.getText().toString();

        if(usuario.equals("") || contra.equals("")){
            Toast.makeText(getApplicationContext(), "Completar", Toast.LENGTH_LONG).show();

        }else{
            mainViewModel.loginVM(usuario,contra);
        }


    }


   /* private EditText name,pass;
    private TextView error;
    public static Propietario sesion;
    public static List<Propiedad> propiedades=new ArrayList<>();
    public static List<Pago> pagos=new ArrayList<>();
    public static List<Inquilino> inquilinos=new ArrayList<>();
    public static List<Contrato> contratos=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        error=findViewById(R.id.error);

        sesion=new Propietario(1,379999999,"Perez","Juan",1133423476,"juancito22@gmail.com","admin","admin");
        Propiedad pcero=new Propiedad(1,sesion, "Las Heras 1225",3,"Casa","Residencial",5000,true);
        Propiedad puno=new Propiedad(2,sesion,"San Martin y Lavalle",5,"Departamento","Residencial",7500,false);
        Propiedad pdos=new Propiedad(3,sesion,"Justo Darac 322",1,"Local","Comercial",15000,true);
        Propiedad ptres=new Propiedad(4,sesion,"Perú 205",2,"Departamento","Residencial",6000,false);
        Inquilino icero=new Inquilino(1,33234321,"Ronaldo","Cristiano","ronadinho_gato@g.c",1221212223);
        Inquilino iuno=new Inquilino(2,44332112,"Robocop","Piola","roboCorazones@g.c",918313819);
        Inquilino idos=new Inquilino(3,32112332,"Maravilla","Ricardo","adictoAti@g.c",17398182);
        Contrato ccero=new Contrato(1,icero,puno,puno.getPrecio()*24,new Date(),null,0);
        Contrato cuno=new Contrato(2,iuno,pdos,pdos.getPrecio()*24,new Date(),new Date(),0);
        Contrato cdos=new Contrato(3,idos,ptres,ptres.getPrecio()*24,new Date(),null,0);
        Pago mcero=new Pago(1,cuno,1,new Date(),pdos.getPrecio()*24);
        Pago muno=new Pago(2,ccero,1,new Date(),ccero.getPropiedad().getPrecio());
        Pago mdos=new Pago(3,cdos,1,new Date(),cdos.getPropiedad().getPrecio());
        Pago mtres=new Pago(4,ccero,2,new Date(),ccero.getPropiedad().getPrecio());
        Pago mcuatro=new Pago(5,cdos,2,new Date(),cdos.getPropiedad().getPrecio());
        Pago mcinco=new Pago(6,ccero,3,new Date(),ccero.getPropiedad().getPrecio());
        Pago mseis=new Pago(7,cdos,3,new Date(),cdos.getPropiedad().getPrecio());

        propiedades.add(pcero);propiedades.add(puno);propiedades.add(pdos);propiedades.add(ptres);
        inquilinos.add(icero);inquilinos.add(iuno);inquilinos.add(idos);
        contratos.add(ccero);contratos.add(cuno);contratos.add(cdos);
        pagos.add(mcero);pagos.add(muno);pagos.add(mdos);pagos.add(mtres);pagos.add(mcuatro);pagos.add(mcinco);pagos.add(mseis);

    }

    public void ingresar(android.view.View view){
        String usuario=name.getText().toString();
        String contra=pass.getText().toString();

        if(usuario.equals(sesion.getUsername())&&contra.equals(sesion.getPassword())){
            error.setVisibility(View.GONE);
            Intent ingresar=new Intent(this,Principal.class);
            MainActivity.this.startActivity(ingresar);
        } else {
            error.setVisibility(View.VISIBLE);
        }
    }

    */


/*
    public void registrarse(View v){
        Intent intent = new Intent(this,RegistroActivity.class);
        startActivity(intent);
    }
}

 */
}
