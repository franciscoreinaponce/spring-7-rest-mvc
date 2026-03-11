package com.franciscoreina.spring7.repositories;

import com.franciscoreina.spring7.domain.MilkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface MilkOrderRepository extends JpaRepository<MilkOrder, UID> {
}
