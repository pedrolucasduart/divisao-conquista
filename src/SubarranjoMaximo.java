import java.util.Scanner;

public class SubarranjoMaximo {

    public static int[] forcaBruta(int[] v) {
        int melhorSoma = v[0];
        int melhorIni = 0;
        int melhorFim = 0;

        for (int i = 0; i < v.length; i++) {
            int soma = 0;
            for (int j = i; j < v.length; j++) {
                soma = soma + v[j];
                if (soma > melhorSoma) {
                    melhorSoma = soma;
                    melhorIni = i;
                    melhorFim = j;
                }
            }
        }

        int[] resultado = new int[3];
        resultado[0] = melhorSoma;
        resultado[1] = melhorIni;
        resultado[2] = melhorFim;
        return resultado;
    }

    public static int[] cruzandoMeio(int[] v, int inicio, int meio, int fim) {

        int soma = 0;
        int melhorEsq = v[meio];
        int posIni = meio;
        for (int i = meio; i >= inicio; i--) {
            soma = soma + v[i];
            if (soma >= melhorEsq) {
                melhorEsq = soma;
                posIni = i;
            }
        }

        soma = 0;
        int melhorDir = v[meio + 1];
        int posFim = meio + 1;
        for (int j = meio + 1; j <= fim; j++) {
            soma = soma + v[j];
            if (soma > melhorDir) {
                melhorDir = soma;
                posFim = j;
            }
        }

        int[] resultado = new int[3];
        resultado[0] = melhorEsq + melhorDir;
        resultado[1] = posIni;
        resultado[2] = posFim;
        return resultado;
    }


    public static void main(String[] args) {
        int[] v = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] r = cruzandoMeio(v, 0, 4, 8);
        System.out.println(r[0] + " " + r[1] + " " + r[2]);

        int[] w = {5, -1, -1, 5};
        int[] r2 = cruzandoMeio(w, 0, 1, 3);
        System.out.println(r2[0] + " " + r2[1] + " " + r2[2]);
    }
}