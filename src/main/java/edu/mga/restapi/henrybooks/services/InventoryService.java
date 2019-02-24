package edu.mga.restapi.henrybooks.services;

import edu.mga.restapi.henrybooks.model.Book;
import edu.mga.restapi.henrybooks.model.Branch;
import edu.mga.restapi.henrybooks.model.Inventory;
import edu.mga.restapi.henrybooks.repositories.BookRepository;
import edu.mga.restapi.henrybooks.repositories.BranchRepository;
import edu.mga.restapi.henrybooks.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    private EntityManager entityManager;

    public boolean addInventory(Integer branchId, Integer bookId, Integer quantity) throws Exception {
        Book book = bookRepository.findById(bookId);
        if (null == book)
            throw new Exception("Unable to find book");

        Branch branch = branchRepository.findById(branchId);

        if (null == branch)
            throw new Exception("Unable to find branch");

        Inventory inventory = new Inventory();
        inventory.setBook(book);
        inventory.setBranch(branch);
        inventory.setQuantity(quantity);

        inventoryRepository.save(inventory);
        return true;
    }

    @Transactional
    public boolean updateInventory(Integer branchId, Integer bookId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByBookIdAndBranchId(bookId, branchId);
        System.out.println("inventory = " + inventory);
        if (null == inventory)
            return false;

        if (quantity == 0)
            inventoryRepository.delete(inventory);

        inventory.setQuantity(quantity);
//        entityManager.merge(inventory);

        return true;
    }

    @Transactional
    public boolean deleteInventory(Integer id) {
        Inventory Inventory = inventoryRepository.findById(id);
        if (null == Inventory)
            return false;
//        InventoryList.remove(id);
        inventoryRepository.deleteById(id);
        return true;
    }

    public Inventory getInventory(Integer id) {
//        return InventoryList.get(id);
        return inventoryRepository.findById(id);
    }

    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    public List<Book> getInventoriesByBranchId(Integer branchId) {
        System.out.println("Find all count = " + inventoryRepository.findAll().size());
        System.out.println("branchId = " + branchId);
        System.out.println("Find by branch id = " + inventoryRepository.findByBranchId(branchId));

        List<Inventory> inventories = inventoryRepository.findByBranchId(branchId);
        List<Book> bookList= new ArrayList<>();

        if (null != inventories)
            for (Inventory inventory : inventories) {
                bookList.add(inventory.getBook());
            }

        return bookList;
    }

}
