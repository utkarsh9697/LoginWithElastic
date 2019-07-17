package com.utt.loginservice.impl;

import com.utt.dto.logindto;
import com.utt.exceptions.NotFoundException;
import com.utt.loginservice.loginservice;
import com.utt.repository.loginrepo;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class loginserviceimpl implements loginservice {
    @Autowired
    loginrepo loginrepo;

    @Autowired
    Optional optional;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public Optional<logindto> dosomething(logindto logindto) {


        if (!((loginrepo.findById(logindto.getId())).isPresent())) {

            com.utt.dto.logindto resp = new logindto();
            resp.setId(logindto.getId());
            resp.setName(logindto.getName());
            resp.setPhone(logindto.getPhone());

//            try {
//                resp.setProfilePicture(multipartFile);
//            }catch (Exception ex)
//            {
//                throw new BadRequestException("Error is "+ ex);
//            }
            loginrepo.save(resp);
        }

        else
        {
            System.out.println("Value shown without setting directly from repository");
        }
        String id=logindto.getId();
        return loginrepo.findById(id);
    }

    @Override
    public Optional getone(String id)
    {

        Optional resp;
        resp =loginrepo.findById(id);
        if ( resp.isPresent())
        {
            return resp;
        }
        else
        {
            throw new NotFoundException("User credentials not present for the id " + id);
        }
    }

    @Override
    public Iterable<logindto> getall()
    {
        return   loginrepo.findAll();
    }

    @Override
    public List<logindto> elasticquery(String text)
    {

        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)
                                .field("phone")
                                .field("id")
                ).should(QueryBuilders.queryStringQuery(text + "*")
                        .lenient(true)
                        .field("id")
                .field("phone"));
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<logindto> result = elasticsearchTemplate.queryForList(build, logindto.class);
        return  result;
    }

}

