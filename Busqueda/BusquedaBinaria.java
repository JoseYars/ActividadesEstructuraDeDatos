

public class BusquedaBinaria{

    public static void main(String[] args){

        int[] random = new int[1000];

        for (int i = 0; i< 1000; i++){
                random[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < random.length - 1; i++) {
            for (int j = 0; j < random.length - 1 - i; j++) {
                if (random[j] > random[j + 1]) {
                    int temp = random[j];
                    random[j] = random[j + 1];
                    random[j + 1] = temp;
                }
            }
        }

        for(int num : random){
            System.out.print(",[" + num + "] " );  
        }

        System.out.println("");
        

        int term = 544;

        System.out.println("numero a buscar: " + "[" + term + "]");

        int resultado = BusquedaBinaria2(random, term);


        if(resultado != -1){
            System.out.println("El numero solicitado: " + term + " fue encontrado en la posicion : " + resultado  );
        }else{
            System.out.println(" El numero solicitado: " + term + " no fue encontrado"  );
        }
    }

    public static int BusquedaBinaria2(int[] arr, int term) {
        int inicio = 0;
        int fin = arr.length - 1;
    
        while (inicio <= fin) {
            int centro = inicio + (fin - inicio) / 2;
            System.out.println("centro: " + "[" + centro + "]");

    
            if (arr[centro] == term) {
                return centro;
            }
    
            if (arr[centro] < term) {
                inicio = centro + 1;
            } else {
                fin = centro - 1;
            }
        }
    
        return -1;
    }
}


