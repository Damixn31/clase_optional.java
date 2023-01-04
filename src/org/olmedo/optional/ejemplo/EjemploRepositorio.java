package org.olmedo.optional.ejemplo;

import org.olmedo.optional.ejemplo.models.Computadora;
import org.olmedo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.olmedo.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("asus").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se encontro!"));

       // Optional<Computadora> pc = repositorio.filtrar("asus rog");

        /*if(pc.isPresent()) {
            System.out.println(pc.get());
        } else {
            System.out.println("No se encontro!");
        }*/

    }
}
