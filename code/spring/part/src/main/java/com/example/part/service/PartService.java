package com.example.part.service;

import com.example.part.entity.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();
    Object findById(int partId);
    void saveOrUpdate(Part thePart);
    void deleteById(int partId);
}
