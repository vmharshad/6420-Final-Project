package edu.mga.restapi.henrybooks.repositories;

import edu.mga.restapi.henrybooks.model.Book;
import edu.mga.restapi.henrybooks.model.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
    List<Branch> findAll();
    Branch findById(Integer id);
    Branch save(Branch book);
    void deleteById(Integer id);
}
