package com.gop.GangsOfPav.service;

import com.gop.GangsOfPav.entity.MenuItem;
import com.gop.GangsOfPav.repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuItemRepository menuItemRepository;

    public MenuService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAllItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> getByCategory(String category) {
        return menuItemRepository.findByCategory_Name(category);
    }
}
