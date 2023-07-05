package bai1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QLCB qlcb = new QLCB();
        while (true) {
            System.out.println("Application Manager Officer");
            System.out.println("Enter 1: To insert officer");
            System.out.println("Enter 2: To search officer by name: ");
            System.out.println("Enter 3: To show information officers");
            System.out.println("Enter 4: To exit:");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Enter a: to insert Enginner");
                    System.out.println("Enter b: to insert Worker");
                    System.out.println("Enter c: to insert Staff");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age:");
                            int age = scanner.nextInt();
                            System.out.print("Enter gender: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter branch: ");
                            String branch = scanner.nextLine();
                            CanBo kySu = new KySu(name, age, gender, address, branch);
                            qlcb.addCanBo(kySu);
                            break;

                        }
                        case "b": {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age:");
                            int age = scanner.nextInt();
                            System.out.print("Enter gender: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter level: ");
                            int level = scanner.nextInt();
                            CanBo congNhan = new CongNhan(name, age, gender, address, level);
                            qlcb.addCanBo(congNhan);
                            scanner.nextLine();
                            break;
                        }
                        case "c": {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            System.out.print("Enter gender: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter task: ");
                            String task = scanner.nextLine();
                            CanBo nhanVien = new NhanVien(name, age, gender, address, task);
                            qlcb.addCanBo(nhanVien);
                            break;
                        }
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    qlcb.searchCanBo(name).forEach(canBo -> {
                        System.out.println(canBo.toString());
                    });
                    break;
                }
                case "3": {
                    qlcb.printAll();
                    break;
                }
                case "4": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }

        }
    }
}
