package com.service.dynamodb;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.service.dynamodb.models.User;

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

        if(User == null) {
            throw new RuntimeException("User not found for requested userId");
        }

        return User;
    }
}

