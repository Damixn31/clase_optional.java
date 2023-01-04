package org.olmedo.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        String nombre = "Damian";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent()); // nos dice si esta presente o no true o false
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get()); // el metodo get siempre es conveniente usarlo con alguna validacion como un if
        }

        System.out.println(opt.isEmpty());

        opt.ifPresent(valor -> System.out.println("Hola " + valor));

        nombre = "Jonh";
        opt = Optional.ofNullable(nombre); // de esta forma evitamos el nullPointerException
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        //opt.ifPresent(valor -> System.out.println("Hola " + valor));
        opt.ifPresentOrElse(valor -> System.out.println("Hola " + valor),
                () -> System.out.println("No esta presente")
        );

        // esto es lo mismo que arriba ero arriba es uina manera mas limpia com expresion lambda
        if(opt.isPresent()){
            System.out.println("Hola " + opt.get()); // el metodo get siempre es conveniente usarlo con alguna validacion como un if
        }else {
            System.out.println("No esta presente");
        }

        //crear un optional vacio
        Optional<String> optEmpty = Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());
    }
}
