package com.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Login();
        panelCotrol();
        billingRecord();
        expenseControl();
        // Falta enlazar los metodos
    }
 //FUNCIONAL
    // INICIO DEL METODO DEL LOGIN
    public static void Login() {

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
                panelCotrol();
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


//FUNCIONAL 
    // INICIO DE LA INTERFAZ- PANEL DE CONTROL
    public static void panelCotrol() {
        Scanner panelControl = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Bienvenido a tu interfaz grafica.");
            System.out.println("Selecciona lo que deseas realizar el dia de hoy : ");
            System.out.println("1. Realizar un Registro de Factura");
            System.out.println("2.Realizar un Contol de Gastos");
            System.out.println("3.Salir");
            System.out.println(" X : ");

            int option = panelControl.nextInt();

            switch (option) {
                case 1:
                    billingRecord();

                    break;

                case 2:
                    expenseControl();
                    break;

                case 3:
                    Login();
                    break;

                default:
                    System.out.println("Opcion invalida, Por favor ingrese una de las opciones disponibles.");
                    return;

            }
        }
    }


    //FUNCIONAL 
    // INICIO DE REGISTRO FACTURAS ( Billing record=Registro de facturas )
    public static void billingRecord() {

        // ArrayList donde se almacenaran los datos de billingRecord
        ArrayList<Object> keepRecord = new ArrayList<>();

        // Scanner para almacenar datos
        Scanner billRecord = new Scanner(System.in); // (bR =billingRecord)
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1.Registro Factura");
            System.out.println("2.Revisar Registros de Facturas");
            System.out.println("3.Salir");

            int option = billRecord.nextInt();

            // Datos a pedir al usuario y la almacenamiento de dicho dato
            switch (option) {

                case 1:

                    // Paso 1
                    System.out.println("Ingrese una breve descripción sobre la factura");
                    String description = billRecord.next();
                    keepRecord.add(description);

                    // Paso 2
                    System.out.println("ingrese el valor de la factura");
                    Double originalBillValue = billRecord.nextDouble();
                    keepRecord.add(originalBillValue);

                    // Paso 3

                    
                    System.out.println("Dese agregar el IVA? Equivale al 19% en el valor de la factura  (si/no)");
                    String reponse = billRecord.next();

                    // Uso un while para entrar en un bucle para ejecutar el IVA
                    while (true) {
                        // System.out.println("Dese agregar el IVA? Equivale al 19% en el valor de la factura  (si/no)");

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
                    String date = billRecord.next();
                    keepRecord.add(date);

                    // paso 5
                    System.out.println("Ingrese quien fue el consumidor final ");
                    String endConsumer = billRecord.next();
                    keepRecord.add(endConsumer);

                    //Paso 6
                    System.out.println("Desea guardar el registro (si/no) : ");
                    String answer = billRecord.next();

                    if(answer.equalsIgnoreCase("si")){
                        System.out.println("Tu registro fue guardado exitosamente ");
                    

                    } else if(answer.equalsIgnoreCase("no")){
                        System.out.println("Tus datos no serán  guardaros");
                    

                    }



                case 2 :
                    // Un for donde recorra el arrayList y eitere en el cada iten y se muestre
                    for (int i = 0; i < keepRecord.size(); i++) {
                        System.out.println("Descripción :" + keepRecord.get(0));
                        System.out.println("Valor :" + keepRecord.get(1));
                        System.out.println("IVA: " +keepRecord.get(2));
                        System.out.println("Fecha : " + keepRecord.get(3));
                        System.out.println("Consumidor Final : " + keepRecord.get(4));

                    }
                    break;
                

                case 3:// ENLAZAR ACA
                panelCotrol();
                    billRecord.close();
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;

            }
        }
    }
    // FIN DEL billingRecord


    // INICIO DE CONTROL DE GASTOS (expenseControl = control de gastos)
    public static void expenseControl() {
        // Creo un arrayList para mantener datos almacenados
        ArrayList<Object> viewControl = new ArrayList<>();

        Scanner expenseControl = new Scanner(System.in);

        // se crea una variable para almacenar un monto inicial
        double saldo;

        System.out.println("Ingresa el saldo inicial ");
        saldo = expenseControl.nextDouble();
        viewControl.add(saldo);
        

        // Creo un bucle while para tener un menú
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1.Registar Control");
            System.out.println("2.Recargar Saldo");
            System.out.println("3.Salir ");
            System.out.println("Ingrese una de las opciones ");

            // Para leer la opcion del usuario
            int option = expenseControl.nextInt();

    

            // Creacion de un switch para las opciones 1 y 2
            switch (option) {
                case 1:
                    System.out.println("Ingrese un breve descripcion del Gasto : ");
                    String description = expenseControl.next();
                    viewControl.add(description);

                    System.out.println("Ingrese el valor del gasto :  ");
                    double value = expenseControl.nextDouble();
                    viewControl.add(value);

                    if (value > saldo) {
                        System.out.println("Fondos insuficientes");

                    } else {
                        // Si es menor el saldo ingresado del gasto se descontara del saldo inicial
                        saldo -= value;
                        // PREGUNTAR SI ES NECESARIO TENER PRESENTE NUEVAMENTE EL ARRAYLIST
                    }
                    
                    // Mostramos aca mensaje informativo
                    System.out.println("Registro guardado exitosamnete");
                    System.out.println("Tu saldo restante es de : " + saldo);
                    break;


                case 2:
                    // LO MISMO PREGUNTAR POR EL ARRAYLIST
                    System.out.println("Ingrese monto a recargar : ");

                    // variable
                    double recharge = expenseControl.nextDouble();
                    // Suma del saldo ingresado para recargar al saldo inicial
                    saldo += recharge;

                    // Mensaje informativo
                    System.out.println("Saldo recargado correctamente  ");
                    System.out.println("Tu nuevo saldo es de : " + saldo);
                    break;

                    
                

                    case 3 : 
                    panelCotrol();
                    
                    default:
                    System.out.println("Opción no válida");
                    // MIRAR ACA TAMBIEN COMO SERA EL FLUJO
                    
                    
               
            

                }
            }
        }
    }

       

    
    // FIN DEL EXPENSECONTROL

