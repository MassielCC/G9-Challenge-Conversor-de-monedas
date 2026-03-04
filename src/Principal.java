import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        int opcion = 1;
        double monto;
        String base = null;
        String target = null;
        ConversorApp conversor = new ConversorApp();
        Scanner lectura = new Scanner(System.in);
        ExchangeRate exchangeRate;
        while(opcion!=7){
            Conversor.exhibirMenu();
            opcion = lectura.nextInt();
            if (opcion>=1 && opcion<=6){
                System.out.println("Ingrese el valor que desea convertir: ");
                monto = lectura.nextDouble();

                switch (opcion){
                    case 1:
                        base= "USD";
                        target="ARS";
                        break;
                    case 2:
                        base= "ARS";
                        target="USD";
                        break;
                    case 3:
                        base= "USD";
                        target="BRL";
                        break;
                    case 4:
                        base= "BRL";
                        target="USD";
                        break;
                    case 5:
                        base= "USD";
                        target="COP";
                        break;
                    case 6:
                        base= "COP";
                        target="USD";
                        break;
                }
                exchangeRate = conversor.obtenerTasa(base+ "/" + target);
                conversor.mostrarResultado(base, target, monto, exchangeRate.conversion_rate());
            }
            else if(opcion!=7){
                System.out.println("Opción no válida");
            }
            else{
                System.out.println("Fin del programa");
            }
        }
    }
}

