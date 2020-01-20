/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.customer;

/**
 *
 * @author Minh Thu
 */
public class listKH {
    public void showInfor(customer cus){
        //System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
        //System.out.println("| ID |          TEN KHACH HANG        |         SDT          |             EMAIL                |   POINTS |       Que quan    |");
        //System.out.println("|----|--------------------------------|----------------------|----------------------------------|----------|-------------------|");
        System.out.printf("|%4s|%32s|%22s|%34s|%10d|%19s\n",cus.getID(),cus.getFullName(),cus.getPhoneNumber(),cus.getEmail(),cus.getPoints(),cus.getAddress());
    }     
    
//    4,34,22,34,10
}
