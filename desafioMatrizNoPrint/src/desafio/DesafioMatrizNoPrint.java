package desafio;

import java.util.Arrays;
import java.util.Random;

public class DesafioMatrizNoPrint {

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
        geraMatriz(m2, m);

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
