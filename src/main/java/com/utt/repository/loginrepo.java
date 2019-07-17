package com.utt.repository;

import com.utt.dto.logindto;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface loginrepo extends ElasticsearchRepository<logindto,String> {

}
