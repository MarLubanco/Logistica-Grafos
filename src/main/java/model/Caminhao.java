package model;

public class Caminhao implements Comparable<Caminhao>{

  private Long quantidade;

  private Long valor;

  public  Caminhao() {

  }

  public Caminhao(Long quantidade, Long valor) {
    this.quantidade = quantidade;
    this.valor = valor;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

  public Long getValor() {
    return valor;
  }

  public void setValor(Long valor) {
    this.valor = valor;
  }

  public int compareTo(Caminhao caminhao) {
    if(this.quantidade > caminhao.getQuantidade()) {
        return 1;
    } else {
      return  -1;
    }
  }
}
