import static java.lang.System.*;

import java.util.Arrays;

public class Fibonacci {
  public static int fibArray[] = new int[10];
  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }

    // Alguns testes:
    assert fibonacci(0) == 0;
    assert fibonacci(1) == 1;
    assert fibonacci(2) == 1;
    assert fibonacci(5) == 5;

    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f = fibonacci(n);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
    }
  }
  public static int fibonacci(int n){
    if(n==0||n==1) return n;
    try {
      if(fibArray[n] != -1){
        return fibArray[n];
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      fibArray = Arrays.copyOf(fibArray, n+1);
    }
    fibArray[n] = fibonacci(n-2)+fibonacci(n-1);
    return fibArray[n];
  }
/* RESPOSTA DA alinea a :

  public static int fibonacci(int n) {
    assert n >= 0;
    if(n==0){
      return 0;
    }else if(n==1){
      return 1;
    }else{
      return fibonacci(n-2)+fibonacci(n-1);
    }
  }
  */

}
