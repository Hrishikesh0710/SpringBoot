package com.gop.GangsOfPav.controller;

import com.gop.GangsOfPav.entity.MenuItem;
import com.gop.GangsOfPav.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:5173")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 🔹 Get ALL items
    @GetMapping
    public List<MenuItem> getAll() {
        return menuService.getAllItems();
    }

    // 🔹 Get by category
    @GetMapping("/category/{name}")
    public List<MenuItem> getByCategory(@PathVariable String name) {
        return menuService.getByCategory(name);
    }
}
