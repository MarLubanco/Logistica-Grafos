import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Service {

  public void listarCombinacoes(ArrayList dados) {
    dados.stream().forEach(System.out::print);
  }

  public void gravarResultadoArquivo(int valorResultado) throws IOException {
    FileWriter arquivo = new FileWriter("resultado.txt");
    PrintWriter gravarArq = new PrintWriter(arquivo);
    gravarArq.print(valorResultado);
    arquivo.close();
  }

}
