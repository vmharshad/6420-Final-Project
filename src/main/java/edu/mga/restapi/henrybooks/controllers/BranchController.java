package edu.mga.restapi.henrybooks.controllers;

import edu.mga.restapi.henrybooks.model.Branch;
import edu.mga.restapi.henrybooks.services.BookService;
import edu.mga.restapi.henrybooks.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping(value = "/branches/{id}", produces = "application/json")
    public @ResponseBody Branch getBranch(@PathVariable int id) {
        return branchService.getBranch(id);
    }

    @GetMapping(value = "/branches/{id}/books", produces = "application/json")
    public @ResponseBody Branch getBooksByBranch(@PathVariable int id) {
        return branchService.getBranch(id);
    }

    @GetMapping(value = "/branches", produces = "application/json")
    public @ResponseBody List<Branch> getBooks() {
        return branchService.getBranches();
    }

    @PostMapping(value = "/branches", consumes = "application/json")
    public void addBook(@RequestBody Branch branch) throws Exception {
        System.out.println("branch = " + branch);
        if (branchService.addBranch(branch))
            return;
        else
            throw new Exception("Unable to add branch");
    }

    @PutMapping(value = "/branches/{id}", consumes = "application/json")
    public boolean updateBook(@PathVariable int id, @RequestBody Branch branch) throws Exception {
        if (null == branchService.getBranch(id) || null == branch)
            throw new Exception("Unable to update branch");

        // Just to make sure the pathparam id is the same as branch.id
        branch.setId(id);

        if (branchService.updateBranch(branch))
            return true;

        throw new Exception("Unable to update branch");
    }

    @DeleteMapping(value = "/branches/{id}")
    public boolean updateBook(@PathVariable int id) throws Exception {
        if (null == branchService.getBranch(id))
            throw new Exception("Unable to find book to delete");

        if (branchService.deleteBranch(id))
            return true;

        throw new Exception("Unable to update book");
    }
}
