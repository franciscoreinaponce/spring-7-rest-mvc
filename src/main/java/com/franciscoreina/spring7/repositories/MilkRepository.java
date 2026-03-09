package com.franciscoreina.spring7.repositories;

import com.franciscoreina.spring7.domain.Milk;
import com.franciscoreina.spring7.domain.MilkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MilkRepository extends JpaRepository<Milk, UUID> {

    List<Milk> findAllByNameContainingIgnoreCase(String name);

    List<Milk> findAllByMilkType(MilkType milkType);

    List<Milk> findAllByNameContainingIgnoreCaseAndMilkType(String name, MilkType milkType);

}
