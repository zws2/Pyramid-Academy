package com.example.part.dao;

import com.example.part.entity.Part;

import java.util.List;

public interface PartDAO {
    List<Part> findAll();
    Object findById(int theId);
    void saveOrUpdate(Part thePart);
    void deleteById(int theId);
}
