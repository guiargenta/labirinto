import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {

    private char[][] labirinto;
    private boolean[][] visitado;

    public Labirinto() {
    }

    public Labirinto(char[][] labirinto) {
        this.labirinto = labirinto;
    }

    public void criaLabirinto(String filename) throws IOException {

        List<String> linhas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linha;

            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        int numLinhas = linhas.size();
        int maxColunas = linhas.stream().mapToInt(String::length).max().orElse(0);

        System.out.println("Quantidade de linhas: " + linhas.size());
        System.out.println("Quantidade de colunas: " + maxColunas);

        labirinto = new char[numLinhas][maxColunas];
        visitado = new boolean[numLinhas][maxColunas];

        // Preenche o labirinto
        for (int i = 0; i < numLinhas; i++) {
            String linha = linhas.get(i);
            for (int j = 0; j < maxColunas; j++) {
                labirinto[i][j] = linha.charAt(j);
            }
        }

    }

    public boolean percorreLabirinto() {

        // Verifica se o labirinto foi criado
        if (labirinto == null || labirinto.length == 0 || labirinto[0].length == 0) {
            return false;
        }
        // Inicia a busca recursiva a partir de [0][0]
        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int linha, int coluna) {

        // Verifica se está fora do limite do labirinto
        if (linha < 0 || linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length)
            return false;

        // Verifica se é uma parede ou se já foi visitado
        if (visitado[linha][coluna] || labirinto[linha][coluna] == 'X')
            return false;

        // Verifica se chegou ao Destino
        if (labirinto[linha][coluna] == 'D') {
            System.out.println("O labirinto chegou ao destino! =)");
            return true;
        }

        visitado[linha][coluna] = true;

        // Tenta todas as direções possíveis (cima, baixo, esquerda, direita)
        if (percorreLabirinto(linha - 1, coluna) ||      // cima
                percorreLabirinto(linha + 1, coluna) ||  // baixo
                percorreLabirinto(linha, coluna - 1) || // esquerda
                percorreLabirinto(linha, coluna + 1)) { // direita
            return true;
        }

        // Se nenhuma direção levar ao destino, backtracking
        return false;
    }

    public void imprimeLabirinto() {
        if (labirinto == null)
            System.out.println("Labirinto não criado!");

        for (char[] linha : labirinto) {
            for (char coluna : linha) {
                System.out.print(coluna);
            }
            System.out.println();
        }
    }


}
