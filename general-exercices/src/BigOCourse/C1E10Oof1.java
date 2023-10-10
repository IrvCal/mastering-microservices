package BigOCourse;

public class C1E10Oof1 {
    //This is the case which we should address with, all of our methods
    public static void main(String[] args) {
        /*
        Aqui no importa el parametro de entrada si es que solo hay una
        operacion por ejemplo en el siguiente metodo no importa si
        el arguemnto es 1 o 999999 millones siempre sera
            O(1)
         */
        sum(10);
    }

    private static int sum(int i) {
        return i+i;
    }
}
