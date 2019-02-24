package edu.mga.restapi.henrybooks.services;

import edu.mga.restapi.henrybooks.model.Branch;
import edu.mga.restapi.henrybooks.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BranchService {

    @Autowired
    BranchRepository BranchRepository;

    public boolean addBranch(Branch Branch) {
        System.out.println(BranchRepository.save(Branch));
        return true;
    }

    @Transactional
    public boolean updateBranch(Branch Branch) {
        Branch Branch1 = BranchRepository.findById(Branch.getId());
        if (null == Branch1)
            return false;
        BranchRepository.save(Branch);
        return true;
    }

    @Transactional
    public boolean deleteBranch(Integer id) {
        Branch Branch = BranchRepository.findById(id);
        if (null == Branch)
            return false;
//        BranchList.remove(id);
        BranchRepository.deleteById(id);
        return true;
    }

    public Branch getBranch(Integer id) {
//        return BranchList.get(id);
        return BranchRepository.findById(id);
    }

    public List<Branch> getBranches() {
        return BranchRepository.findAll();
    }



}
