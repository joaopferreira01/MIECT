public class Contacto {
  private String nome;
  private String telefone;
  private String email;

  public Contacto(String nome, String telefone) {
    this.nome = nome;
    this.telefone = telefone;
  }

  public Contacto(String nome, String telefone, String email) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
  }

  public String nome() {
    return this.nome.toUpperCase();
  }

  public String telefone() {
    return this.telefone;
  }

  public String eMail() {
    return this.email;
  }
}
