package com.carmen.peliculas;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorInformacion extends RecyclerView.Adapter<AdaptadorInformacion.celdaInformacionjava>{

    List<Pelicula> peliculas;
    Set<String> favoritasKeys;

    public AdaptadorInformacion (List<Pelicula> peliculas, Set<String> favoritasKeys){

        this.peliculas = peliculas;
        this.favoritasKeys = favoritasKeys;

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
    public AdaptadorInformacion.celdaInformacionjava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda= LayoutInflater.from(parent.getContext()).inflate(R.layout.celdainformacion, parent, false);
        AdaptadorInformacion.celdaInformacionjava celdaInformacionjava = new AdaptadorInformacion.celdaInformacionjava(celda);
        return celdaInformacionjava;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorInformacion.celdaInformacionjava holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.portada.setImageResource(pelicula.getPortada());
        holder.clasi.setImageResource(pelicula.getClasi());
        holder.titulo.setText(pelicula.getTitulo());
        holder.director.setText(pelicula.getDirector());
        holder.duracion.setText(String.valueOf(pelicula.getDuracion()));
        holder.sala.setText(pelicula.getSala());
//        holder.sinopsis.setText(pelicula.getSinopsis());
        //holder.fecha.setText(String.valueOf(pelicula.getFecha()));
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        holder.fecha.setText(dateformat.format(pelicula.getFecha())) ;

        if (favoritasKeys != null && favoritasKeys.contains(keyFor(pelicula))) {
            holder.favorita.setVisibility(View.VISIBLE);
        } else {
            holder.favorita.setVisibility(View.GONE);
        }

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

    private String keyFor(Pelicula p) {
        String titulo = p.getTitulo() == null ? "" : p.getTitulo().trim();
        String director = p.getDirector() == null ? "" : p.getDirector().trim();
        return titulo + "|" + director;
    }

    public class celdaInformacionjava extends RecyclerView.ViewHolder {

        TextView titulo, director, duracion, sala, fecha;
        ImageView portada, clasi, favorita;

        public celdaInformacionjava(@NonNull View itemView) {
            super(itemView);
            this.titulo=itemView.findViewById(R.id.tvtitulo2);
            this.director=itemView.findViewById(R.id.tvdirector2);
            this.portada=itemView.findViewById(R.id.ivimagen2);
            this.clasi=itemView.findViewById(R.id.ivclasi2);
            this.duracion=itemView.findViewById(R.id.tvduracion2);
            this.sala=itemView.findViewById(R.id.tvsala2);
            this.fecha=itemView.findViewById(R.id.tvfecha2);
            this.favorita=itemView.findViewById(R.id.ivfav);

            itemView.setOnClickListener(new View.OnClickListener() {
                @ Override
                public void onClick (View view) {
                    //getAdapterPosition devuelve la posición del view en el adaptador
                    int posPulsada=getAdapterPosition();
                    setSelectedPos(posPulsada);

                    //If-Else para que al pulsar se cambie el tvfilm de arriba
                    if(selectedPos > RecyclerView.NO_POSITION){
                        InformacionPeliculas informacionPeliculas = (InformacionPeliculas) view.getContext();
                        Intent intentExtra = new Intent(informacionPeliculas, ExtraActivity.class);
                        intentExtra.putExtra("pos", selectedPos);
                        informacionPeliculas.startActivity(intentExtra);

//                        intentExtra.putExtra("portada", peliculas.get(selectedPos).getPortada());
//                        view.getContext().startActivity(intentExtra);
//
//                        intentExtra.putExtra("sinopsis", peliculas.get(selectedPos).getSinopsis());
//                        view.getContext().startActivity(intentExtra);

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

        public TextView getDuracion() {
            return duracion;
        }

        public void setDuracion(TextView duracion) {
            this.duracion = duracion;
        }

        public TextView getSala() {
            return sala;
        }

        public void setSala(TextView sala) {
            this.sala = sala;
        }

        public TextView getFecha() {
            return fecha;
        }

        public void setFecha(TextView fecha) {
            this.fecha = fecha;
        }
        public ImageView getFavorita() {
            return favorita;
        }

        public void setFavorita(ImageView favorita) {
            this.favorita = favorita;
        }


    }
}
