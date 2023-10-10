package BigOCourse;

import java.util.ArrayList;
import java.util.List;

public class C1E11OlogN {
    public static void main(String[] args) {
        ArrayList<Integer> nums = (ArrayList<Integer>) List.of(10,2,35,6,43);
        nums.sort(Integer::compareTo);
        /*
        Intente hacer una busqueda mas eficiente que la binaria con algun metodo
        predefinido, no hay, se tendria que hacer otra funcion, y esta bien SOLO
        SI sabes que el dataset no esta ordenado si esta ORDENADO conviene si o si
        una BUSQEUDA BINARIA
         */
    }
}
