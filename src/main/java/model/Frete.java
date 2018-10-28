package model;

public class Frete {

  private Cliente cliente;

  private Caminhao caminhao;

  public Frete() {

  }

  public Frete(Cliente cliente, Caminhao caminhao) {
    this.cliente = cliente;
    this.caminhao = caminhao;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Caminhao getCaminhao() {
    return caminhao;
  }

  public void setCaminhao(Caminhao caminhao) {
    this.caminhao = caminhao;
  }
}
