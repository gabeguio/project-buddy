package com.service.activity;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import com.service.activity.requests.GetMembersByProjectIdRequest;
import com.service.activity.results.GetMembersByProjectIdResult;
import com.service.converters.MemberModelConverter;
import com.service.dynamodb.MemberDao;
import com.service.dynamodb.UserDao;
import com.service.dynamodb.models.Member;
import com.service.dynamodb.models.User;
import com.service.models.MemberModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetMembersByProjectIdActivity {
    private final Logger log = LogManager.getLogger();
    private final MemberDao memberDao;
    private final UserDao userDao;

    /**
     * Instantiates a new GetMembersByProjectIdActivity object.
     *
     * @param memberDao MemberDao to access the members table.
     */
    @Inject
    public GetMembersByProjectIdActivity(MemberDao memberDao, UserDao userDao) {
        this.memberDao = memberDao;
        this.userDao = userDao;
    }

    /**
     * @param getMembersByProjectIdRequest request object containing the project ID
     * @return getMembersByProjectIdRequest result object containing the memberModel list of API defined {@link MemberModel}s
     */
    public GetMembersByProjectIdResult handleRequest(final GetMembersByProjectIdRequest getMembersByProjectIdRequest) {
        log.info("Received GetMembersByProjectIdRequest {}", getMembersByProjectIdRequest);
        MemberModelConverter memberModelConverter = new MemberModelConverter();

        List<Member> memberList = memberDao.getMembersByProjectId(getMembersByProjectIdRequest.getProjectId());
        List<User> userList = new ArrayList<>();
        for ( Member member : memberList ) {
            userList.add(userDao.getUser(member.getUserId()));
        }

        List<MemberModel> memberModelList = memberModelConverter.toMemberModelList(memberList, userList);

        return GetMembersByProjectIdResult.builder()
                .withMemberModelList(memberModelList)
                .build();
    }
}
