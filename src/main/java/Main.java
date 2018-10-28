import model.Caminhao;
import model.Cliente;
import model.Frete;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    Service service = new Service();
    ArrayList<Frete> fretes =  new ArrayList<>();
    boolean isCombinado =  true;
    int resultado[][] = new int[50][50];
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    final ArrayList<Caminhao> caminhaos = new ArrayList<Caminhao>();
//    String nome = JOptionPane.showInputDialog("Informe o caminho do arquivo");
    FileReader arq = new FileReader("/home/surfista/Downloads/logistica/input.txt");
    BufferedReader lerArq = new BufferedReader(arq);
    List<String> lista = new ArrayList<String>();

    String linha = lerArq.readLine();
    while (linha != null) {
      lista.add(linha);
      linha = lerArq.readLine(); // lê da segunda até a última linha
    }


    String comeco[] = lista.get(0).split(" ");
    int finalCliente = Integer.parseInt(comeco[0]) + 1;

    String comecoCaminhao[] = lista.get(0).split(" ");
    int finalCaminhao = finalCliente + Integer.parseInt(comeco[1]);


    for (int i = 1; i < finalCliente; i++) {
      String dados = lista.get(i);
      String dadosSeparados[] = dados.split(" ");
      clientes.add(new Cliente(Long.valueOf(dadosSeparados[0]), Long.valueOf(dadosSeparados[1])));
    }


    for (int i = finalCliente; i < finalCaminhao; i++) {
      String dados = lista.get(i);
      String dadosSeparados[] = dados.split(" ");
      caminhaos.add(new Caminhao(Long.valueOf(dadosSeparados[0]), Long.valueOf(dadosSeparados[1])));
    }

    Collections.sort(caminhaos);

    Collections.sort(clientes);
    final ArrayList<Integer> combinacoes = new ArrayList<Integer>();


      for(int i=0; i < caminhaos.size();i++) {
        for(int j=0; j < clientes.size(); j++) {
        if(clientes.get(j).getQuantidade() <= caminhaos.get(i).getQuantidade()
                && clientes.get(j).getValor() >= caminhaos.get(i).getValor()) {
          if(isCombinado) {
            fretes.add(new Frete(clientes.get(i), caminhaos.get(i)));
            combinacoes.add(1);
            isCombinado = false;
          }
        } else {
          combinacoes.add(0);
        }
      }
      isCombinado = true;
    }

    service.gravarResultadoArquivo(fretes.size());
    service.listarCombinacoes(combinacoes);
  }


}
