package aula08.Ex1;
import java.util.*;

import java.util.ArrayList;

public class EmpresaAluguer{
    
    private String nome, codigo_postal, email;
    private List<Veiculo> frota = new ArrayList<Veiculo>();

    EmpresaAluguer(String nome, String codigo_postal, String email){
        this.setNome(nome);
        this.setCodigoPostal(codigo_postal);
        this.setEmail(email);
    }

    public void setNome(String nome){
        if(nome.length() > 0){
            this.nome = nome;
        }
    }

    public void setCodigoPostal(String codigo_postal){
        if(codigo_postal.length() > 0){
            this.codigo_postal = codigo_postal;
        }
    }

    public void setEmail(String email){
        if(email.length() > 0){
            this.email = email;
        }
    }

    public String getEmail(){
        return this.email;
    }

    public String getCodigoPostal(){
        return this.codigo_postal;
    }

    public String getNome(){
        return this.nome;
    }   

    public void addVeiculo(Veiculo veiculo){
        frota.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo){
        frota.remove(veiculo);
    }

    public List<Veiculo> getFrota(){
        return this.frota;
    }
    
}
