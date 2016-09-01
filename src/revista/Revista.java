
package revista;

import javax.swing.JOptionPane;


public class Revista {


    public static void main(String[] args) {
        
        String genero, estadoCivil, menu;
        int edad, ingresosMesuales, opcion; 
        int menores20=0, menores29=0, menores39=0, menores49=0, mayores50=0;
        int masculino=0, femenino=0, soltero=0, casado=0;
        int m30=0, m49=0, m69=0, M70=0;
        
        do 
        {
            menu=JOptionPane.showInputDialog("=========OPCIONES========= \n" +
                                         "1. Edad \n" +
                                         "2. Género \n" +
                                         "3. Estado Civil \n" +
                                         "4. Ingresos Anuales \n" +
                                         "5. Mostrar resultados \n" + 
                                         "0. Salir");
            
            opcion=Integer.parseInt(menu);
            
            switch(opcion)
            {
                case 1:
                    
                    edad=Integer.parseInt(JOptionPane.showInputDialog("Digite la edad: "));
                    
                    if (edad<=20) 
                    {
                        menores20++;
                    } 
                    
                    if (edad<=29&&edad>20) 
                    {
                        menores29++;
                    } 
                    
                    if (edad<=39&&edad>29) 
                    {
                        menores39++;
                    } 
                    
                    if (edad<=49&&edad>39) 
                    {
                        menores49++;
                    } 
                    
                    if (edad>=50) 
                    {
                        mayores50++;
                    } 
                break;
                case 2:
                    
                    genero=JOptionPane.showInputDialog("Digite el genero: Masculino (M) ó Femenino (F)");
                    
                    if (genero.equals("M")) 
                    {
                        masculino++;
                    } 
                    
                    if (genero.equals("F")) 
                    {
                        femenino++;
                    } 
                    
                break;
                case 3:
                    
                    estadoCivil=JOptionPane.showInputDialog("Escriba su estado civil: Soltero(S) ó Casado(C) ");
                    if (estadoCivil.equals("S")) 
                    {
                        soltero++;
                    }
                    
                    if (estadoCivil.equals("C")) 
                    {
                        casado++;  
                    }
                break;
                case 4:
                    
                    ingresosMesuales=Integer.parseInt(JOptionPane.showInputDialog("Digite los ingresos mensuales: "));
                    
                    if (ingresosMesuales<=30000) 
                    {
                        m30++;
                    } 
                    
                    if (ingresosMesuales<=49000&&ingresosMesuales>30000) 
                    {
                        m49++;
                    } 
                    
                    if (ingresosMesuales<=69000&&ingresosMesuales>49000) 
                    {
                        m69++;
                    } 
                    
                    if (ingresosMesuales>=70000) 
                    {
                        M70++;
                    } 
                break;
                case 5:
                    
                    JOptionPane.showInputDialog("========= EDADES ========= \n" +
                                         "Menores a 20: " + menores20 +  "\n" +
                                         "Menores a 29: " + menores29 +  "\n" +
                                         "Menores a 39: " + menores39 +  "\n" +
                                         "Menores a 49: " + menores49 +  "\n" +
                                         "Mayores a 50: " + mayores50 + "\n" +
                                          "========= GENEROS ========= \n" +
                                         "Hombre: " + masculino +  "\n" +
                                         "Mujeres: " + femenino + "\n" + 
                                         "========= INGRESOS MENSUALES ========= \n" +
                                         "Menores a $30000: " + menores20 +  "\n" +
                                         "Menores a $49000: " + menores29 +  "\n" +
                                         "Menores a $69000: " + menores39 +  "\n" +
                                         "Mayores a $70000: " + menores49 );
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Ese caso no existe!!");
                break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta Luego");
                break;
            }
        } 
        while (opcion!=0);
        
        
        
    }
    
}