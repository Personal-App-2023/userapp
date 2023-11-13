package com.doop.user.userapp.service;

import com.doop.user.userapp.entity.UserSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserSequenceGenerator {
    @Autowired
    private MongoOperations op;

    public int generateNextUserId()
    {
        //Criteria criteria = new Criteria("_id").is("sequence");
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("usersequence"));

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        options.upsert(true);

        UserSequence count=op.findAndModify(
                //new Query(criteria),
                query,
                new Update().inc("usernum",1),
                options,
                UserSequence.class
        );

        return count.getUsernum();
    }
}

