package aula08.Ex1;

public abstract class Veiculo implements KmPercorridosInterface{
    
    private String matricula, marca, modelo;
    private int potencia, quilometros_percorridos, ultimo_trajeto, id;

    public Veiculo(String matricula, String marca, String modelo, int potencia){
        this.setMatricula(matricula);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPotencia(potencia);
    }

    public void trajeto(int quilometros){
        if(quilometros >= 0){
            this.ultimo_trajeto = quilometros;
            this.quilometros_percorridos += quilometros;
        }
    }

    public int getId() {
        return this.id;
    }

    public int ultimoTrajeto(){
        return this.ultimo_trajeto;
    }

    public int distanciaTotal(){
        return quilometros_percorridos;
    }

    public String getMatricula(){
        return this.matricula;
    }
    
    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getPotencia(){
        return this.potencia;
    }

    public void setMatricula(String matricula){
        if (matricula != null && !matricula.equals("") && matricula.length()==8 && matricula.charAt(2)=='-' && matricula.charAt(5)=='-') {
            this.matricula = matricula;    
        }
    }

    public void setMarca(String marca){
        if(marca != null && marca.equals("")){
            this.marca = marca;
        }
    }

    public void setModelo(String modelo){
        if(modelo != null && modelo.equals("")){
            this.modelo = modelo;
        }
    }

    public void setPotencia(int potencia){
        if(potencia >= 0){
            this.potencia = potencia;
        }
    }
    
}
