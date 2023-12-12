package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class MovesViewModel extends AndroidViewModel {
    // LiveData para almacenar el movimiento seleccionado
    MutableLiveData<Move> selectedMoveMutableLiveData = new MutableLiveData<>();

    // LiveData para almacenar la lista de elementos de movimiento
    MutableLiveData<List<MoveListItem>> listElementosMutableLiveData = new MutableLiveData<>();

    // Variable para almacenar el elemento de movimiento seleccionado
    MoveListItem selected;

    public MovesViewModel(@NonNull Application application) {
        super(application);

        // Llama a la función para obtener la lista de elementos de movimiento desde la API
        PokeAPI.getMoveList(listElementosMutableLiveData);
    }

    // Método para obtener la lista de elementos de movimiento
    MutableLiveData<List<MoveListItem>> getAll() {
        return listElementosMutableLiveData;
    }

    // Método para seleccionar un elemento de movimiento
    public void select(MoveListItem moveListItem) {
        selected = moveListItem;
    }

    // Método para obtener el detalle de un movimiento seleccionado
    public MutableLiveData<Move> getSelected() {
        // Llama a la función para obtener los detalles del movimiento desde la API
        PokeAPI.getMove(selected.getName(), selectedMoveMutableLiveData);
        return selectedMoveMutableLiveData;
    }
}

