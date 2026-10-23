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


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n = teclado.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = teclado.nextInt();
        }

        int[] r = forcaBruta(v);
        System.out.println(r[0] + " " + r[1] + " " + r[2]);
    }

}