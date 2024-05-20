package com.qlorder.qlorder.controller;

import com.qlorder.qlorder.dto.OrderDTO;
import com.qlorder.qlorder.entity.OrderEntity;
import com.qlorder.qlorder.response.BaseResponse;
import com.qlorder.qlorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllOrder(){
        List<OrderDTO> orders = orderService.getAllOrder();
        BaseResponse<List<OrderDTO>> response = new BaseResponse<>(200, "Lay danh sach thanh cong", orders);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewOrder(@RequestBody OrderDTO order){
        OrderDTO orderAdd = orderService.addNewOrder(order);
        BaseResponse<OrderDTO> response = new BaseResponse<>(200, "Them moi order thanh cong", orderAdd);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable int id){
        try{
            orderService.deleteOrderById(id);
            BaseResponse<?> response = new BaseResponse<>(200, "Xoa order thanh cong", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (RuntimeException e){
            BaseResponse<?> response = new BaseResponse<>(404, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
