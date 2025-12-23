package com.gop.GangsOfPav.repository;

import com.gop.GangsOfPav.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory_Name(String name);
}
