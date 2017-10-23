package com.example.matheus_v_pereira.nutritech;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        inicializarIngredientes();
        inicializaAtributosParaCadastro();


                //Set the fragment initially
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        setTitle("Lista de Fichas");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.lista_fichas) {
            MainFragment fragment = new MainFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            setTitle("Lista de Fichas");


        } else if (id == R.id.lista_ingredientes) {
            Lista_Ingredientes fragment = new Lista_Ingredientes();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            setTitle("Lista de Ingredientes");
        } else if (id == R.id.lista_atributos) {
            ThirdFragment fragment = new ThirdFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            setTitle("Lista de Atributos");
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.menu_logoff) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void inicializarIngredientes(){
        ListView listView = (ListView) findViewById(R.id.minha_lista);

        //inicializa a lista que terá ingredientes
        ListIngredientes listaPdeingredientes = new ListIngredientes();

        //cria atributos
        Atributo prot = new Atributo("proteina", 10);
        Atributo carb = new Atributo("carboidrato", 28);
        Atributo gord = new Atributo("gordura", 13);

        //cria array de atributos
        ArrayList<Atributo> atributos = new ArrayList<>();
        atributos.add(carb);
        atributos.add(gord);
        atributos.add(prot);

        //cria ingredientes
        Ingrediente ingrediente0 = new Ingrediente(null, "Selecione");
        Ingrediente ingrediente1 = new Ingrediente(atributos, "pastel");
        Ingrediente ingrediente2 = new Ingrediente(atributos, "batata");
        Ingrediente ingrediente3 = new Ingrediente(atributos, "carne");

        //adiciona ingredientes
        listaPdeingredientes.addIngrediente(ingrediente0);
        listaPdeingredientes.addIngrediente(ingrediente1);
        listaPdeingredientes.addIngrediente(ingrediente2);
        listaPdeingredientes.addIngrediente(ingrediente3);

        //cria lista com os ingredientes
        List<Ingrediente> listadeingredientes = listaPdeingredientes.todosIngredientes();

        //manda pro adapter
        //ArrayAdapter<Ingrediente> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, listadeingredientes);
        //listView.setAdapter(adapter);

        IngredienteListAdapter ingredienteAdapter = new IngredienteListAdapter(this, listadeingredientes);
        listView.setAdapter(ingredienteAdapter);


        ingredienteAdapter.notifyDataSetChanged();
    }

    public void inicializaAtributosParaCadastro(){

        ListView listView = (ListView) findViewById(R.id.list_cadastroIngr);

        CadastraAtributo cadastrar = new CadastraAtributo();
        cadastrar.cadastrarAtributos();

        List<Atributo> atributoList = cadastrar.getAtributos().todosAtributos();

        AtributoAdapter atributoAdapter = new AtributoAdapter(this, atributoList);
        listView.setAdapter(atributoAdapter);
    }
}
