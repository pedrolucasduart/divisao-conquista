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

    public static boolean melhorQue(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return a[0] > b[0];
        }
        if (a[1] != b[1]) {
            return a[1] < b[1];
        }
        return a[2] < b[2];
    }

    public static int[] resolver(int[] v, int inicio, int fim) {
        if (inicio == fim) {
            int[] r = new int[3];
            r[0] = v[inicio];
            r[1] = inicio;
            r[2] = inicio;
            return r;
        }

        int meio = (inicio + fim) / 2;

        int[] esquerda = resolver(v, inicio, meio);
        int[] direita = resolver(v, meio + 1, fim);
        int[] cruzando = cruzandoMeio(v, inicio, meio, fim);

        int[] melhor = esquerda;
        if (melhorQue(cruzando, melhor)) {
            melhor = cruzando;
        }
        if (melhorQue(direita, melhor)) {
            melhor = direita;
        }
        return melhor;
    }

    public static int[] divisaoConquista(int[] v) {
        return resolver(v, 0, v.length - 1);
    }

    public static int[] kadane(int[] v) {
        int atual = v[0];
        int inicioAtual = 0;
        int melhor = v[0];
        int melhorIni = 0;
        int melhorFim = 0;

        for (int i = 1; i < v.length; i++) {
            if (atual >= 0) {
                atual = atual + v[i];
            } else {
                atual = v[i];
                inicioAtual = i;
            }

            if (atual > melhor) {
                melhor = atual;
                melhorIni = inicioAtual;
                melhorFim = i;
            }
        }

        int[] resultado = new int[3];
        resultado[0] = melhor;
        resultado[1] = melhorIni;
        resultado[2] = melhorFim;
        return resultado;
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = teclado.nextInt();
        }

        String algoritmo = "dc";
        if (args.length > 0) {
            algoritmo = args[0];
        }

        int[] r;
        if (algoritmo.equals("forca-bruta")) {
            r = forcaBruta(v);
        } else if (algoritmo.equals("kadane")) {
            r = kadane(v);
        } else {
            r = divisaoConquista(v);
        }
        System.out.println(r[0] + " " + r[1] + " " + r[2]);
    }

}