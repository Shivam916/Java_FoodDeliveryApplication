package com.FoodDelivery.SpringProject.Menu.impl;

import com.FoodDelivery.SpringProject.Menu.Menu;
import com.FoodDelivery.SpringProject.Menu.MenuRepository;
import com.FoodDelivery.SpringProject.Menu.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImp implements MenuService {
    private MenuRepository menuRepository;

    public MenuServiceImp(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
    public void createMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public boolean updateMenu(Long id, Menu menu) {
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if(menuOptional.isPresent()){
            Menu m = menuOptional.get();
            m.setName(menu.getName());
            m.setRestaurant(menu.getRestaurant());
            menuRepository.save(m);
            return true;
        }
        return false;
    }

    @Override
    public Menu getById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if(menuRepository.existsById(id)){
            menuRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
