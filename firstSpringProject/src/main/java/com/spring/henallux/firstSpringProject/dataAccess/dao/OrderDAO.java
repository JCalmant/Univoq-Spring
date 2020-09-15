package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDAO {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter){
        this.orderRepository=orderRepository;
        this.providerConverter=providerConverter;
    }

    public Order save(Order order){
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderEntity = orderRepository.save(orderEntity);
        return providerConverter.orderEntityToOrderModel(orderEntity);
    }
}
