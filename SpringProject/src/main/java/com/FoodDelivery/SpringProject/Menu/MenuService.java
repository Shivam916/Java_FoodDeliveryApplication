package com.FoodDelivery.SpringProject.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAll();

    boolean updateMenu(Long id, Menu menu);

    void createMenu(Menu menu);
    Menu getById(Long id);

    boolean deleteById(Long id);
}
