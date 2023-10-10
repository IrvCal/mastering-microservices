package BigOCourse;

public class C1E9DropNonDominants {
    public static void main(String[] args) {

        /*
          Ejemplo de un metodo O(n)
         */
        for (int j = 0; j < 4; j++) {
            System.out.println("j: " + j);
        }

        /*
          Ejemplo de un metodo O(n^2)
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("i: " + i + ", j: " + j);
            }
        }
        /*
        Si en un metodo se tiene esto de la siguiente manera
         */
        methodNestedIsolateFor();

    }

    private static void methodNestedIsolateFor() {
        /*
        Basado en la definicion de cada for esto se vuelve en
         O(n^2 + n)

         Al ser la parte que mas absorbe n^2 la segunda parte termina
         siendo poco reelevante por lo que termina siendo por
         SIMPLIFICACION
             O(n^2)
         */

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("i: " + i + ", j: " + j);
            }
        }
        for (int j = 0; j < 4; j++) {
            System.out.println("j: " + j);
        }

    }
}
