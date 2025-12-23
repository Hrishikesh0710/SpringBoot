package com.gop.GangsOfPav.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_categories")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;   

    public MenuCategory() {}

    public MenuCategory(String name) {
        this.name = name.toLowerCase();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
