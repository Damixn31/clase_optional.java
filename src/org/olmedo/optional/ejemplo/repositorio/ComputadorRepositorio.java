package org.olmedo.optional.ejemplo.repositorio;

import org.olmedo.optional.ejemplo.models.Computadora;
import org.olmedo.optional.ejemplo.models.Fabricante;
import org.olmedo.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computadora> {
    private List<Computadora> dataSource;
    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("I9-9880H", new Fabricante("Intel"));
        Computadora asus = new Computadora("Asus ROG", "Strix G512");

        asus.setProcesador(proc);
        dataSource.add(asus);
        dataSource.add(new Computadora("Macbook Pro", "Mk1231"));
    }

    @Override
    public Optional<Computadora> filtrar(String nombre) {
        //seria lo mismo de abajo pero mas optimizado
        return dataSource.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())) // esta parte del codigo es buena cuando queremos buscar mas exacto por nombre 
                .findFirst();
        /*for(Computadora c: dataSource){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(c);
            }
        }
        return Optional.empty();*/
    }
}
