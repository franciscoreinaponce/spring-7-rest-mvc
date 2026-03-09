package com.franciscoreina.spring7.services;

import com.franciscoreina.spring7.domain.Milk;
import com.franciscoreina.spring7.domain.MilkType;
import com.franciscoreina.spring7.dtos.milk.MilkCreateRequest;
import com.franciscoreina.spring7.dtos.milk.MilkPatchRequest;
import com.franciscoreina.spring7.dtos.milk.MilkResponse;
import com.franciscoreina.spring7.dtos.milk.MilkUpdateRequest;
import com.franciscoreina.spring7.exceptions.NotFoundException;
import com.franciscoreina.spring7.mappers.MilkMapper;
import com.franciscoreina.spring7.repositories.MilkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MilkServiceImpl implements MilkService {

    private final MilkRepository milkRepository;
    private final MilkMapper milkMapper;

    @Override
    public MilkResponse create(MilkCreateRequest request) {
        Milk saved = milkRepository.save(milkMapper.toEntity(request));
        return milkMapper.toResponse(saved);
    }

    @Override
    public MilkResponse getById(UUID milkId) {
        Milk milk = getMilkOrThrow(milkId);
        return milkMapper.toResponse(milk);
    }

    @Override
    public List<MilkResponse> list(String name, MilkType milkType) {
        if (name != null && milkType != null) { // Search by name and milkType
            return milkRepository.findAllByNameContainingIgnoreCaseAndMilkType(name, milkType)
                    .stream()
                    .map(milkMapper::toResponse)
                    .toList();
        }

        if (name != null) { // Search by name
            return milkRepository.findAllByNameContainingIgnoreCase(name)
                    .stream()
                    .map(milkMapper::toResponse)
                    .toList();
        }

        if (milkType != null) { // Search by milkType
            return milkRepository.findAllByMilkType(milkType)
                    .stream()
                    .map(milkMapper::toResponse)
                    .toList();
        }

        return milkRepository.findAll() // Search all
                .stream()
                .map(milkMapper::toResponse)
                .toList();
    }

    @Transactional
    @Override
    public void update(UUID milkId, MilkUpdateRequest request) {
        Milk milkToUpdate = getMilkOrThrow(milkId);
        milkMapper.updateEntity(milkToUpdate, request);
        milkRepository.save(milkToUpdate);
    }

    @Transactional
    @Override
    public void patch(UUID milkId, MilkPatchRequest request) {
        Milk milkToPatch = getMilkOrThrow(milkId);
        milkMapper.patchEntity(milkToPatch, request);
        milkRepository.save(milkToPatch);
    }

    @Override
    public void delete(UUID milkId) {
        Milk milk = getMilkOrThrow(milkId);
        milkRepository.delete(milk);
    }

    private Milk getMilkOrThrow(UUID milkId) {
        return milkRepository.findById(milkId)
                .orElseThrow(() -> new NotFoundException("Milk not found: " + milkId));
    }
}
