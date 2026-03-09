package com.franciscoreina.spring7.services;

import com.franciscoreina.spring7.domain.MilkType;
import com.franciscoreina.spring7.dtos.milk.MilkCreateRequest;
import com.franciscoreina.spring7.dtos.milk.MilkPatchRequest;
import com.franciscoreina.spring7.dtos.milk.MilkResponse;
import com.franciscoreina.spring7.dtos.milk.MilkUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MilkService {

    MilkResponse create(MilkCreateRequest request);

    MilkResponse getById(UUID milkId);

    Page<MilkResponse> list(String name, MilkType milkType, Pageable pageable);

    void update(UUID milkId, MilkUpdateRequest request);

    void patch(UUID milkId, MilkPatchRequest request);

    void delete(UUID milkId);

}
