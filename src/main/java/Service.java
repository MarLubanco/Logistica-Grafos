import model.Caminhao;
import model.Cliente;
import model.Frete;

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

  public ArrayList<Frete> combinacoesFrete(ArrayList<Caminhao> caminhaos, ArrayList<Cliente> clientes) throws Exception {
    boolean isCombinado =  true;
    ArrayList<Frete> fretes =  new ArrayList<>();
    for(int i=0; i < caminhaos.size();i++) {
      try {
        for (int j = 0; j < clientes.size(); j++) {
          if (clientes.get(j).getQuantidade() <= caminhaos.get(i).getQuantidade()
                  && clientes.get(j).getValor() >= caminhaos.get(i).getValor()) {
            if (isCombinado) {
              fretes.add(new Frete(clientes.get(i), caminhaos.get(i)));
              isCombinado = false;
            }
          } else {
          }
        }
        isCombinado = true;
      } catch (Exception e) {
        throw new Exception("Existe mais caminhoes que clientes, mas todas as combinações foram feitas.");
      }
    }
    return fretes;
  }

}
