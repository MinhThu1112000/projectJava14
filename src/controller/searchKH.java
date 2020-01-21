/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.customer;
import view.listKH;

/**
 *
 * @author Minh Thu
 */
public class searchKH {

    public int search(ArrayList<customer> list, String strInfor) {
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getEmail().contains(strInfor) || list.get(i).getAddress().contains(strInfor) || list.get(i).getPhoneNumber().equals(strInfor)) {
                return 1;
            }
        }
        return 0;
    }

    public void searchEmail(ArrayList<customer> list) {
        listKH kh = new listKH();
        String email;
        //ArrayList<customer> listSearch = new ArrayList();
        System.out.println("Moi ban nhap email muon tim : ");
        Scanner sc = new Scanner(System.in);
        email = sc.nextLine();
        if (search(list, email) == 0) {
            System.out.println("=======<< KHONG TIM THAY KHACH HANG >>=======");
        } else {
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            System.out.println("| ID |          TEN KHACH HANG        |         SDT          |             EMAIL                |   POINTS |       Que quan    |");
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmail().contains(email) == true && !list.get(i).getUserName().equals("ADMINCustomer")) {
                    kh.showInfor(list.get(i));
                }
            }
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
        }

    }

    public void searchPhone(ArrayList<customer> list) {
        listKH kh = new listKH();
        String phone;
        //ArrayList<customer> listSearch = new ArrayList();
        System.out.println("Moi ban nhap so dien thoai can tim : ");
        Scanner sc = new Scanner(System.in);
        phone = sc.nextLine();
        if (search(list, phone) == 0) {
            System.out.println("=======<< KHONG TIM THAY KHACH HANG >>=======");
        } else {
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            System.out.println("| ID |          TEN KHACH HANG        |         SDT          |             EMAIL                |   POINTS |       Que quan    |");
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            for (int i = 0; i < list.size(); i++) {
                if (phone.equals(list.get(i).getPhoneNumber()) && !list.get(i).getUserName().equals("ADMINCustomer")) {
                    kh.showInfor(list.get(i));
                }
            }
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|------------------|");
        }
    }

    public void searchAddress(ArrayList<customer> list) {
        listKH kh = new listKH();
        String address;
        //ArrayList<customer> listSearch = new ArrayList();
        System.out.println("Moi ban nhap dia chi can tim : ");
        Scanner sc = new Scanner(System.in);
        address = sc.nextLine();
        if (search(list, address) == 0) {
            System.out.println("=======<< KHONG TIM THAY KHACH HANG >>=======");
        } else {
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            System.out.println("| ID |          TEN KHACH HANG        |         SDT          |             EMAIL                |   POINTS |       Que quan    |");
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i).getAddress().contains(address) && !list.get(i).getUserName().equals("ADMINCustomer")) {
                    kh.showInfor(list.get(i));
                }
            }
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
        }

    }

    public customer showCustomer(ArrayList<customer> list, String user) {
        customer cus = new customer();
        listKH kh = new listKH();
        for (int i = 0; i < list.size(); i++) {
            if (user.equals(list.get(i).getUserName())) {
                System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
                System.out.println("| ID |          TEN KHACH HANG        |         SDT          |             EMAIL                |   POINTS |       Que quan    |");
                System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
                kh.showInfor(list.get(i));
                System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
                cus = list.get(i);
            }
        }
        return cus;

    }

    public void showCustomerExist(ArrayList<customer> list) {
        listKH kh  = new listKH();
        if (list.size() == 1) {
            System.out.println("=======<< DANH SACH TRONG! KHONG CO KHACH HANG NAO >>=======");
        } else {
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            System.out.println("| ID |          TEN KHACH HANG        |         SDT          |             EMAIL                |   POINTS |       Que quan    |");
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i).getStatus() == 1 && !list.get(i).getUserName().equals("ADMINCustomer")) {
                    kh.showInfor(list.get(i));
                }
            }
            System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
        }
    }
}
