package com.demo.service;

import com.demo.entity.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();
    Object findById(int partId);
    void saveOrUpdate(Part thePart);
    void deleteById(int partId);
}
