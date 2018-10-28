import model.Caminhao;
import model.Cliente;
import model.Frete;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {

    Service service = new Service();
    ArrayList<Frete> fretes =  new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    final ArrayList<Caminhao> caminhaos = new ArrayList<Caminhao>();
    String nome = JOptionPane.showInputDialog("Informe o caminho do arquivo");
    FileReader arq = new FileReader(nome);
    BufferedReader lerArq = new BufferedReader(arq);
    List<String> lista = new ArrayList<String>();

    String linha = lerArq.readLine();
    while (linha != null) {
      lista.add(linha);
      linha = lerArq.readLine();
    }

    String comeco[] = lista.get(0).split(" ");
    int finalCliente = Integer.parseInt(comeco[0]) + 1;

    String comecoCaminhao[] = lista.get(0).split(" ");
    int finalCaminhao = finalCliente + Integer.parseInt(comeco[1]);


    try {
      for (int i = 1; i < finalCliente; i++) {
        String dados = lista.get(i);
        String dadosSeparados[] = dados.split(" ");
        clientes.add(new Cliente(Long.valueOf(dadosSeparados[0]), Long.valueOf(dadosSeparados[1])));
      }
    } catch (Exception e) {
      throw new Exception("Os dados de clientes não são compativeis");
    }

    try {
      for (int i = finalCliente; i < finalCaminhao; i++) {
        String dados = lista.get(i);
        String dadosSeparados[] = dados.split(" ");
        caminhaos.add(new Caminhao(Long.valueOf(dadosSeparados[0]), Long.valueOf(dadosSeparados[1])));
      }
    } catch(Exception e ) {
      throw new Exception("Os dados de caminhões não são compativeis");
    }

    Collections.sort(caminhaos);
    Collections.sort(clientes);

    fretes = service.combinacoesFrete(caminhaos,clientes);
    service.gravarResultadoArquivo(fretes.size());
  }

}
