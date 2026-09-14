package com.chhetriSom.billingSoftware.repository;

import com.chhetriSom.billingSoftware.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {

}
