package com.franciscoreina.spring7.services;

import com.franciscoreina.spring7.domain.Milk;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MilkService {

    Milk create(Milk milk);

    Optional<Milk> getById(UUID milkId);

    List<Milk> list();

    void update(UUID milkId, Milk milk);

    void deleteById(UUID milkId);

}
