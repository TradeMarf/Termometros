import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    // En esta variable poner cuantos espacios hay 
    final int ESPACIOS = 100;
    
    Scanner leer = new Scanner(System.in);
    int claves[] = new int[ESPACIOS];
    String nombres[] = new String[ESPACIOS];
    float precios[] = new float[ESPACIOS];
    char tipos[] = new char[ESPACIOS];
    boolean mercurios[] = new boolean[ESPACIOS];
    int resp = 0, cont = 0, clave = 0, tipoComp = 0, celda = 0, merComp = 0, respMod = 0, existe = 0, contTam = 0;
    int portClaves = 0;
    String portNombres = " ";
    float portPrecios = 0;
    char portTipos = ' ';
    boolean portMercurios = false;
    // resp = Variable para bucle del menú
    // cont = Cantidad de datos registrados
    // tipoComp = Verificación de ingresar caracter valido en tipos[]
    // celda = Variable para registrar la celda donde se encuentra la clave
    // mercComp = Verificación para ingresar caracter valido en mercurios[]
    
    char tipo = ' ', merChar = ' ', modChar = ' ';
    boolean valError = false, error = false, mercurio = false, modificar = true;

    do{
      System.out.println("-. TERMOMETROS LOS CALIENTES DE CD. GUZMÁN .-");
      System.out.println("[1] Añadir un termometro");
      System.out.println("[2] Consultar un termometro");
      System.out.println("[3] Consultar todos los termometros");
      System.out.println("[4] Modificar datos de un termometro");
      System.out.println("[5] Eliminar un termometro ");
      System.out.println("[6] Finalizar programa");
      System.out.print("-. Ingrese la acción que desea realizar: ");
      resp = leer.nextInt();
      leer.nextLine();
      
      // Linea 49: Añadir
      // Linea 148: Consulta (Indiv.)
      // Linea 200: Consulta (Gen.)
      // Linea 249: Modificación
      // Linea 417: Eliminación
      // Linea 475: Finalización

      switch (resp){
        case 1: // Añadir termometro
          if (cont < ESPACIOS){
            System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
            System.out.print("- Ingrese el número de clave a registrar [1-111]: ");
            clave = leer.nextInt();
            leer.nextLine();

            for (int x = 0; x < ESPACIOS ; x++){
              if (claves[x] == clave){
                valError = true;
                break;
              }  
            }

            if (clave < 0 || clave > 111){
              System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
              System.out.println("ERROR: La clave no esta en el rango establecido");
              System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
              break;
            }

            if (valError){
              System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
              System.out.println("ERROR: Esta clave ya existe");
              System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
            } else {
              claves[cont] = clave;
              System.out.print("- Ingrese el nombre del termometro: ");
              nombres[cont] = leer.nextLine();
              System.out.print("- Ingrese el precio del termometro: $");
              precios[cont] = leer.nextFloat();
              leer.nextLine();
              
              System.out.println("-. De las siguientes opciones, elija el tipo de termometro .-");
              System.out.println("[T] Termometro de contacto");
              System.out.println("[R] Termometro sin contacto");
              System.out.print("- Ingrese el tipo de termometro [T-R]: ");
              tipo = leer.nextLine().charAt(0);
              tipoComp = (int)Character.toLowerCase(tipo);

              do{
                switch (tipoComp){
                  case 116:
                    tipos[cont] = tipo;
                    valError = false;
                    mercurio = true;
                    break;
                  case 114:
                    tipos[cont] = tipo;
                    valError = false;
                    mercurios[cont] = false;
                    mercurio = false;
                    break;
                  default:
                    System.out.print("- Ingrese un caracter valido de opción [T-R]: ");
                    tipo = leer.nextLine().charAt(0);
                    tipoComp = (int)Character.toLowerCase(tipo);
                    valError = true;
                    break;
                }
              } while (valError);

              if (mercurio){
                System.out.print("- ¿Utiliza mercurio? [Y - Si, N - No]: ");
                merChar = leer.nextLine().charAt(0);
                merComp = (int)Character.toLowerCase(merChar);

                do{
                  switch (merComp){
                    case 121:
                      mercurios[cont] = true;
                      valError = false;
                      break;
                    case 110:
                      mercurios[cont] = false;
                      valError = false;
                      break;
                    default:
                      System.out.print("- Ingrese un caracter valido de opción [Y - Si, N - No]: ");
                      merChar = leer.nextLine().charAt(0);
                      merComp = (int)Character.toLowerCase(merChar);
                      valError = true;
                      break;
                  }
                } while (valError);
              }
              
              cont++;
              System.out.print("\nCLAVE REGISTRADA CON EXITO");
              System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
            }
          } else{
            System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
            System.out.println("ERROR: Ya esta lleno el registro");
            System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
          }
          valError = false;
          break;
        
        case 2: // Consulta individual
          if (cont == 0){
            System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
            System.out.println("ERROR: No hay clave registrada");
            System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
            break;
          }
          
          System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          System.out.print("- Ingrese el número de clave a consultar [1-111]: ");
          clave = leer.nextInt();
          leer.nextLine();
          valError = true;

          for (int x = 0; x < ESPACIOS ; x++){
            if (claves[x] == clave){
              celda = x;
              valError = false;
            }  
          }

          if (valError){
            System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
            System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
            System.out.println("ERROR: Clave no encontrada");
            System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
            break;
          }

          System.out.printf("\n-. [TERMOMETRO CON CLAVE %d] .-\n", clave);
          System.out.printf("· Nombre del termometro: %s\n", nombres[celda]);
          System.out.printf("· Precio del termometro: $%.2f\n", precios[celda]);
          tipoComp = (int)Character.toLowerCase(tipos[celda]);
          switch (tipoComp){
            case 116:
              System.out.print("· Tipo de termometro: Termometro de contacto\n");
              break;
            case 114:
              System.out.print("· Tipo de termometro: Termometro sin contacto\n");
              break;
          }
          if (mercurios[celda])
            System.out.print("· Utiliza mercurio");
          else
            System.out.print("· No utiliza mercurio");

          
          System.out.println("\n\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");

          valError = false;
          break;

        case 3: // Consulta general
          if (cont == 0){
            System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
            System.out.println("ERROR: No hay clave registrada");
            System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
            break;
          }
          
          for (int x = 0 ; x < cont - 1 ; x++) {
             for (int y = 0 ; y < cont - x - 1; y++){ 
               if (claves[y + 1] < claves[y]){      
                 portClaves = claves[y + 1];
                 portPrecios = precios[y + 1];
                 portNombres = nombres[y + 1];
                 portTipos = tipos[y + 1];
                 portMercurios = mercurios[y + 1];
                 
                 claves[y + 1] = claves[y];
                 precios[y + 1] = precios[y];
                 nombres[y + 1] = nombres[y];
                 tipos[y + 1] = tipos[y];
                 mercurios[y + 1] = mercurios[y];
                 
                 nombres[y] = portNombres;
                 claves[y] = portClaves;
                 precios[y] = portPrecios;
                 tipos[y] = portTipos;
                 mercurios[y] = portMercurios;
               }
             }
          }
          
          System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-\n");
          
          for (int y = 0 ; y < cont ; y++){
            System.out.printf("-. [TERMOMETRO CON CLAVE %d] .-\n", claves[y]);
            System.out.printf("· Nombre del termometro: %s\n", nombres[y]);
            System.out.printf("· Precio del termometro: $%.2f\n", precios[y]);
            tipoComp = (int)Character.toLowerCase(tipos[y]);
            switch (tipoComp){
               case 116:
                  System.out.print("· Tipo de termometro: Termometro de contacto\n");
                  break;
               case 114:
                  System.out.print("· Tipo de termometro: Termometro sin contacto\n");
                  break;
            }
            if (mercurios[y])
               System.out.println("· Utiliza mercurio\n");
            else
               System.out.println("· No utiliza mercurio\n");
          }
          
          System.out.println("-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          
          break;    
        case 4: // Modificaciones
          if (cont == 0){
            System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
            System.out.println("ERROR: No hay clave registrada");
            System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
            break;
          }

          System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          System.out.print("- Ingrese el número de clave a modificar [1-111]: ");
          clave = leer.nextInt();
          leer.nextLine();
          valError = true;

          for (int x = 0; x < ESPACIOS ; x++){
            if (claves[x] == clave){
              celda = x;
              valError = false;
            }  
          }

          if (valError){
            System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
            System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
            System.out.println("ERROR: Clave no encontrada");
            System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
            break;
          }
          do{
            System.out.printf("\n-. [TERMOMETRO CON CLAVE %d] .-\n", clave);
            System.out.printf("·[1] Nombre del termometro: %s\n", nombres[celda]);
            System.out.printf("·[2] Precio del termometro: $%.2f\n", precios[celda]);
            tipoComp = (int)Character.toLowerCase(tipos[celda]);
            switch (tipoComp){
              case 116:
                System.out.print("·[3] Tipo de termometro: Termometro de contacto\n");
                break;
              case 114:
                System.out.print("·[3] Tipo de termometro: Termometro sin contacto\n");
                break;
            }
            if (tipoComp == 116){
              if (mercurios[celda])
                System.out.print("·[4] Utiliza mercurio");
              else
                System.out.print("·[4] No utiliza mercurio");
              System.out.print("\n·[5] Finalizar modificación");
            } else {
              if (mercurios[celda])
                System.out.print("· No utiliza mercurio [NO CONTACTO]");
              else
                System.out.print("· No utiliza mercurio [NO CONTACTO]");
              System.out.print("\n·[4] Finalizar modificación");
            }
   
            if (tipoComp == 116){
              System.out.print("\n\n- Inserte el número del dato que desea modificar [1-5]: ");
              respMod = leer.nextInt();
            } else {
              System.out.print("\n\n- Inserte el número del dato que desea modificar [1-4]: ");
              respMod = leer.nextInt();
            }
            leer.nextLine();
            do{
                switch (respMod) {
                  case 1: // Nombre
                    System.out.print("- Ingrese el nuevo nombre del termometro: ");
                    nombres[celda] = leer.nextLine();
                    error = false;
                    break;
                  
                  case 2: // Precio
                    System.out.print("- Ingrese el nuevo precio del termometro: $");
                    precios[celda] = leer.nextFloat();
                    leer.nextLine();
                    error = false;
                    break;
                  
                  case 3: // Tipo
                  System.out.println("-. De las siguientes opciones, elija el tipo de termometro .-");
                  System.out.println("[T] Termometro de contacto");
                  System.out.println("[R] Termometro sin contacto");
                  System.out.print("- Ingrese el tipo de termometro [T-R]: ");
                  tipo = leer.nextLine().charAt(0);
                  tipoComp = (int)Character.toLowerCase(tipo);
   
                  do{
                    switch (tipoComp){
                      case 116:
                        tipos[celda] = tipo;
                        valError = false;
                        break;
                      case 114:
                        tipos[celda] = tipo;
                        mercurios[celda] = false;
                        valError = false;
                        break;
                      default:
                        System.out.print("- Ingrese un caracter valido de opción [T-R]: ");
                        tipo = leer.nextLine().charAt(0);
                        tipoComp = (int)Character.toLowerCase(tipo);
                        valError = true;
                        break;
                    }
                    error = false;
                  } while (valError);  
                  break;
                  
                  case 4: // Mercurio
                    tipo = tipos[celda];
                    tipoComp = (int)tipo;
                    if (tipoComp == 114){
                      modificar = false;
                      error = false;
                      break;
                    }
   
                    System.out.print("- ¿Utiliza mercurio? [Y - Si, N - No]: ");
                    merChar = leer.nextLine().charAt(0);
                    merComp = (int)Character.toLowerCase(merChar);
   
                    do{
                      switch (merComp){
                        case 121:
                          mercurios[celda] = true;
                          valError = false;
                          break;
                        case 110:
                          mercurios[celda] = false;
                          valError = false;
                          break;
                        default:
                          System.out.print("- Ingrese un caracter valido de opción [Y - Si, N - No]: ");
                          merChar = leer.nextLine().charAt(0);
                          merComp = (int)Character.toLowerCase(merChar);
                          valError = true;
                          break;
                      }
                    } while (valError);  
                    break;
                  
                  case 5: // Finalizar
                    if (tipoComp == 116)
                       modificar = false;
                    else{
                       System.out.print("Ingrese un caracter de opción valido [1-4]: ");
                       respMod = leer.nextInt();
                       leer.nextLine();
                       error = true;
                    }
                    break;
                  default:
                    if (tipoComp == 116)
                       System.out.print("- Ingrese un caracter valido de opción [1-5]: ");
                    else
                       System.out.print("- Ingrese un caracter valido de opción [1-4]: ");
                    respMod = leer.nextInt();
                    leer.nextLine();
                    error = true;
                    break;
                }
              } while (error);
            } while (modificar);
   
          System.out.println("\n\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          modificar = true;
          valError = false;
          break;
        case 5: // Eliminación
          System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          System.out.printf("ELIMINACION DEL PRODUCTO\n");

          if (cont > 0) { 
            System.out.printf("Ingrese la clave del producto: ");
            clave= leer.nextInt();
            if (clave >=1 && clave <= 111){
               existe = -1;
               for(int x = 0; x < cont; x++){
                  if (clave == claves[x]){
                     existe=x;
                     break;
                  }
               }
            }
   
               if(existe != -1){
                  System.out.printf("- Nombre del producto: %s\n" ,nombres[existe]);
                  System.out.printf("- Precio del producto: $%.2f\n" , precios[existe]);
                  if (tipos[existe] == 't'){
                     System.out.println("- Tipo del producto: Termometro con Contacto");
                  } else{
                     System.out.println("- Tipo del producto: Termometro sin Contacto");
                  }
                  if (mercurios[existe]){
                     System.out.println("- Contiene mercurio");
                  } else{
                     System.out.println("- No contiene mercurio");
                  }
                  
                  System.out.print("Estas seguro de eliminar el producto? [Si = S] [No = N]: ");
                  leer.nextLine();
                  resp= leer.nextLine().charAt(0);
                  if(resp == 'S'|| resp == 's'){
                    claves[existe] = 0;
                    for (int x = existe; x < cont - 1 ; x++){
                     claves[x] = claves[x+1];
                     nombres[x] = nombres[x+1];
                     precios[x] = precios[x+1];
                     mercurios[x] = mercurios[x+1];
                     tipos[x] = tipos[x+1];
                    }
                           
                    cont--;
                    System.out.println("El producto fue eliminado");
                          
                  }else{   
                     System.out.println("No se eliminó ningun producto");
                  }
               }else{
                  System.out.printf("No hay productos con esa clave\n");
               }
           }else{
            System.out.printf("No hay productos registrados\n");
           }
           System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
         break;
        case 6: // Finalización
          System.out.println("\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          System.out.println("[PROYECTO DEL EQUIPO 17]");
          System.out.println("· Creado por:");
          System.out.println("- Miguel Angel Ramirez Farias");
          System.out.println("- Ronaldo Varona Baranda");
          System.out.println("Fecha: 1 de diciembre del 2022");
          System.out.print("-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          break;
          
        default:
          System.out.println("\n!-.!.-.!.-.!.-.!.-.!.-.!.-.!");
          System.out.println("ERROR: Opción no valida");
          System.out.println("!-.!.-.!.-.!.-.!.-.!.-.!.-.!\n");
          break;
      }   
    } while (resp != 6);  
  }
}