package edu.mga.restapi.henrybooks.repositories;

import edu.mga.restapi.henrybooks.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    List<Inventory> findAll();
    Inventory findById(Integer id);
    Inventory save(Inventory book);
    void deleteById(Integer id);
    Inventory findByBookIdAndBranchId(Integer bookId, Integer branchId);
    List<Inventory> findByBranchId(Integer branchId);
    List<Inventory> findByBookId(Integer bookId);
}
