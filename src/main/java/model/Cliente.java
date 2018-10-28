package model;

import com.sun.security.ntlm.Client;

public class Cliente implements Comparable<Cliente> {

  private Long quantidade;

  private Long valor;

  public Cliente() {

  }

  public Cliente(Long quantidade, Long valor) {
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

  public int compareTo(Cliente cliente) {
    if(this.quantidade > cliente.getQuantidade()) {
      return 1;
    } else {
      return  -1;
    }
  }
}
