
import java.util.Calendar;

public class Data {
  private int dia, mes, ano;

  /** Inicia esta data com o dia de hoje. */
  public Data() {
    // Aqui usamos a classe Calendar da biblioteca standard para obter a data atual.
    Calendar today = Calendar.getInstance();
    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
  }

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
  }

  // Crie métodos para obter o dia, mes e ano da data.
  public int dia() {
    return this.dia;
  }

  public int mes() {
    return this.mes;
  }

  public int ano() {
    return this.ano;
  }

  /** Dimensões dos meses num ano comum. */
  private static final int[] diasMesComum = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
    if (bissexto(ano)) {
      if (mes == 2) {
        return 29;
      } else {
        return diasMesComum[mes - 1];
      }
    } else {
      return diasMesComum[mes - 1];
    }

  }

  /** Devolve o mes da data por extenso. */
  public static final String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
      "Setembro", "Outubro", "Novembro", "Dezembro" };

  public String mesExtenso() {
    return meses[mes - 1];
  }

  /** Devolve esta data por extenso. */
  public String extenso() {
    return dia + " de " + mesExtenso() + " de " + ano;
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
    if (ano < 0) {
      return false;
    }
    if (dia < 1 || dia > diasDoMes(mes, ano)) {
      return false;
    }
    if (mes < 1 || mes > 12) {
      return false;
    }
    return true;
  }

  public void seguinte() {
    dia++;
    if (dia > diasDoMes(mes, ano)) {
      dia = 1;
      mes++;
    }
    if (mes > 12) {
      mes = 1;
      ano++;
    }
  }

}
