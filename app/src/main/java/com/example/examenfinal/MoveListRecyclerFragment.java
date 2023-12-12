package com.example.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.examenfinal.databinding.FragmentMoveListRecyclerBinding;
import com.example.examenfinal.databinding.ViewholderMoveListBinding;

import com.example.examenfinal.models.Move;
import com.example.examenfinal.models.MoveListItem;

import java.util.List;

public class MoveListRecyclerFragment extends Fragment {
    private FragmentMoveListRecyclerBinding binding;
    private MovesViewModel movesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("MoveListRecy", "onCreateView called");
        return (binding = FragmentMoveListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("MoveListRecycl", "onViewCreated called");
        movesViewModel = new ViewModelProvider(requireActivity()).get(MovesViewModel.class);
        navController = Navigation.findNavController(view);

        // Asegúrate de que la instancia del adaptador y la configuración del RecyclerView estén correctamente implementadas.
// ...
        MovesAdapter movesAdapter = new MovesAdapter(moveListItem -> {
            // Aquí estableces el movimiento seleccionado en el ViewModel
            movesViewModel.select(moveListItem);

            // Navegación al MoveDetailFragment
            navController.navigate(R.id.action_moveListRecyclerFragment_to_moveDetailFragment);
        });
// ...


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(movesAdapter);

        // Cuando cambia el viewmodel se actualiza la lista con setList(List<MoveListItem> moveList)
        movesViewModel.getAll().observe(getViewLifecycleOwner(), movesAdapter::setList);
    }


    public class MovesAdapter extends RecyclerView.Adapter<MovesAdapter.MoveViewHolder> {
        private List<MoveListItem> moveList; // Lista de movimientos a mostrar
        private final OnMoveSelectedListener onMoveSelectedListener; // Listener para manejar la selección de un movimiento

        // Constructor que recibe un listener como parámetro
        public MovesAdapter(OnMoveSelectedListener onMoveSelectedListener) {
            this.onMoveSelectedListener = onMoveSelectedListener;
        }

        @NonNull
        @Override
        public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Infla la vista del elemento de lista utilizando Data Binding
            ViewholderMoveListBinding binding = ViewholderMoveListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new MoveViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
            MoveListItem move = moveList.get(position); // Obtiene el objeto de movimiento en la posición actual
            holder.binding.setMove(move); // Asigna el objeto de movimiento al Data Binding
            holder.itemView.setOnClickListener(v -> onMoveSelectedListener.onMoveSelected(move)); // Configura un listener de clic para el elemento de lista
        }

        @Override
        public int getItemCount() {
            return moveList != null ? moveList.size() : 0; // Devuelve la cantidad de elementos en la lista o 0 si la lista es nula
        }

        // Método para actualizar la lista de movimientos y notificar al adaptador
        public void setList(List<MoveListItem> moveList){
            this.moveList = moveList;
            notifyDataSetChanged();
        }

        // ViewHolder para cada elemento de lista
        class MoveViewHolder extends RecyclerView.ViewHolder {
            final ViewholderMoveListBinding binding; // Referencia al objeto de Data Binding

            MoveViewHolder(ViewholderMoveListBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }


    public interface OnMoveSelectedListener {
        void onMoveSelected(MoveListItem moveListItem);
    }


}