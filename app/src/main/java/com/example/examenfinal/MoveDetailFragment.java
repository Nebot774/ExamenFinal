package com.example.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenfinal.databinding.FragmentMoveDetailBinding;
import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.PokemonListItem;


public class MoveDetailFragment extends Fragment {

    private FragmentMoveDetailBinding binding; // Referencia al objeto de Data Binding
    private MovesViewModel movesViewModel; // ViewModel para gestionar los datos de los movimientos

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializar el ViewModel "movesViewModel" al vincularlo con la actividad requerida
        movesViewModel = new ViewModelProvider(requireActivity()).get(MovesViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicializar Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_move_detail, container, false);
        return binding.getRoot(); // Devolver la vista raíz del fragmento
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (movesViewModel != null) {
            // Observar cambios en el movimiento seleccionado del ViewModel
            movesViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Move>() {
                @Override
                public void onChanged(Move m) {
                    if (binding != null) {
                        // Establecer el objeto "Move" en el Data Binding
                        binding.setMove(m);
                    }
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Desvincular el Data Binding para liberar recursos
    }
}

