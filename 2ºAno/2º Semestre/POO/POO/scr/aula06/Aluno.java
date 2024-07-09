package aula06;

public class Aluno extends Pessoa {
    private static int nMecIterator = 100;

    private int nMec;
    private Date inscDate;

    public Aluno(String nome, int cc, Date dataNasc, Date inscDate) {
        super(nome, cc, dataNasc);
        this.nMec = nMecIterator++;
        this.inscDate = inscDate;
    }
    public Aluno(String nome, int cc, Date dataNasc) {
        super(nome, cc, dataNasc);
        this.nMec = nMecIterator++;
        this.inscDate = new Date(19, 4, 2020);
    }

    public int getNMec(){ 
        return this.nMec; 
    }

    @Override
    public String toString() {
        return String.format("%s; nMec: %d; inscDate: %s", super.toString(), this.nMec, this.inscDate);
    }
}