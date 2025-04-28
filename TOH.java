// JAVA recursive function to
// solve tower of hanoi puzzle
import java.io.*;
import java.math.*;
import java.util.*;
class TOH {
    static void towerOfHanoi(int n, char from_rod,
                             char to_rod, char aux_rod)
    {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod); // ABC
        System.out.println("Move disk " + n + " from rod "
                           + from_rod + " to rod "
                           + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod); //BCA
    }

    // Driver code
    public static void main(String args[])
    {
        int N = 3;

        // A, B and C are names of rods -> source , destination , helper
        towerOfHanoi(N, 'A', 'C', 'B');
    }
}

