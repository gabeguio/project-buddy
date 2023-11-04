package com.service.dynamodb;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.service.dynamodb.models.Member;

@Singleton
public class MemberDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public MemberDao(DynamoDBMapper mapper) {
        this.dynamoDBMapper = mapper;
    }

    public Member getMember(String projectId, String userId) {

        if (projectId == null) {
            throw new IllegalArgumentException("passed in projectId is null");
        }
        if (userId == null) {
            throw new IllegalArgumentException("passed in userId is null");
        }

        Member member = this.dynamoDBMapper.load(Member.class, projectId, userId);

        if(member == null) {
            throw new RuntimeException("Member not found for requested projectId and userId");
        }

        return member;
    }

    public Member saveMember(Member member) {
        this.dynamoDBMapper.save(member);
        return member;
    }
    public void deletemember(Member member){
        this.dynamoDBMapper.delete(member);
    }

    public List<Member> getMembersByProjectId(String projectId) {

        if (projectId == null) {
            throw new IllegalArgumentException("passed in projectId is null");
        }
        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":projectId", new AttributeValue().withS(projectId));

        DynamoDBQueryExpression<Member> queryExpression = new DynamoDBQueryExpression<Member>()
                .withKeyConditionExpression("projectId = :projectId")
                .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Member> memberList = dynamoDBMapper.query(Member.class, queryExpression);

        if(memberList == null) {
            throw new RuntimeException("Members not found for requested projectId");
        }

        return memberList;
    }
}
