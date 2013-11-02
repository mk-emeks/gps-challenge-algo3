package fiuba.algo3.ejemplo1;

import java.util.ArrayList;

public class PruebaPablo {

    private static Persona ezequiel;
    private static Persona eduardo;
    private static Persona mirko;

    private static ArrayList<Persona> personas;

    public static void main(String args[]) {

        ezequiel = new Eze();
        eduardo = new Edu();
        mirko = new Mirko();

        personas = new ArrayList<Persona>();

        personas.add(ezequiel);
        personas.add(eduardo);
        personas.add(mirko);

        System.out.println("Ejemplo de programacion contra interfaces:");
        System.out.println("=========================================");

        for (Persona persona : personas) {
            System.out.println("NOMBRE: " + persona.devolverMiNombre());
        }

    }
}
