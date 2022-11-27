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
    int resp = 0, cont = 0, clave = 0, tipoComp = 0, celda = 0, merComp = 0, respMod = 0, modComp = 0;
    // resp = Variable para bucle del menú
    // cont = Cantidad de datos registrados
    // tipoComp = Verificación de ingresar caracter valido en tipos[]
    // celda = Variable para registrar la celda donde se encuentra la clave
    // mercComp = Verificación para ingresar caracter valido en mercurios[]
    // respMod = Variable para respuesta de que dato modificar
    // modComp = Verificación para respuesta de modificar otro
    
    char tipo = ' ', merChar = ' ', modChar = ' ';
    boolean valError = false, error = false, mercurio = false, modificar = true;

    do{
      System.out.println("-. TIENDA DE TERMOMETROS .-");
      System.out.println("[1] Añadir un termometro");
      System.out.println("[2] Consultar un termometro");
      System.out.println("[3] Consultar todos los termometros");
      System.out.println("[4] Modificar datos de un termometro");
      System.out.println("[5] Eliminar un termometro ");
      System.out.println("[6] Finalizar programa");
      System.out.print("-. Ingrese la acción que desea realizar: ");
      resp = leer.nextInt();

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
          } else {
            if (mercurios[celda])
              System.out.print("· Utiliza mercurio [NO CONTACTO]");
            else
              System.out.print("· No utiliza mercurio [NO CONTACTO]");
          }

          if (mercurios[celda]){
            System.out.print("\n\n- Inserte el número del dato que desea modificar [1-4]: ");
            respMod = leer.nextInt();
          } else {
            System.out.print("\n\n- Inserte el número del dato que desea modificar [1-3]: ");
            respMod = leer.nextInt();
          }
          leer.nextLine();
          do{
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
                    System.out.print("- Ingrese un caracter valido de opción [1-3]: ");
                    respMod = leer.nextInt();
                    leer.nextLine();
                    error = true;
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
                
                default:
                  System.out.print("- Ingrese un caracter valido de opción [1-4]: ");
                  respMod = leer.nextInt();
                  leer.nextLine();
                  error = true;
                  break;
              }
            } while (error);

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
            } else {
              if (mercurios[celda]){
                mercurios[celda] = false;
                System.out.print("· No utiliza mercurio [NO CONTACTO]");
              } else
                System.out.print("· No utiliza mercurio [NO CONTACTO]");
            }

            System.out.print("\n\n- ¿Desea modificar otro dato? [Y = Si, N = No]: ");
            modChar = leer.nextLine().charAt(0);
            modComp = (int)Character.toLowerCase(modChar);
            
            do{
              switch (modComp){
                case 121:
                  modificar = true;
                  valError = false;
                  break;
                case 110:
                  modificar = false;
                  valError = false;
                  break;
                default:
                  System.out.print("- Ingrese un caracter valido de opción [Y - Si, N - No]: ");
                  modChar = leer.nextLine().charAt(0);
                  modComp = (int)Character.toLowerCase(modChar);
                  valError = true;
                  break;
                  }
                } while (valError);

              if (modificar){
                if (tipoComp == 116){
                  System.out.print("\n\n- Inserte el número del dato que desea modificar [1-4]: ");
                  respMod = leer.nextInt();
                } else {
                  System.out.print("\n\n- Inserte el número del dato que desea modificar [1-3]: ");
                  respMod = leer.nextInt();
                }
                leer.nextLine();
              }
            
          } while (modificar);

          System.out.println("\n\n-·-·-·-·-·-·-·-·-·-·-·-·-·-·-");
          modificar = true;
          valError = false;
          break;
        case 5: // Eliminación
          break;
        case 6: // Finalización
          break;
        default:

      }
                
              
    } while (resp != 6);
  }
}