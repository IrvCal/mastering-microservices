package BigOCourse;

public class C1E12AplusB {
    public static void main(String[] args) {
        int a = 5; // Replace with your desired value for 'a'
        int b = 3; // Replace with your desired value for 'b'

        for (int i = 0; i < a; i++) {
            // This loop iterates 'a' times
            for (int j = 0; j < b; j++) {
                // This loop iterates 'b' times
                System.out.println("Iteration: i = " + i + ", j = " + j);
            }
        }
        /*
        In this example, we have two nested loops.
        The outer loop iterates 'a' times, and the inner loop iterates 'b' times.
        This results in a total of 'a * b' iterations, which represents O(a + b)
        in terms of time complexity.
         */
    }
}
