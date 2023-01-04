package org.olmedo.optional.ejemplo;

import org.olmedo.optional.ejemplo.models.Computadora;
import org.olmedo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.olmedo.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computadora> repositorio = new ComputadorRepositorio();

        //Computadora defecto = new Computadora("HP Omen", "LA0001");

        //esta es sin expresion lambda
        Computadora pc = repositorio.filtrar("rog").orElse(valorDefecto());
        System.out.println(pc);

        //esta es con expresion lambda
        pc = repositorio.filtrar("macbook pro").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println(pc);

    }

    public static Computadora valorDefecto(){
        System.out.println("Obtiene valor por defecto!!!");
        return new Computadora("HP Omen", "LA0001");
    }
}
