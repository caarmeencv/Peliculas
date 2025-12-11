package com.carmen.peliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdaptadorPelicula extends RecyclerView.Adapter<AdaptadorPelicula.celdaPeliculajava>{

    List<Pelicula> peliculas;
    public AdaptadorPelicula (List<Pelicula> peliculas){
        this.peliculas = peliculas;
    }

    //para seleccionar elementos de la rv
    int selectedPos = RecyclerView.NO_POSITION;
    public int getSelectedPos () {
        return selectedPos;
    }
    public void setSelectedPos(int nuevaPos) {
        // Si se pulsa sobre el elemento marcado
        if (nuevaPos == this.selectedPos){
            // Se establece que no hay una posición marcada
            this.selectedPos=RecyclerView.NO_POSITION;
            // Se avisa al adaptador para que desmarque esa posición
            notifyItemChanged(nuevaPos);
        } else { // El elemento pulsado no está marcado
            if (this.selectedPos >=0 ) { // Si ya hay otra posición marcada
                // Se desmarca
                notifyItemChanged(this.selectedPos);
            }
            // Se actualiza la nueva posición a la posición pulsada
            this.selectedPos = nuevaPos;
            // Se marca la nueva posición
            notifyItemChanged(nuevaPos);
        }
    }

    @NonNull
    @Override
    public celdaPeliculajava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda= LayoutInflater.from(parent.getContext()).inflate(R.layout.celdapelicula, parent, false);
        celdaPeliculajava celdaPeliculajava = new celdaPeliculajava(celda);
        return celdaPeliculajava;
    }

    @Override
    public void onBindViewHolder(@NonNull celdaPeliculajava holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.portada.setImageResource(pelicula.getPortada());
        holder.clasi.setImageResource(pelicula.getClasi());
        holder.titulo.setText(pelicula.getTitulo());
        holder.director.setText(pelicula.getDirector());

        //para seleccionar un elemento
        if (selectedPos == position) {
            holder.itemView.setBackgroundResource(R.color.seleccionado);
        } else {
            holder.itemView.setBackgroundResource(R.color.celda);
        }
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class celdaPeliculajava extends RecyclerView.ViewHolder {

        TextView titulo, director;
        ImageView portada, clasi;

        public celdaPeliculajava(@NonNull View itemView) {
            super(itemView);
            this.titulo=itemView.findViewById(R.id.tvtitulo);
            this.director=itemView.findViewById(R.id.tvdirector);
            this.portada=itemView.findViewById(R.id.ivimagen);
            this.clasi=itemView.findViewById(R.id.ivclasi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @ Override
                public void onClick (View view) {
                //getAdapterPosition devuelve la posición del view en el adaptador
                    int posPulsada=getAdapterPosition();
                    setSelectedPos(posPulsada);

                    //If-Else para que al pulsar se cambie el tvfilm de arriba
                    if(selectedPos > RecyclerView.NO_POSITION){
                        MainActivity mainActivity = (MainActivity) view.getContext();
                        TextView tvfilm = mainActivity.findViewById(R.id.tvfilm);
                        tvfilm.setText(peliculas.get(selectedPos).getTitulo());

                    } else {
                        MainActivity mainActivity = (MainActivity) view.getContext();
                        TextView tvfilm = mainActivity.findViewById(R.id.tvfilm);
                        tvfilm.setText(" ");
                    }
                }
            } );

        }

        public TextView getTitulo() {
            return titulo;
        }

        public void setTitulo(TextView titulo) {
            this.titulo = titulo;
        }

        public TextView getDirector() {
            return director;
        }

        public void setDirector(TextView director) {
            this.director = director;
        }

        public ImageView getPortada() {
            return portada;
        }

        public void setPortada(ImageView portada) {
            this.portada = portada;
        }

        public ImageView getClasi() {
            return clasi;
        }

        public void setClasi(ImageView clasi) {
            this.clasi = clasi;
        }


    }
}
