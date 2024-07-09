package aula06;

public class Pessoa {
    private String nome;
    private int cc;
    private Date dataNasc;

    public Pessoa(String nome, int cc, Date dataNasc){
        assert nome.length() > 0 && cc > 0;
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String getNome(){
        return this.nome;
    }
    public int getCc(){
        return this.cc;
    }
    public String toString() {
        return String.format("%s; CC: %d; Data de Nascimento: %s", this.nome, this.cc, this.dataNasc);
    }
    public boolean equals(Pessoa p){
        if(p.getCc() == this.getCc()){
            return false;
        }
        return false;
    }
}
