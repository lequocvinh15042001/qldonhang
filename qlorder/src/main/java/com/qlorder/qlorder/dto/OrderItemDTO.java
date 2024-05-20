package com.qlorder.qlorder.dto;

public class OrderItemDTO {

    private int maSanPham;
    private String tenSanPham;
    private int soLuong;
    private double gia;

    public OrderItemDTO(int id, String productName, int quantity, double price) {
        this.maSanPham = id;
        this.tenSanPham = productName;
        this.soLuong = quantity;
        this.gia = price;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
