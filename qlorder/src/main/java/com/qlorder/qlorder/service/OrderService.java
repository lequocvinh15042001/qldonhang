package com.qlorder.qlorder.service;

import com.qlorder.qlorder.dto.OrderDTO;
import com.qlorder.qlorder.dto.OrderItemDTO;
import com.qlorder.qlorder.entity.OrderEntity;
import com.qlorder.qlorder.entity.OrderItemEntity;
import com.qlorder.qlorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrder(){
       return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO addNewOrder(OrderDTO orderDTO){
        OrderEntity order = new OrderEntity();
        order.setCustomerName(orderDTO.getTenNguoiDat());
        order.setCustomerEmail(orderDTO.getEmailNguoiDat());

        OrderEntity finalOrder = order;
        List<OrderItemEntity> orderItems = orderDTO.getDanhSachDon().stream().map(itemDTO -> {
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setProductName(itemDTO.getTenSanPham());
            orderItem.setQuantity(itemDTO.getSoLuong());
            orderItem.setPrice(itemDTO.getGia());
            orderItem.setOrder(finalOrder);
            return orderItem;
        }).collect(Collectors.toList());

        order.setItems(orderItems);
        order = orderRepository.save(order);
        return convertToDTO(order);
    }

    public void deleteOrderById(int id){
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
        }else {
            throw new RuntimeException("Order khong ton tai voi id = " + id);
        }
    }

    private OrderDTO convertToDTO(OrderEntity order) {
        List<OrderItemDTO> orderItemDTOs = order.getItems().stream()
                .map(item -> new OrderItemDTO(item.getId(), item.getProductName(), item.getQuantity(), item.getPrice()))
                .collect(Collectors.toList());

        return new OrderDTO(order.getId(), order.getCustomerName(), order.getCustomerEmail(), orderItemDTOs);
    }


}
