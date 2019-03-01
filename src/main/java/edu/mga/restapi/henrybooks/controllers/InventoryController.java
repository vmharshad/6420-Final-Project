package edu.mga.restapi.henrybooks.controllers;

import edu.mga.restapi.henrybooks.model.Book;
import edu.mga.restapi.henrybooks.model.Inventory;
import edu.mga.restapi.henrybooks.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/inventories/{id}", produces = "application/json")
    public @ResponseBody Inventory getInventoryById(@PathVariable int id) {
        return inventoryService.getInventory(id);
    }

    @GetMapping(value = "/inventories", produces = "application/json")
    public @ResponseBody List<Inventory> getInventories() {
        return inventoryService.getInventories();
    }

    @GetMapping(value = "/inventories/branches/{branchId}", produces = "application/json")
    public @ResponseBody List<Inventory> getInventoriesByBranch(@PathVariable Integer branchId) {
        return inventoryService.getInventoriesByBranchId(branchId);
    }

    @PostMapping(value = "/inventories/branches/{branchId}/books/{bookId}/quantity/{quantity}", consumes = "application/json")
    public void addInventory(@PathVariable Integer branchId, @PathVariable Integer bookId, @PathVariable Integer quantity) throws Exception {

        if (inventoryService.addInventory(branchId, bookId, quantity))
            return;
        else
            throw new Exception("Unable to add Inventory");
    }

    @PutMapping(value = "/inventories/branches/{branchId}/books/{bookId}/quantity/{quantity}", consumes = "application/json")
    public void updateInventory(@PathVariable Integer branchId, @PathVariable Integer bookId, @PathVariable Integer quantity) throws Exception {
        if (inventoryService.updateInventory(branchId, bookId, quantity))
            return;
        else
            throw new Exception("Unable to add Inventory");
    }

    @DeleteMapping(value = "/inventories/{id}")
    public boolean deleteInventory(@PathVariable int id) throws Exception {
        if (null == inventoryService.getInventory(id))
            throw new Exception("Unable to find book to delete");

        if (inventoryService.deleteInventory(id))
            return true;

        throw new Exception("Unable to update book");
    }
}
