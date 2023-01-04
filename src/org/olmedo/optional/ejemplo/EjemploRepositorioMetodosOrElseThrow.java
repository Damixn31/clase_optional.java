package org.olmedo.optional.ejemplo;

import org.olmedo.optional.ejemplo.models.Computadora;
import org.olmedo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.olmedo.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadorRepositorio();

        //esta es sin expresion lambda
        Computadora pc = repositorio.filtrar("rog").orElseThrow(IllegalStateException::new);
        System.out.println(pc);

        String archivo ="Documento.pdf";
        
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);

    }

}
