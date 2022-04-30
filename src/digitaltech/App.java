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

    //objects used
    static Scanner input;
    static Roles roleObj;
    static Product productObj;
    static DataStructure productHandling;

    public static void main(String[] args) {
        
        input = new Scanner(System.in);
        roleObj = new Roles();
        productHandling = new DataStructure();

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
                    checkRole(role);
                    break;
                case 2:
                    role = ADMIN;
                    checkRole(role);
                    break;
                default:
                    System.out.println(INVALID_OPTION);
                    break;
            }
        }
        
    }

    public static void checkRole(String role) {
        System.out.println("\nIntroduza o nome de " + role);
        String name = input.nextLine();
        System.out.println("Introduza a sua palavra-passe");
        String password = input.nextLine();

        if(role.equals(ADMIN)) {
            if(!roleObj.verifyAdminName(name) || !roleObj.verifyAdminPassword(password)) {
                System.out.println("\nNome de administrador ou palavra-passe incorrecto!");
            } else {
                roleMenu(role);
            }
        } else if(role.equals(USER)) {
            if(!roleObj.verifyUserName(name) || !roleObj.verifyUserPassword(password)) {
                System.out.println("\nNome de usuario ou palavra-passe incorrecto!");
            } else {
                roleMenu(role);
            }
        }

    }

    public static void roleMenu(String role) {
        int option;
        if(role.equals(ADMIN)) {
            while(true) {
                System.out.println(STORE_NAME);
                System.out.println("======== " + roleObj.getAdminName() + " ========\n");
                System.out.println("""
                        1. Vender
                        2. Registar
                        3. Editar dados
                        4. Ver inventario
                        5. Sair
                        """);
    
                option = Integer.parseInt(input.nextLine());
                if(option == 5) break;
    
                switch(option) {
                    case 1:
                        System.out.println("Area de venda em manuntencao");
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        System.out.println("Em manutencao");
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

    public static void register() {
        System.out.println("\n<<<<<<< Registro de produtos >>>>>>>\n");
        System.out.println("""
            Escolha a categoria do produto
            1. Computador
            2. Celular
            3. Tv
                """);
        String category;
        try {
            char option = input.nextLine().toLowerCase().charAt(0);
            switch (option) {
                case '1':
                    category = "computador";
                    break;
                case '2':
                    category = "celular";
                    break;
                case '3':
                    category = "tv";
                    break;
                default:
                    throw new IllegalArgumentException("\nOpcao ivalida");
            }
            System.out.println("\nIntroduza a marca do produto");
            String brand = input.nextLine().toLowerCase();
            System.out.println("\nIntroduza o numero de serie do produto");
            int id = Integer.parseInt(input.nextLine());
            System.out.println("\nIntroduza o preco do produto");
            float price = Float.parseFloat(input.nextLine());

            productHandling.saveProduct(new Product(category, brand, id, price));
            System.out.println("\n===========================================\n");
            System.out.println("PRODUTO REGISTRADO COM SUCESSO!");
            System.out.println("\nCategoria: " + category + "\nMarca: " + brand + "\nNumero de serie: " + id + "\nPreco: " + price);
            System.out.println("\n===========================================\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Cateoria nao selecionada. Deve selecionar uma categoria");
        }
    }

    

}