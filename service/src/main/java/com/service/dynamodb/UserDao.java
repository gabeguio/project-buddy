package com.service.dynamodb;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.service.dynamodb.models.Member;
import com.service.dynamodb.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public UserDao(DynamoDBMapper mapper) {
        this.dynamoDBMapper = mapper;
    }

    public User getUser(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("passed in userId is null");
        }

        User User = this.dynamoDBMapper.load(User.class, userId);

        if (User == null) {
            throw new RuntimeException("User not found for requested userId");
        }

        return User;
    }
}

