package aula06;

public class Bolseiro extends Aluno {
    private int bolsa;

    public Bolseiro(String nome, int cc, Date dataNasc, int bolsa) {
        super(nome, cc, dataNasc);
        this.bolsa = bolsa;
    }

    public void setBolsa(int bolsa){ 
        this.bolsa = bolsa; 
    }
    public int getBolsa(){ 
        return this.bolsa;
    }

    public String toString() {
        return String.format("%s; Bolsa: %d", super.toString(), this.bolsa);
    }
}