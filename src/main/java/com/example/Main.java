package com.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Login(args);
        billingRecord(args);
        // Falta enlazar los metodos
    }

    // INICIO DEL METODO DEL LOGIN
    public static void Login(String[] args) {

        // Creacion del scanner
        Scanner sc = new Scanner(System.in);

        // Creo las credenciales
        String userPredetermination = "CESDE";
        String passwordPredetermination = "1230";

        // Uso del bucle while para solicitar credenciales hasta que sean correctas
        while (true) {

            // Solicito al usuario que ingrese credenciales

            System.out.println("Ingrese usuario :");
            String userName = sc.next(); // lee dato ingresado

            // SOlicito que ingrese la contraseña

            System.out.println("Ingrese la contraseña : ");
            String password = sc.next();

            // Comparamos que las credenciales sea correcta

            // Uso del .equals para comprar entre dos String
            if (userName.equals(userPredetermination) && password.equals(passwordPredetermination)) {
                System.out.println("Bienvenido " + "!");
                break;
                // si son correctas se cierra el programa (OJO ACÁ,Suponiendo aca debe enlazarse
                // a la siguiente )
            } else {
                System.out.println("Credenciales incorrectas, vuelve a intenatar");

            }

        }
        sc.close();
    }
    // FIN DEL LOGIN

    // INICIO DE REGISTRO FACTURAS ( Billing record=Registro de facturas )
    public static void billingRecord(String[] args) {

        // ArrayList donde se almacenaran los datos de billingRecord
        ArrayList<Object> keepRecord = new ArrayList<>();

        // Scanner para almacenar datos
        Scanner bR = new Scanner(System.in); // (bR =billingRecord)

        // Datos a pedir al usuario y la almacenamiento de dicho dato

        // Paso 1
        System.out.println("Ingrese una breve descripción sobre la factura");
        String description = bR.next();
        keepRecord.add(description);

        // Paso 2
        System.out.println("ingrese el valor de la factura");
        Double originalBillValue = bR.nextDouble();
        keepRecord.add(originalBillValue);

        // Paso 3

        // Uso un while para entrar en un bucle para ejecutar el IVA
        while (true) {
            System.out.println("Dese agregar el IVA? Equivale al 19% en el valor de la factura  (si/no)");
            String reponse = bR.next();

            // Condicion para el incremento del IVA o no
            if (reponse.equalsIgnoreCase("si")) {
                originalBillValue *= 1.19;
                break;
            } else if (reponse.equalsIgnoreCase("no")) {
                break;
            }

        }
        // Se guarda nuevamente el valor dependiendo de la respuesta del usuario
        keepRecord.add(originalBillValue);

        // Paso 4
        System.out.println("Digite la fecha de emisicion de la factura separada por (/) ");
        String date = bR.next();
        keepRecord.add(date);

        // paso 5
        System.out.println("Ingrese quien fue el consumidor final ");
        String endConsumer = bR.next();
        keepRecord.add(endConsumer);

        bR.close();
    }
    // FIN DEL billingRecord

    // INICIO DE CONTROL DE GASTOS (expenseControl = control de gastos)
    public static void expenseControl(String[] args) {
        //Creo un arrayList para mantener datos almacenados 
        ArrayList<Object> viewControl = new ArrayList<>();
 

        Scanner expenseControl = new Scanner(System.in);

        // se crea una variable para almacenar un monto inicial
        double saldo;
       

        System.out.println("Ingresa el saldo inicial ");
        saldo = expenseControl.nextDouble();
        viewControl.add(saldo);

        // Creo un bucle while para tener un menú
        while (true) {
            System.out.println("1.Registar Control");
            System.out.println("2.Recargar Saldo");
            System.out.println("3.Salir ");
            System.out.println("Ingrese una de las opciones ");
        
        //Para leer la opcion del usuario
        int option = expenseControl.nextInt();
        
        //Condicional para la opcion tres
        if (option==3) {
            break; //MODIFICAR DEBE LLEVAR AL LOGIN O PANEL DE CONTROL
            
        } 

        //Creacion de un switch para las opciones 1 y 2 
        switch (option) {
            case 1:
                System.out.println("Ingrese un breve descripcion del Gasto : ");
                String description = expenseControl.nextLine();
                viewControl.add(description);
                
                System.out.println("Ingrese el valor del gasto ");
                double value = expenseControl.nextDouble();
                viewControl.add(value);
        
                if (value>saldo) {
                    System.out.println("Fondos insuficientes");
                    
                }else{
                    //Si es menor el saldo ingresado del gasto se descontara del saldo inicial 
                    saldo-=value;
                    //PREGUNTAR SI ES NECESARIO TENER PRESENTE NUEVAMENTE EL ARRAYLIST
                }

                //Mostramos aca mensaje informativo
                System.out.println("Registro guardado exitosamnete");
                System.out.println("Tu saldo restante es de : " + saldo);

                case 2 :
                //LO MISMO PREGUNTAR POR EL ARRAYLIST
                System.out.println("Ingrese monto a recargar : ");
                
                //variable
                double recharge = expenseControl.nextDouble();
                //Suma del saldo ingresado para recargar al saldo inicial 
                saldo +=recharge;

                //Mensaje informativo 
                System.out.println("Saldo recargado correctamente  ");
                System.out.println("Tu nuevo saldo es de : " + saldo);

                break; //OJO EXAMINAR ESTO 



            default:
                System.out.println("Opción no válida");
         //MIRAR ACA TAMBIEN COMO SERA EL FLUJO
        
            }
        


        }
        expenseControl.close();

    }
//FIN DEL EXPENSECONTROL





}