package com.example.load_apis.Repository;

import com.example.load_apis.Model.payLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface payLoadRepository extends JpaRepository<payLoad, Integer> {


    payLoad findByShipperId(String shipperId);
}
