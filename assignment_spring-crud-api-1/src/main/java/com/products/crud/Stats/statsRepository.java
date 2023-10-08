package com.products.crud.Stats;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("statsRepository")
public interface statsRepository extends CrudRepository<stats, Integer> {


}