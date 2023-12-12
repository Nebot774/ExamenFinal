package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;

import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el diseño de la actividad como "activity_main.xml"
        setContentView(R.layout.activity_main);

        // Crea un MutableLiveData para contener una lista de objetos "MoveListItem"
        MutableLiveData<List<MoveListItem>> moveList = new MutableLiveData<>();

        // Realiza una solicitud a la API para obtener una lista de movimientos Pokémon
        // y asigna la lista resultante al MutableLiveData "moveList"
        PokeAPI.getMoveList(moveList);

        // Inicializar el DrawerLayout y NavigationView
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Configurar el NavigationView para manejar los clics en los ítems del menú
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_move_list) {
                // Navegar al listado de movimientos
            } else if (id == R.id.nav_item_list) {
                // Navegar al listado de ítems
            } else if (id == R.id.nav_random_item) {
                // Navegar a un ítem aleatorio
            }

            // Cierra el menú lateral después de la selección de un ítem
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

}
