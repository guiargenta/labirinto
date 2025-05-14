import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Labirinto lab = new Labirinto();

        try {
            lab.criaLabirinto("labirinto.txt");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        lab.imprimeLabirinto();

        lab.percorreLabirinto();

    }
}
