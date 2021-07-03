package br.edu.usj.ads.pw.cardlistbackend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long>{
    List<Card> findAll();
}
