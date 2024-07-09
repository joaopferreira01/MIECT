

public class DatasPassadas {

  public static void main(String[] args) {
    Data atual = new Data();
    Data natal = new Data(25,12,2020);

    while(atual.dia() != natal.dia() || atual.mes() != natal.mes() ||atual.ano() != natal.ano()){
      natal.seguinte();
      System.out.println(natal.extenso());
    }
    
  }

}
 