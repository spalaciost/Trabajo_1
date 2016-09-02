

/**
 *
 * @author Fray Alexander Riscanevo Tellez
 * Este proyecto nos permite manejar una sala de cine donde realiza
 * varias funciones que son:
 * El total vendidido
 * Creacion de tarjetas
 * Compra y reservacion de tarjetas(la reservacion es solo permitida alos que tienen la tarjeta)
 * Recarga de tarjetas por un valor maximo de 50000
 * 
 */
import java.util.Scanner;

public class ControlSalaCine {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        Scanner teclados= new Scanner(System.in);
        int total=0;
        //creamos la sala del cine con 11 filas"i" y 20 columnas "j"
        int [][] sala=new int [11][20];
        for(int i=0;i<11;i++){
            for(int j=0;j<20;j++){
                sala[i][j]=0;
            }
        }
        //creamos una funcion que nos permite imprimir la sala:
        ImprimirSala(sala,total,0);
        //esta vector nos permite crear las tarjetas a un maximo de 20
        Tarcine tarjetas[];
        tarjetas = new Tarcine[20];
        int q=0;
        int b=0;
        //creamos menu para realizar 4 diferentes acciones compra,crear tarjeta, recarga,pago de reservas
        while (b<5){
            System.out.println("presion la opcion a ingresa \n1.comprar o reserva de boletas\n2.crear tarjeta\n3.Recargar tarjeta\n4.pagoreserva\n5.finalizar");
            b=teclado.nextInt();
            switch(b){
                //case 1 para la compra o reserva de tarjetas
                case 1:{
                    System.out.println("presiona 1.si eres afiliado");
                    int afiliado=teclado.nextInt();
                    if(afiliado==1){
                        System.out.println("ingrese el numero de su tarjeta");
                        int taTarcine=teclado.nextInt();
                        int j;
                        for(j=0;j<q;j++){
                            if(taTarcine==tarjetas[j].nTarjeta){
                                controlSala(sala,total,1,j,tarjetas);
                                j=q+1;
                            }
                        }
                        if (j<q+1){
                            System.out.println("tarjeta no existente");
                        }
                    }
                    //creamos un funcion del las acciones que puede realizar:
                    else
                        controlSala(sala,total,0,-1,tarjetas);
                break;
                }
                //caso 2 para la creacion de tarjetas
                case 2:{
                    System.out.println("ingrese el nombre del usuario"); 
                    String h=teclados.nextLine();
                    System.out.println("ingrese el numero de cedula");
                    int numeroId=teclado.nextInt();
                    tarjetas[q]= new Tarcine(h, numeroId);
                    System.out.println("El usuario ha sido creado con numero de tarjeta"+numeroId);
                    q++;
                    break;
                }
                //Recarga de tarjetas
                case 3:{
                    System.out.println("ingrese el numero de tarjeta");
                    int taTarcine=teclado.nextInt();
                    int i;
                    for(i=0;i<q;i++){
                        if(taTarcine==tarjetas[i].nTarjeta){
                            tarjetas[i].recargar();
                            System.out.println(tarjetas[i].saldo);
                            i=q+1;
                        }
                    }if (i<q+1){
                        System.out.println("tarjeta no existente");
                    }
                    break;
                }
                //pago de Reservas
                case 4:{
                    System.out.println("ingrese el numero de tarjeta");
                    int taTarcine=teclado.nextInt();
                    int i;
                    for(i=0;i<q;i++){
                        if(taTarcine==tarjetas[i].nTarjeta){
                            System.out.println(tarjetas[i].saldoReserva);
                            tarjetas[i].pagoReserva();
                            i=q;
                        }
                    }if (i<q){
                        System.out.println("tarjeta no existente");
                    }
                }

            }
        }
        
                
    }
    //funcion para controlar las funciones de las sala
    public static void controlSala(int sala[][],int total,int af,int l,Tarcine nt[]){
        Scanner teclado= new Scanner(System.in); 
        int a=0;
        int reservap=0;
        int reservag=0;
        while(a!=3){
            //creamos un menu de acciones:
            System.out.println("ingrese el numero de la opcion que desea ingresar: \n1.comprarBoletas \n2.reservarBoletas\n3.finalizar");
            a=teclado.nextInt();
            switch (a){
                //case 1 para comprar boletas:
                case 1:{
                    int i,j,k;
                    k=1;
                    ////este ciclo nos permite estar en el menu hasta que la comprar se efectue 
                    for(;k==1;){
                        //creamos un menu para las categorias:
                        System.out.println("Categoria\n1.General\n2.Preferencial");
                        int c=teclado.nextInt();
                        //este condicional nos sirve para realizar la compra en la categoria "general"
                        if (c==1){
                            i=teclado.nextInt();
                            j=teclado.nextInt();
                            if(i>=0&&i<9&&j<20){
                                if (sala[i][j]==0){
                                    sala[i][j]=1;
                                    k=0;
                                }else 
                                    System.out.println("silla ocupada");
                            }else
                                System.out.println("Silla no se encuentra en esta categoria");
                        //este condicional nos sirve para realizar la compra en la categoria "prefernecial" 
                        }else if(c==2){
                            i=teclado.nextInt();
                            j=teclado.nextInt();
                            if(i>=9&&i<11&&j<20){
                                if (sala[i][j]==0){
                                    sala[i][j]=2;
                                    k=0;
                                }else 
                                    System.out.println("silla ocupada");
                            }else
                                System.out.println("Silla no se encuentra en esta categoria");
                        }
                    }
                //funcio para imprimir la sala
                ImprimirSala(sala,total,af);
                break;
                }
                //caso 2 para realizar la reserva de boletas
                case 2:{
                    //condiconal nos sirve para restringir la reservacion solo para afiliados
                    if(af==1){
                        int i,j,k;
                        k=1;
                        //este ciclo nos permite estar en el menu hasta que la reserva se efectue 
                        for(;k==1;){
                            //creamos un menu para las diferentes categoria
                            System.out.println("Categoria\n1.General\n2.Preferencial");
                            int c=teclado.nextInt();
                            //condicional para realizar la reserva en la categoria general
                            if (c==1){
                                i=teclado.nextInt();
                                j=teclado.nextInt();
                                if(i>=0&&i<9&&j<20){
                                    if (sala[i][j]==0){
                                        sala[i][j]=3;
                                        k=0;
                                        reservag++;
                                    }else 
                                        System.out.print("silla ocupada");
                                }else
                                    System.out.println("Silla no se encuentra en esta categoria");
                            //condicional nos sirve para realizar la reserva en la categoria preferencial
                            }else if(c==2){
                                i=teclado.nextInt();
                                j=teclado.nextInt();
                                if(i>=9&&i<11&&j<20){
                                    if (sala[i][j]==0){
                                        sala[i][j]=4;
                                        k=0;
                                        reservap++;
                                    }else 
                                        System.out.print("silla ocupada");
                                }else
                                    System.out.println("Silla no se encuentra en esta categoria");
                            }   
                        }
                    }else 
                        System.out.println("no eres afiliado");
                //funcion para imprimir la sala
                ImprimirSala(sala,total,af);
                break;

                }
            }
        //funcion para imprimir la sala
        ImprimirSala(sala,total,af);
        if(af==1){
            nt[l].reservacion(reservap,reservag);
        }
            
        }
     
    }
    //esta funcion nos permite imprimir la sala y llevar el total de dinero 
    public static void ImprimirSala(int sala[][],int total,int af){
        //este condicional nos permite realizar la suma adecuada del total ya que los afiliados 
        //reciben un 10 porciento de descuento
        if(af==0){ 
            for(int j=0;j<11;j++){
                for(int i=0;i<20;i++){
                    if (sala [j][i]==2||sala[j][i]==4){
                        total=+11000;
                    }else if (sala [j][i]==1||sala[j][i]==3){
                        total=+8000;
                    }
                }
            }
        }
        else{
            for(int j=0;j<11;j++){
                for(int i=0;i<20;i++){
                    if (sala [j][i]==2||sala[j][i]==4){
                        total=+9900;
                    }else if (sala [j][i]==1||sala[j][i]==3){
                        total=+7200;
                    }
                }
            }
        }
        for(int j=0;j<11;j++){
            for(int i=0;i<20;i++){
                if (sala [j][i]==1||sala[j][i]==2){
                    System.out.print("2\t");
                }else if(sala[j][i]==3||sala[j][i]==4){
                    System.out.print("1\t");
                }else 
                    System.out.print("0\t");
            }
            System.out.println();
        }
        System.out.println("Total="+total);
    }
    
}
