/**
 * This is the entry pont of the software
 * 
 * @author Jay Ubisse
 * @version 1.0.0
 */

package digitaltech;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("\n|-----( DigitalTech Store )-----|\n");
            System.out.println("""
                    Qual e o seu cargo?
                    1. Usuario
                    2. Administrador
                    3. Sair
                    """);

            option = Integer.parseInt(input.nextLine());

            String role;
            switch(option) {
                case 1:
                    role = "usuario";
                    roleMenu(role);
                    break;
                case 2:
                    role = "administrador";
                    roleMenu(role);
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while(option != 3);
        
    }

    public static void roleMenu(String role) {
        Scanner input = new Scanner(System.in);
        Roles roleObj = new Roles();
        System.out.println("Introduza o nome de " + role);
        String name = input.nextLine();
        System.out.println("Introduza a sua palavra-passe");
        String password = input.nextLine();

        if(role.equals("administrador")) {
            if(!roleObj.verifyAdminName(name) || !roleObj.verifyAdminPassword(password)) {
                System.out.println("Nome de administrador ou palavra-passe incorrecto!");
            } else {
                System.out.println("Dados correctos.");
            }
        } else if(role.equals("usuario")) {
            if(!roleObj.verifyUserName(name) || !roleObj.verifyUserPassword(password)) {
                System.out.println("Nome de usuario ou palavra-passe incorrecto!");
            } else {
                System.out.println("Dados correctos.");
            }
        }

    }

}