

/**
 *
 * @author Fray Alexander Riscanevo Tellez
 * Esta clase nos permite la creacion de tarjetas Tarcine
 * y nos permite su recarga,reservacion,pago de la reserva
 */
public class Tarcine {
    private String nombre="xxxxxxxx";
    private int nIdentificacion;
    public int nTarjeta=0 000000000;
    public int saldo=70000;
    public int saldoReserva;

    public Tarcine(String nombre, int nIdentificacion) {
        this.nombre = nombre;
        this.nIdentificacion = nIdentificacion;
        this.nTarjeta=nIdentificacion;
    }
    public void recargar(){
        this.saldo+=50000;
    }
    public void reservacion(int p,int g){
        this.saldoReserva+=((p*9900)+(g*7200));
    }
    public void pagoReserva(){
        this.saldoReserva=0;
    }
   
    
   
}
