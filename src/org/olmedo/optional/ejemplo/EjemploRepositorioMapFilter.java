package org.olmedo.optional.ejemplo;

import org.olmedo.optional.ejemplo.models.Computadora;
import org.olmedo.optional.ejemplo.models.Fabricante;
import org.olmedo.optional.ejemplo.models.Procesador;
import org.olmedo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.olmedo.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadorRepositorio();


        //esta es sin expresion lambda
        // cuando usamos Optional usamos flatmap en ves de map
        String f = repositorio.filtrar("asus")
                .flatMap(Computadora::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido!");

        System.out.println(f);


    }

}
