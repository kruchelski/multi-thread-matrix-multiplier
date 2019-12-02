package desafio;

public class MultMatriz extends Thread {
    int[] m1, m2, result;
    int m, threads, r, l;
    public MultMatriz(int[] m1, int[] m2, int[] result, int m, int t, int r, int l) {
        this.m1 = m1;
        this.m2 = m2;
        this.result = result;
        this.m = m;
        this.threads = t;
        this.r = r;
        this.l = l;
    }
    

    private static int t = -1;

    @Override
    public void run() {
        t++;
        int count = t * l;
        int fim = count + l;
        if (t == (threads - 1)) fim += r;
        int i, j;
        i = j = 0;
        while (count < fim) {
            result[(count * m) + i] += m1[(count * m) + j] * m2[(j * m) + i];
            j++;
            if (j == m) {
                i++;
                j = 0;
            }
            if (i == m) {
                i = 0;
                count++;
            }
        }
    }
}
