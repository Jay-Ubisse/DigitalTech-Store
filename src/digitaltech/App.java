/**
 * This is the entry pont of the software
 * 
 * @author Jay Ubisse
 * @version 1.0.0
 */

package digitaltech;

import java.util.Scanner;

public class App {

    //Frequently used strings
    static final String STORE_NAME = "\n|-----( DigitalTech Store )-----|\n";
    static final String INVALID_OPTION = "\nOpcao invalida!";
    static final String USER = "usuario";
    static final String ADMIN = "administrador";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Roles roleObj = new Roles();

        int option;
        while(true) {
            System.out.println(STORE_NAME);
            System.out.println("""
                    Qual e o seu cargo?
                    1. Usuario
                    2. Administrador
                    3. Sair
                    """);

            option = Integer.parseInt(input.nextLine());
            if(option == 3) break;

            String role;
            switch(option) {
                case 1:
                    role = USER;
                    checkRole(input, roleObj, role);
                    break;
                case 2:
                    role = ADMIN;
                    checkRole(input, roleObj, role);
                    break;
                default:
                    System.out.println(INVALID_OPTION);
                    break;
            }
        }
        
    }

    public static void checkRole(Scanner input, Roles roleObj, String role) {
        System.out.println("\nIntroduza o nome de " + role);
        String name = input.nextLine();
        System.out.println("Introduza a sua palavra-passe");
        String password = input.nextLine();

        if(role.equals(ADMIN)) {
            if(!roleObj.verifyAdminName(name) || !roleObj.verifyAdminPassword(password)) {
                System.out.println("\nNome de administrador ou palavra-passe incorrecto!");
            } else {
                roleMenu(input, roleObj, role);
            }
        } else if(role.equals(USER)) {
            if(!roleObj.verifyUserName(name) || !roleObj.verifyUserPassword(password)) {
                System.out.println("\nNome de usuario ou palavra-passe incorrecto!");
            } else {
                roleMenu(input, roleObj, role);
            }
        }

    }

    public static void roleMenu(Scanner input, Roles roleObj, String role) {
        int option;
        if(role.equals(ADMIN)) {
            while(true) {
                System.out.println(STORE_NAME);
                System.out.println("======== " + roleObj.getAdminName() + " ========\n");
                System.out.println("""
                        1. Vender
                        2. Cadastrar
                        3. Editar dados
                        4. Ver inventario
                        5. Sair
                        """);
    
                option = Integer.parseInt(input.nextLine());
                if(option == 3) break;
    
                switch(option) {
                    case 1:
                        System.out.println("Area de venda em manuntencao");
                        break;
                    case 2:
                        System.out.println("Area de cadastro em manuntencao");
                        break;
                    case 3:
                        System.out.println("Area de edicao em manuntencao");
                        break;
                    case 4:
                        System.out.println("Area de inventario em manuntencao");
                        break;
                    default:
                        System.out.println(INVALID_OPTION);
                        break;
                }
            }
        } else if(role.equals(USER)) {
            while(true) {
                System.out.println(STORE_NAME);
                System.out.println("======== " + roleObj.getUserName() + " ========\n");
                System.out.println("""
                        1. Vender
                        2. Ver inventario
                        3. Sair
                        """);

                option = Integer.parseInt(input.nextLine());
                if(option == 3) break;
                switch(option) {
                    case 1:
                        System.out.println("Area de venda em manuntencao");
                        break;
                    case 2:
                        System.out.println("Area de inventario em manuntencao");
                        break;
                    default:
                        System.out.println(INVALID_OPTION);
                        break;
                }
            }
        }

    }

}