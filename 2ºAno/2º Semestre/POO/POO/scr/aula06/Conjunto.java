package aula06;

public class Conjunto {

    private int size;
    private int[] lista;

    public Conjunto(){
        this.size = 0;
        this.lista = new int[10];
    }

    public void insert(int n){
        if(!contains(n)){
            this.lista[this.size++] = n;
        }
    }

    public boolean contains(int n){
        for(int i = 0; i < this.size;i++){
            if(this.lista[i] == n){
                return true;
            }
        }
        return false;
    }

    public void remove(int n){
        int i;
        for(i = 0; i < this.size; i++){
            if(this.lista[i] == n){
                this.size--;
                for(int j = i; j < this.size; j++){
                    this.lista[j] = this.lista[j+1];
                }
            }
        }
    }

    public void empty(){
        for(int i = 0; i < this.size; i++){
            this.lista[i] = 0;
        }
    }

    public String toString(){
        String texto = "";
        for(int i = 0; i < this.size; i++){
            texto += this.lista[i]+ " ";
        }
        return texto;
    }

    public int size(){
        return this.size;
    }

    public int getElement(int i) {
        assert this.size > i;
        return this.lista[i];
    }

    public Conjunto combine(Conjunto add){
        Conjunto novo = new Conjunto();
        for (int i = 0; i < this.size; i++) {
            novo.insert(this.lista[i]);
        }
        for (int i = 0; i < add.size(); i++) {
            novo.insert(add.getElement(i));
        }
        return novo;
    }

    public Conjunto subtract(Conjunto dif){
        Conjunto novo = new Conjunto();
        for(int i = 0; i < this.size; i++){
            novo.insert(this.lista[i]);
        }
        for(int i = 0; i < dif.size(); i++){
            novo.remove(dif.getElement(i));
        }
        return novo;
    }

    public Conjunto intersect(Conjunto inter){
        Conjunto novo = new Conjunto();
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < inter.size(); j++){
                if(this.lista[i] == inter.getElement(j)){
                    novo.insert(this.lista[i]);
                }
            }
        }



        return novo;
    }

    
}
