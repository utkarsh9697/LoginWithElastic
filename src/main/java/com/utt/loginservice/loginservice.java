package com.utt.loginservice;

import com.utt.dto.logindto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface loginservice {

     Optional dosomething(logindto logindto);

    Optional getone(String id);

    Iterable<logindto> getall();

    List<logindto> elasticquery(String text);
}
