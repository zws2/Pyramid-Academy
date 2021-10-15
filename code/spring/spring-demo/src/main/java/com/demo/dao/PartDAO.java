package com.demo.dao;

import com.demo.entity.Part;

import java.util.List;

public interface PartDAO {
    List<Part> findAll();
    Object findById(int theId);
    void saveOrUpdate(Part thePart);
    void deleteById(int theId);
}
