package aula08.Ex1;



public class PesadoPassageirosEletrico extends AutomovelPesadoPassageiros implements VeiculoEletrico {

    private int autonomia_max, autonomia_restante;
    
    PesadoPassageirosEletrico(String matricula, String marca, String modelo, int potencia, int numero_do_quadro, int peso, int num_max_de_passageiros, int autonomia_max){
        super(matricula, marca, modelo, potencia, numero_do_quadro, peso, num_max_de_passageiros);
        if(autonomia_max > 0){
            this.autonomia_max = autonomia_max;
            this.autonomia_max = autonomia_restante;
        }
    }

    public int getAutonomiaMax(){
        return this.autonomia_max;
    }

    public int getAutonomiaRestante(){
        return this.autonomia_restante;
    }

    public void setAutonomiaRestante(int autonomia){
        this.autonomia_restante = autonomia;
    }

    public int autonomia(){
        return this.autonomia_max;
    }

    public void carregar(int percentagem){
        if(percentagem > 0){
            this.setAutonomiaRestante(this.autonomia_max * percentagem / 100);
        }
    }

    public void descarregar(int quilometros){
        if(quilometros > 0){
            this.setAutonomiaRestante(this.autonomia_restante - quilometros);
        }
    }

    @Override
    public void trajeto(int quilometros){
        if(quilometros > 0){
            super.trajeto(quilometros);
            this.descarregar(quilometros);
        }
    }
    
}
