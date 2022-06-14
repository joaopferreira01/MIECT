package aula07;

import java.util.Scanner;

public class Ex1 {
	public static final Scanner sc = new Scanner(System.in);
    public static final String cores[] = {"Vermelho","Laranja","Amarelo","Verde","Azul"};

	public static void main(String[] args) {
        int counter = 0;

        loop: while(true){
            System.out.println("\nFiguras Geométricas");
            System.out.println("1 - Círculos");
            System.out.println("2 - Retângulos");
            System.out.println("3 - Triângulo");
            System.out.println("0 - Sair\n");

            int input = sc.nextInt();
            System.out.println();

            switch (input) {
                case 1:
                    Circulo c1[] = new Circulo[5]; 
                    for (int i = 0; i < c1.length; i++) {
                        c1[i] = new Circulo(Math.floor(Math.random() * 20), cores[(int)Math.round(Math.random()*4)]); 
                        if(c1[i].getRadius() == 0){
                            i--;
                        }
                    }
                    for (int i = 0; i < c1.length; i++) {
                        System.out.printf(c1[i] + " \tÁrea: %7.2f \tPerímetro: %6.2f \tCor: %s\n",c1[i].area(),c1[i].perimetro(),c1[i].getCor()); 
                    }
                    counter = 0;
                    for (int i = 0; i < c1.length; i++) {
                        for (int j = i+1; j < c1.length; j++) {
                            if(c1[j].equals(c1[i])) { // compare circles
                                counter++;
                            }
                        }
                    }
                    System.out.println("\nExistem " + counter + " círculos iguais!\n");
                    break;
                case 2:
                    Retangulo r[] = new Retangulo[5];
                    for(int i = 0; i < r.length; i++){
                        r[i] = new Retangulo(Math.floor(Math.random() * 9 + 1),Math.floor(Math.random() * 9 + 1),cores[(int)Math.round(Math.random()*4)]);
                        if(r[i].getAltura() == 0 || r[i].getComprimento() == 0){
                            i--;
                        }
                    }
                    for(int i = 0; i < r.length; i++){
                        System.out.println(r[i] + " Área: " + r[i].area() + " Perímetro: " + r[i].perimetro() + " Cor: "+ r[i].getCor());
                    }
                    counter = 0;
                    for(int i = 0; i < r.length; i++){ //1 2 3
                        for(int j = i+1; j < r.length; j++){// 1 2 3   1 2 3  1 2 3 
                            if(r[i].equals(r[j])){
                                counter++;
                            }
                        }
                    }
                    System.out.println("\nExistem "+ counter +" retângulos iguais\n\n");
                    break;
                case 3:
                    Triangulo t[] = new Triangulo[5];
                    for (int i = 0; i < t.length; i++) {
                        t[i] = new Triangulo(Math.floor(Math.random() * 9 + 1) , Math.floor(Math.random() * 9 + 1), Math.floor(Math.random() * 9+ 1),cores[(int)Math.round(Math.random()*4)]); 
                        if(t[i].getLado1() == 0 || t[i].getLado2() == 0 || t[i].getLado3() == 0){
                            i--;
                        }
                    }
            
                    for (int i = 0; i < t.length; i++) {
                        System.out.printf(t[i] + " \tArea: %5.2f \tPerimeter: %5.2f \tCor: %s \n", t[i].area(), t[i].perimetro(),t[i].getCor()); 
                    }
                    counter = 0;
                    for (int i = 0; i < t.length; i++) {
                        for (int j = i+1; j < t.length; j++) {
                            if(t[i].equals(t[j])) { 
                                counter++;
                            }
                        }
                    }
                    System.out.println("\nExistem "+ counter +" triângulos iguais!\n\n");  
                    break;
                case 0:
                    break loop;        
            }

        }




       

        
    }
}