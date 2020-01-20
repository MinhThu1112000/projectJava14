/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Minh Thu
 */
public class product {
    private String id;
    private String nameProduct;
    private String unit;// đơn vị tính
    private String retail;//giá bán lẻ
    private String wholesale;// giá bán buôn
    private int amount; //số lượng
    private boolean status; // trạng thái còn hàng hay hết hàng

    public product() {
    }

    public product(String id, String nameProduct, String unit, String retail, String wholesale, int amount, boolean status) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.unit = unit;
        this.retail = retail;
        this.wholesale = wholesale;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRetail() {
        return retail;
    }

    public void setRetail(String retail) {
        this.retail = retail;
    }

    public String getWholesale() {
        return wholesale;
    }

    public void setWholesale(String wholesale) {
        this.wholesale = wholesale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
