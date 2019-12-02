package desafio;

import java.util.Arrays;
import java.util.Random;

public class DesafioMatriz {

    static int m1[], m2[], result[];
    static int m, t, r, l, i;

    public static void main(String args[]) throws InterruptedException {
        if (args.length > 1) initParametros(args[0], args[1]);
        else initParametros("100", "4");
        l = calcLinhas();
        r = resto();
        m1 = new int[m * m];
        m2 = new int[m * m];
        result = new int[m * m];
        geraMatriz(m1, m);
        printMatriz(m1, m);
        System.out.print("\n");
        geraMatriz(m2, m);
        printMatriz(m2, m);

        MultMatriz threadzeras[] = new MultMatriz[t];

        for (i = 0; i < t; i++) {
            threadzeras[i] = new MultMatriz(m1, m2, result, m, t, r, l);
        }

        for (i = 0; i < t; i++) {
            threadzeras[i].start();
        }

        for (i = 0; i < t; i++) {
            threadzeras[i].join();
        }
        System.out.println("\n");
        printMatriz(result, m);
    }

    public static void geraMatriz(int matrix[], int m) {
        Random gerador = new Random(System.currentTimeMillis() * Arrays.hashCode(matrix));
        int i, j;
        i = j = 0;
        while (i < m) {
            matrix[(i * m) + j] = gerador.nextInt(6);
            j++;
            if (j == m) {
                i++;
                j = 0;
            }
        }
    }

    public static void geraResult() {
        int i, j;
        i = j = 0;
        while (i < m) {
            result[(i * m) + j] = 0;
            j++;
            if (j == m) {
                i++;
                j = 0;
            }
        }
    }

    public static void printMatriz(int matrix[], int m) {
        int i, j;
        i = j = 0;
        while (i < m) {
            System.out.printf("%2d ", matrix[(i * m) + j]);
            j++;
            if (j == m) {
                j = 0;
                i++;
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }

    public static void initParametros(String tam, String threads) {
        m = Integer.parseInt(tam);
        t = Integer.parseInt(threads);
        if (t > m) t = m;
    }

    public static int calcLinhas() {
        return m / t;
    }

    public static int resto() {
        return m % t;
    }

}
