import java.util.Scanner;

public class EjerciciosRecursividad {
    public static void main(String[]args){
         ImpresionDigitosRecursivall();
         ImpresionCadenaRecursivall();
         FactorialRecursivoll();
    
          
    }
    
    
    public static void ImpresionDigitosRecursivall(){
     Scanner leer= new Scanner (System.in);
          
          String n;
          
         
          //String x="82952895285385284";
          
          System.out.println("Ingrese su numero entero");
            n= leer.nextLine();
          // String x=Long.toString(n);
          ImpresionDigitosRecursiva(n);
          
          
}
    
    public static void ImpresionCadenaRecursivall(){
        Scanner leer= new Scanner (System.in);
        String c;
        
        System.out.println("Ingrese su cadena de caracteres");
            c= leer.nextLine();
            ImpresionCadenaRecursiva(c);
    }
    
    public static void ImpresionDigitosRecursiva(String n){
        if(n.length()==1){
            System.out.println(n);
        }else{
            ImpresionDigitosRecursiva(n.substring(0,n.length()-1));
            System.out.println(n.charAt(n.length()-1));
        }
    }
    
     public static void ImpresionCadenaRecursiva(String n){
        if(n.length()==1){
            System.out.println(n);
        }else{
            ImpresionCadenaRecursiva(n.substring(0,n.length()-1));
            System.out.println(n.charAt(n.length()-1));
        }
    }
     
     public static long FactorialRecursivo(long n){
         if(n <= 1){
             return 1;
         }
         return n * FactorialRecursivo(n - 1);
         
         
     }
    
    public static void FactorialRecursivoll(){
         Scanner leer= new Scanner (System.in);
          long n;
         System.out.println("Ingrese su numero entero");
            n= leer.nextLong();
         // FactorialRecursivo(n);
          
          System.out.println(EjerciciosRecursividad.FactorialRecursivo(n));
    }
    
}
