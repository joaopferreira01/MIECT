public class Agenda {
    private Tarefa[] tarefas = new Tarefa[1000];

    public void novaTarefa(Tarefa tarefa) {
        for (int i = 0; i < tarefas.length; i++) {
            if(tarefas[i]==null){
                tarefas[i] = tarefa;
                break;
            }
            if(tarefas[i].inicio().compareTo(tarefa.inicio())>0) {
                Tarefa next = tarefa;
                for (int j = i; j < tarefas.length; j++) {
                    Tarefa old = tarefas[j];
                    tarefas[j] = next;
                    next = old;
                    if(next==null) break;
                }
                break;
            }
        }
    }

    public void escreve() {
        System.out.println("Agenda:");
        for (int i = 0; i < tarefas.length; i++) {
            if(tarefas[i]==null) break;
            System.out.printf("%s\n", tarefas[i]);
        }
    }

    public Agenda filtra(Data a, Data b) {
        Agenda filtrada = new Agenda();
        for (int i = 0; i < tarefas.length; i++) {
            if(tarefas[i]==null) break;
            Tarefa test = new Tarefa(a,b,"test");
            if(tarefas[i].intersecta(test)){
                filtrada.novaTarefa(tarefas[i]);
            }
        }
        return filtrada;
    }
}