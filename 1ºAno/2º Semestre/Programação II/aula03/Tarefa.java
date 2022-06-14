public class Tarefa {
    private Data inicio, fim;
    private String texto = "";

    public Tarefa(Data inicio, Data fim, String texto) {
        this.inicio = inicio;
        this.fim = fim;
        this.texto = texto;
    }

    public String toString() {
        return String.format("%s --- %s: %s", inicio, fim, texto);
    }

    public boolean intersecta(Tarefa a) {
        if ((inicio.compareTo(a.inicio()) >= 0 && inicio.compareTo(a.fim()) <= 0)
                || (fim.compareTo(a.inicio()) >= 0 && fim.compareTo(a.fim()) <= 0)) {
            return true;
        }
        return false;
    }

    public Data inicio() {
        return inicio;
    };

    public Data fim() {
        return fim;
    };

    public String texto() {
        return texto;
    };
}
