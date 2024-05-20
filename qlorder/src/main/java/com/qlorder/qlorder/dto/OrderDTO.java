package com.qlorder.qlorder.dto;

import com.qlorder.qlorder.entity.OrderItemEntity;

import java.util.List;

public class OrderDTO {

    private int maDonHang;
    private String tenNguoiDat;
    private String emailNguoiDat;

    private List<OrderItemDTO> danhSachDon;

    public OrderDTO(int id, String customerName, String customerEmail, List<OrderItemDTO> items) {
        this.maDonHang = id;
        this.tenNguoiDat = customerName;
        this.emailNguoiDat = customerEmail;
        this.danhSachDon = items;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getTenNguoiDat() {
        return tenNguoiDat;
    }

    public void setTenNguoiDat(String tenNguoiDat) {
        this.tenNguoiDat = tenNguoiDat;
    }

    public String getEmailNguoiDat() {
        return emailNguoiDat;
    }

    public void setEmailNguoiDat(String emailNguoiDat) {
        this.emailNguoiDat = emailNguoiDat;
    }

    public List<OrderItemDTO> getDanhSachDon() {
        return danhSachDon;
    }

    public void setDanhSachDon(List<OrderItemDTO> danhSachDon) {
        this.danhSachDon = danhSachDon;
    }
}
