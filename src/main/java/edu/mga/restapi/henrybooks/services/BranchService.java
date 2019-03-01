package edu.mga.restapi.henrybooks.services;

import edu.mga.restapi.henrybooks.model.Branch;
import edu.mga.restapi.henrybooks.model.Inventory;
import edu.mga.restapi.henrybooks.repositories.BranchRepository;
import edu.mga.restapi.henrybooks.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    public boolean addBranch(Branch Branch) {
        System.out.println(branchRepository.save(Branch));
        return true;
    }

    @Transactional
    public boolean updateBranch(Branch Branch) {
        Branch Branch1 = branchRepository.findById(Branch.getId());
        if (null == Branch1)
            return false;
        branchRepository.save(Branch);
        return true;
    }

    @Transactional
    public boolean deleteBranch(Integer id) {

        List<Inventory> inventoryList = inventoryRepository.findByBranchId(id);
        for (Inventory inventory : inventoryList)
            inventoryRepository.delete(inventory);

        Branch Branch = branchRepository.findById(id);
        if (null == Branch)
            return false;
//        BranchList.remove(id);
        branchRepository.deleteById(id);
        return true;
    }

    public Branch getBranch(Integer id) {
//        return BranchList.get(id);
        return branchRepository.findById(id);
    }

    public List<Branch> getBranches() {
        return branchRepository.findAll();
    }



}
