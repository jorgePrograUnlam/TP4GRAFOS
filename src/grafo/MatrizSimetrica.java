package grafo;

public class MatrizSimetrica {

    private boolean[] v;
    private int       N;
    private int       T;

    public MatrizSimetrica(int N) {
        this.N = N;
        this.T = (N * (N - 1)) / 2;
        this.v = new boolean[T];

        for (int i = 0; i < v.length; i++) {
            v[i] = false;
        }
    }

    public int getTam() {
        return T;
    }

    public boolean getIJ(int F, int C) {
        if (F == C)
            return false;
        int I;
        if (F > C)
            I = C * N + F - (C * C + 3 * C + 2) / 2;
        else
            I = F * N + C - (F * F + 3 * F + 2) / 2;
        return v[I];
    }

    public void setIJ(int F, int C, boolean valor) {
        if (F == C)
            return;
        int I;
        if (F > C)
            I = C * N + F - (C * C + 3 * C + 2) / 2;
        else
            I = F * N + C - (F * F + 3 * F + 2) / 2;
        v[I] = valor;
    }

    public void mostrar() {
        System.out.printf("%4s", "_____");
        for (int i = 0; i < N; i++) {
            System.out.printf("%4s", "______");
        }
        System.out.println();

        System.out.printf("%4s", "");
        for (int i = 0; i < N; i++) {
            System.out.printf("|%5d", i);
        }
        System.out.println("|");

        for (int i = 0; i < N; i++) {
            System.out.printf("%4d", i);
            for (int j = 0; j < N; j++) {
                if (i == j)
                    System.out.printf("|%5s", "-----");
                else
                    System.out.printf("|%5s", (getIJ(i, j) ? "true" : ""));
            }
            System.out.println("|");
        }
    }
}
