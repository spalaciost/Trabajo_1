package revista;


import java.util.Random;


public class Trabajo1 {

    public static void main (String[] args){
          System.out.println("====LOTERIA====");
          Random rn = new Random();
           java.util.Scanner teclado=
              new java.util.Scanner(System.in);
           int s=0;
            int x;
            int random[];
            random= new int[3];
            
	for (int i = 0; i < 3; i++) {
        	x = (int)(rn.nextDouble() * 10.0);
                random[i]=x;
                System.out.println(random[i]);
        }
        
        int w;
        int numeros[];
            numeros= new int[3];
        for (int i = 0; i < 3; i++) {
                System.out.println("escriba su numero ");
        	w = teclado.nextInt();
                numeros[i]=w;
        }
        
        for (int a = 0; a< 3; a++) {
            System.out.println("el usuario a escogido "+numeros[a]+" Y el sistema a escogido "+random[a]);
         }

    if(random[0]==numeros[0]&&random[1]==numeros[1]&&random[2]==numeros[2]){
        System.out.println("FELICITACIONES!!! USTED A GANADO $1'000.000");
    }else{
        for (int a = 0; a< 3; a++) {
        if(random[a]==numeros[0]||random[a]==numeros[1]||random[a]==numeros[2]){
            s++;
        }}
    }
    if(s==1){
    System.out.println("FELICITACIONES!!! USTED A GANADO $10");
    }else{
    if(s==2){
    System.out.println("FELICITACIONES!!! USTED A GANADO $100");
    }else{
    if(s==3){
    System.out.println("FELICITACIONES!!! USTED A GANADO $1000");
    }}}
    
    }}
