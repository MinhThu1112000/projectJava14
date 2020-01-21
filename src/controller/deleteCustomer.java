/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.customer;
import view.signUp;

/**
 *
 * @author Minh Thu
 */
public class deleteCustomer {

    public void deleteCus(ArrayList<customer> list, String user) throws IOException {
        checkAccount check = new checkAccount();
        searchKH search = new searchKH();
        timeNow time = new timeNow();
        customer cus;
        signUp sg = new signUp();
        Scanner sc = new Scanner(System.in);
        if (!check.checkUser(user, list)) {
            System.out.println("Khong tim thay user de xoa!");
        } else {
            cus = search.showCustomer(list, user);
            int choose;
            do {
                System.out.println("Day co phai tai khoan ban muon xoa ?");
                System.out.println("1.YES");
                System.out.println("2.NO");
                System.out.println("Moi ban chon : ");
                choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        cus.setStatus(0);
                        cus.setEndDate(time.time());
                        sg.writeFile("customer.txt", list);
                        break;
                    case 2:
                        break;
                }
            } while (choose != 2 && choose != 1);

        }
    }

    public void xoaTaiKhoanSau48H(ArrayList<customer> list) throws IOException {
        checkAccount check = new checkAccount();
        timeNow time = new timeNow();
        signUp sg = new signUp();
        String timeDate = time.timeFinal1();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals("ADMINCustomer")) {
                if (list.get(i).getStatus() == 1) {
                    if (check.chenhLech(list.get(i).getStartDate(), timeDate)) {
                        final String end = timeDate;
                        list.get(i).setStatus(0);
                        list.get(i).setEndDate(end);
                    }
                }
            }
        }
        sg.writeFile("customer.txt", list);

    }

}
