/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.customer;

/**
 *
 * @author Minh Thu
 */
public class checkAccount {

    public String account(String regex, String infor, String nameInfor, String request) throws InterruptedException {
        System.out.println("Moi ban nhap " + nameInfor + " : ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            infor = sc.nextLine();
            if (infor.matches(regex)) {
                break;
            } else {
                Thread.sleep(200);
                System.err.println("***CHU Y: "+nameInfor + " khong hop le!" + "( " + request + " )");
                Thread.sleep(200);
                System.out.println("Moi ban nhap lai " + nameInfor + " : ");
            }
        }
        return infor;
    }

    public String nhapTownName(String name, String infor) {
        System.out.println("Mời bạn nhập " + infor + " : ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        name = name.trim();
        return name;
    }

    public String addressHome(String address, String infor) throws InterruptedException {
        address = nhapTownName(address, infor);
        String str[] = address.split("\\s");
        String fixStr = "^[A-Z]{1}[a-z0-9]{1,}$";
        String newString = "";
        for (String string : str) {
            if (string.matches(fixStr)) {
                newString += string + " ";
            } else {
                Thread.sleep(150);
                System.err.println("***CHU Y : Không đúng định dạng!");
                Thread.sleep(150);
                return addressHome(address, infor);
            }
        }
        return newString;
    }

    public String fullName(String fullName, String infor) throws InterruptedException {
        fullName = nhapTownName(fullName, infor);
        String str[] = fullName.split("\\s");
        String fixStr = "^[A-Z]{1}[a-z0-9]+$";
        String newString = "";
        for (String string : str) {
            if (string.matches(fixStr)) {
                newString += string + " ";
            } else {
                Thread.sleep(150);
                System.err.println("\tKhông đúng định dạng!");
                Thread.sleep(150);
                return fullName(fullName, infor);
            }
        }
        return newString;
    }

    public boolean checkEndStart(String start, String end) {
        boolean z ;
        String[] arr = start.split("/");
        String[] arr1 = end.split("/");
        int[] arr2 = new int[3];
        int[] arr3 = new int[3];
        int i = 0;
        int j = 0;
        for (String string : arr) {
            arr2[i] = Integer.parseInt(string);
            i++;
        }
        for (String str : arr1) {
            arr3[j] = Integer.parseInt(str);
            j++;
        }
        for (int k = 2; k >= 0; k--) {
            if (arr2[k] > arr3[k]) {
                return false;
            }else if(arr2[k] == arr3[k]){
                z = true;
            }else{
                z = true;
            }
        }
        if(z = true) return true;
       
        return true;
        

    }

    public boolean checkID(String ID, ArrayList<customer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (ID.equals(list.get(i).getID())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUser(String user, ArrayList<customer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassWord(String pass, ArrayList<customer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (pass.equals(list.get(i).getPassWord())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkUser1(String user, ArrayList<customer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(user) ) {
                if(list.get(i).getStatus() == 1){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean chenhLech(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(date1,formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(date2, formatter);
        long diffInMilli = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
        if(diffInMilli > 172800){
            return true;
        }
        return false;
    }
}
