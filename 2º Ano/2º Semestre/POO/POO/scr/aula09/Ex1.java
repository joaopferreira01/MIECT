package aula09;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Collections;
import aula06.*;
import aula07.Ex1.*;
//import aula06.Date;
// Este exercício não dão para fazer pq nao editei a classe Data com as merdinhas novas do guião 7!w


public class Ex1 {
    public static void main(String[] agrs){
        a();
        b();
        c();
    }

    public static void a() {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("z");
        c2.add("b");
        c2.add("a");
        c2.add("c");
        System.out.println(c2.indexOf("Chuva"));
        System.out.println(c2);
        System.out.println(c2.indexOf("a"));
        Collections.sort(c2);
        System.out.println(c2.indexOf("a"));
        System.out.println(c2);
        c2.remove("z");
        c2.remove(0);
        System.out.println(c2);
    }


    public static void b(){
        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("João", 123465789, new aula06.Date(10,1,2002)));
        c3.add(new Pessoa("Pedro", 123465789, new aula06.Date(15,5,2005)));
        c3.add(new Pessoa("Maria", 135791113, new aula06.Date(20,7,2011)));
        c3.add(new Pessoa("Rafael", 246810121, new aula06.Date(25,3,1974)));
        c3.add(new Pessoa("Afonso", 101010101, new aula06.Date(30,9,2015)));

        for(Pessoa pessoa : c3){
            System.out.println(pessoa);
        }
    }
    public static void c(){
        //Set<Date> c4 = new TreeSet<>();

    }
}
