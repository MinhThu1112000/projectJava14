/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.checkAccount;
import controller.searchKH;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.customer;

/**
 *
 * @author Minh Thu
 */
public class logIn {

    signUp sign = new signUp();
    checkAccount check = new checkAccount();
    menu menu = new menu();
    //ArrayList<customer> list = new ArrayList<>();

    public String logInAccount(ArrayList<customer> list) throws IOException, InterruptedException {
        customer cus = new customer();
        searchKH sr = new searchKH();
        int k  = 0;
        String user;
        String pass;
        do {
            System.out.println("Moi ban nhap user : ");
            Scanner sc = new Scanner(System.in);
            user = sc.nextLine();
            if (!check.checkUser1(user, list)) {
                Thread.sleep(150);
                System.err.println("User khong ton tai hoac da bi khoa!");
                Thread.sleep(150);
                if (menu.dangXuat() == 1) {
                    System.out.println("-------CAM ON QUY KHACH DA SU DUNG PHAN MEM CUA CHUNG TOI------");
                    k = 0;
                } else {
                    k = 1;
                }
            }

        } while (!check.checkUser1(user, list) && k == 1);
        do {
            System.out.println("Moi ban nhap pass : ");
            Scanner sc = new Scanner(System.in);
            pass = sc.nextLine();
            if (!check.checkPassWord(pass, list)) {
                Thread.sleep(150);
                System.err.println("**CHU Y : Pass bi sai!Moi nhap lai!");
                Thread.sleep(150);
            }

        } while (!check.checkPassWord(pass, list));
        System.out.println("-------ĐANG NHAP THANH CONG-------");
        if (user.contains("ADMINCustomer")) {
            menu.admin(list, user);
        } else {
            menu.menuCustomer(list,user);
        }
        return user;
    }
}
