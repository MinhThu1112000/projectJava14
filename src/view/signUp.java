/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.checkAccount;
import controller.timeNow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.customer;

/**
 *
 * @author Minh Thu
 */
public class signUp {

    // khai bao list//
    //ArrayList<customer> list = new ArrayList<>();
    //goi class checkAccount//
    checkAccount check = new checkAccount();

    // Viet vao file//
    public void writeFile(String fileName, ArrayList<customer> list) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        String data = "";
        for (int i = 0; i < list.size(); i++) {
            String row = "";
            row += list.get(i).getID() + "\t";
            row += list.get(i).getUserName() + "\t";
            row += list.get(i).getFullName() + "\t";
            row += list.get(i).getPassWord() + "\t";
            row += list.get(i).getEmail() + "\t";
            row += list.get(i).getPhoneNumber() + "\t";
            row += list.get(i).getDateOfBirth() + "\t";
            row += list.get(i).getAddress() + "\t";
            row += list.get(i).getStartDate() + "\t";
            row += list.get(i).getEndDate() + "\t";
            row += list.get(i).getSex() + "\t";
            row += Integer.toString(list.get(i).getStatus()) + "\t";
            row += Integer.toString(list.get(i).getPoints()) + "\t";
            data += row + "\n";
        }
        bw.write(data);
        bw.flush();
        bw.close();

    }
//Doc file//

    public void readFile(String fileName, ArrayList<customer> list1) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String strInfor;
        while ((strInfor = br.readLine()) != null) {
            String str[] = strInfor.split("\t");
            customer customer = new customer();
            //Gan cac trương vao mang//
            customer.setID(str[0]);
            customer.setUserName(str[1]);
            customer.setFullName(str[2]);
            customer.setPassWord(str[3]);
            customer.setEmail(str[4]);
            customer.setPhoneNumber(str[5]);
            customer.setDateOfBirth(str[6]);
            customer.setAddress(str[7]);
            customer.setStartDate(str[8]);
            customer.setEndDate(str[9]);
            customer.setSex(str[10]);
            customer.setStatus(Integer.parseInt(str[11]));
            customer.setPoints(Integer.parseInt(str[12]));
            list1.add(customer);
        }

    }

    public void signUpUser(ArrayList<customer> list) throws IOException, InterruptedException {
        String ID;
        String user = "";
        String fullName1 = "";
        String pass = "";
        String passAgain;
        String phone = "";
        String email = "";
        String dateOfBirth = "";
        String address = "";
        String generate = "";
        String startDate = "";
        String endDate = "";
        int status = 0;
        int points;
        customer cus = new customer();
        System.out.println("*****---------------DANG KY TAI KHOAN-------------*****");
        //Dang ky ID//
        do {
            System.out.println("Nhap ID : ");
            Scanner sc = new Scanner(System.in);
            ID = sc.nextLine();
            //System.out.println(check.checkID(ID, list));
            if (!check.checkID(ID, list)) {
                Thread.sleep(150);
                System.err.println("***CHU Y : ID bi trung! Moi nhap lai !");
                Thread.sleep(150);
            }
        } while (!check.checkID(ID, list));
        cus.setID(ID);
        System.out.println("<<   THANH CONG   >>");
        //Nhap userName//
        do {
            System.out.println("Nhap username: ");
            Scanner sc = new Scanner(System.in);
            user = check.account("^(?=.*[A-Za-z])[A-Za-z0-9]{6,}$", user, "UserName", "UserName khong co ky tu dac biet va co do dai toi thieu la 6!");
            if(check.checkUser(user, list)){
                Thread.sleep(150);
                System.err.println("***Canh bao : User da ton tai! Moi ban dang ky bang user khac!");
                Thread.sleep(150);
            }
        }  while(check.checkUser(user, list));
        cus.setUserName(user);
        System.out.println("<<   THANH CONG   >>");
        //Nhap fullName//
        fullName1 = check.fullName(fullName1, "ten day du cua ban");
        cus.setFullName(fullName1);
        System.out.println("<<   THANH CONG   >>");
        //Nhap pass//
        do {
            pass = check.account("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$", pass, "PassWord", "PASSWORD phai co toi thieu 8 ky tu va it nhat 1 ky tu chu");
            System.out.println("Moi ban nhap lai pass : ");
            Scanner sc = new Scanner(System.in);
            passAgain = sc.nextLine();
            if (!passAgain.equals(pass)) {
                Thread.sleep(150);
                System.err.println("*** Mat khau khong khop!");
                Thread.sleep(150);
            }
        } while (!passAgain.equals(pass));
        cus.setPassWord(pass);
        System.out.println("<<   THANH CONG   >>");
        //Nhap phone//
        phone = check.account("^0[35789][0-9]{8,}", phone, "Phone Number", "Phone đúng định dạng!");
        cus.setPhoneNumber(phone);
        System.out.println("<<   THANH CONG   >>");
        //Nhap email//
        email = check.account("^[A-Za-z0-9]{1,}@gmail.com$", email, "Email", "Email phai dung dinh dang!");
        cus.setEmail(email);
        System.out.println("<<   THANH CONG   >>");
        //Nhap ngay sinh//
        dateOfBirth = check.account("^[0-3]{1}[0-9]{1}/[0-9]{1,2}/[0-9]{4}$", dateOfBirth, "date of birth", "Ngay sinh phai dung (dd/MM/YYYY)");
        cus.setDateOfBirth(dateOfBirth);
        System.out.println("<<   THANH CONG   >>");
        //Nhap dia chi//
        address = check.addressHome(address, "que cua ban");
        cus.setAddress(address);
        System.out.println("<<   THANH CONG   >>");
        //Nhap gioi tinh//
        generate = check.account("N[au]{1}[m]?", generate, "gioi tinh", "Nu/Nam");
        cus.setSex(generate);
        System.out.println("<<   THANH CONG   >>");
        //Nhap trang thai hoat dong//
        do {
            System.out.println("Nhap trang thai hoat dong : ");
            Scanner sc = new Scanner(System.in);
            status = sc.nextInt();
            if (status != 0 && status != 1) {
                System.out.println("Nhap 0 hoac 1 (0 : no active || 1 : active)");
            }
        } while (status != 0 && status != 1);
        cus.setStatus(status);
        System.out.println("<<   THANH CONG   >>");
        if (status == 0) {
            //Nhap ngay bat dau lap tai khoan//
            startDate = check.account("^[0-3]{1}[0-9]{1}/[0-9]{1,2}/[0-9]{4}$", startDate, "Ngay bat dau hoat dong", "dinh dang dd/MM/YYYY");
            cus.setStartDate(startDate);
            do {
                endDate = check.account("^[0-3]{1}[0-9]{1}/[0-9]{1,2}/[0-9]{4}$", startDate, "Ngay ket thuc hoat dong", "dinh dang dd/MM/YYYY");
                if (!check.checkEndStart(startDate, endDate)) {
                    Thread.sleep(150);
                    System.err.println("Nhap khong dung ( Ngay ket thuc be hon ngay bat dau)");
                    Thread.sleep(150);
                }
            } while (!check.checkEndStart(startDate, endDate));
            cus.setEndDate(endDate);
        } else {
            timeNow time = new timeNow();            
            final String start = time.timeFinal();
            startDate = start;
            cus.setStartDate(startDate);
        }
        System.out.println("<<   THANH CONG   >>");
        list.add(cus);
        writeFile("customer.txt", list);
        System.out.println("*****----------DANG KY TAI KHOAN THANH CONG--------*****");

    }
}
