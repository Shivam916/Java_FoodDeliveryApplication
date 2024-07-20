package com.FoodDelivery.SpringProject.Menu;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getAll(){
        return menuService.getAll();
    }

    @GetMapping("/{id}")
    public Menu getById(@PathVariable Long id){
        return menuService.getById(id);
    }

    @PostMapping("/create")
    public String createMenu(@RequestBody Menu menu){
        menuService.createMenu(menu);
        return "Successfully Added!";
    }

    @PutMapping("/{id}")
    public String updateMenu(@PathVariable Long id, @RequestBody Menu menu){
        if(menuService.updateMenu(id, menu)) return "Successfully Updated!";
        else{
            return "Menu not Found";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        if(menuService.deleteById(id)) return "Successfully Deleted!";
        else{
            return "Menu not Found";
        }
    }

}
