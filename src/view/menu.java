/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.deleteCustomer;
import controller.searchKH;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.customer;

/**
 *
 * @author Minh Thu
 */
public class menu {

    public void admin(ArrayList<customer> list, String user) throws IOException, InterruptedException {
        int choose;
        searchKH search = new searchKH();
        listKH kh = new listKH();
        signUp sg = new signUp();
        deleteCustomer dele = new deleteCustomer();
        do {
            System.out.println("|-------------------------------------------|");
            System.out.println("|                MENU ADMIN                 |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|1.          Xem thong tin admin            |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|2             Them khach hang              |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|3.     Tim kiem khach hang bang email      |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|4. Tim kiem khach hang bang So dien thoai  |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|5.     Tim kiem khach hang bang dia chi    |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|6.       Xoa khach hang bang user          |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|7.   Xem danh sach khach hang con ton tai  |");
            System.out.println("|-------------------------------------------|");
            System.out.println("|8.              Dang xuat                  |");
            System.out.println("|-------------------------------------------|");
            System.out.println("Ban chon chuc nang : ");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            sc = new Scanner(System.in);
            switch (choose) {
                case 1:
                    search.showCustomer(list, user);
                    break;
                case 2:
                    sg.signUpUser(list);
                    break;
                case 3:
                    search.searchEmail(list);
                    break;
                case 4:
                    search.searchPhone(list);
                    break;
                case 5:
                    search.searchAddress(list);
                    break;
                case 6:
                    String userDelete;
                    System.out.println("Moi ban nhap user can xoa : ");
                    userDelete = sc.nextLine();
                    dele.deleteCus(list, userDelete);
                    break;
                case 7:
                    search.showCustomerExist(list);
                case 8:
                    System.out.println("------------CAM ON ADMIN-----------");
                    break;
            }
        } while (choose != 7);
    }

    public void menuCustomer(ArrayList<customer> list, String user) throws IOException {
        int choose;
        listKH kh = new listKH();
        logIn lg = new logIn();
        searchKH search = new searchKH();
        do {
            System.out.println("|---------------------------------------------|");
            System.out.println("|                MENU CUSTOMER                |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|1.          Xem thong tin khach hang         |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|2       Tim kiem khach hang bang email       |");
            System.out.println("|-------------------------------------------  |");
            System.out.println("|3.    Tim kiem khach hang bang so dien thoai |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|4.      Tim kiem khach hang bang dia chi     |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|5.               Dang xuat                   |");
            System.out.println("|---------------------------------------------|");
            System.out.println("Moi ban nhap lua chon : ");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    search.showCustomer(list, user);
                    break;
                case 2:
                    search.searchEmail(list);
                    break;
                case 3:
                    search.searchPhone(list);
                    break;
                case 4:
                    search.searchAddress(list);
                    break;
                case 5:
                    break;
            }

        } while (choose != 5);
    }

    public int dangXuat() {
        int choose;
        do {
            System.out.println("|------------------------------------|");
            System.out.println("|       Ban co muon tiep tuc         |");
            System.out.println("|------------------------------------|");
            System.out.println("|1.          Tiep tuc                |");
            System.out.println("|------------------------------------|");
            System.out.println("|2             Thoat                 |");
            System.out.println("|------------------------------------|");
            System.out.println("Moi ban chon : ");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    break;
                case 2:
                    System.out.println("--------CAM ON QUY KHACH DA SU DUNG DICH VU-----");
                    System.exit(0);
                    return 1;
                //break;

            }
        } while (choose != 2 && choose != 1);
        return 0;
    }

    public void existYN(ArrayList<customer> list, String user) throws IOException, InterruptedException {
        signUp sg = new signUp();
        logIn lg = new logIn();
        int choose;
        do {
            System.out.println("|---------------------------------------------|");
            System.out.println("|                MENU USER                    |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|1.               SIGN UP                     |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|2                LOG IN                      |");
            System.out.println("|-------------------------------------------  |");
            System.out.println("|3.               THOAT                       |");
            System.out.println("|---------------------------------------------|");
            System.out.println("Moi ban chon : ");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    sg.signUpUser(list);
                    break;
                case 2:
                    user = lg.logInAccount(list);
                    break;
                case 3:
                    System.out.println("--------CAM ON QUY KHACH DA SU DUNG SAN PHAM CUA CHUNG TOI------");
                    deleteCustomer dele = new deleteCustomer();
                    dele.xoaTaiKhoanSau48H(list);
                    System.exit(0);
            }

        } while (choose != 3);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<customer> list = new ArrayList();
        signUp sg = new signUp();
        String user = "";
        menu menu = new menu();
        sg.readFile("customer.txt", list);
        menu.existYN(list, user);

    }
}
