package com.service.activity;

import javax.inject.Inject;
import java.util.List;

import com.service.activity.requests.GetMembersByProjectIdRequest;
import com.service.activity.results.GetMembersByProjectIdResult;
import com.service.converters.MemberModelConverter;
import com.service.dynamodb.MemberDao;
import com.service.dynamodb.models.Member;
import com.service.models.MemberModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetMembersByProjectIdActivity {
    private final Logger log = LogManager.getLogger();
    private final MemberDao memberDao;

    /**
     * Instantiates a new GetMembersByProjectIdActivity object.
     *
     * @param memberDao MemberDao to access the members table.
     */
    @Inject
    public GetMembersByProjectIdActivity(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    /**
     * @param getMembersByProjectIdRequest request object containing the project ID
     * @return getMembersByProjectIdRequest result object containing the memberModel list of API defined {@link MemberModel}s
     */
    public GetMembersByProjectIdResult handleRequest(final GetMembersByProjectIdRequest getMembersByProjectIdRequest) {
        log.info("Received GetMembersByProjectIdRequest {}", getMembersByProjectIdRequest);
        MemberModelConverter memberModelConverter = new MemberModelConverter();

        List<Member> memberList = memberDao.getMembersByProjectId(getMembersByProjectIdRequest.getProjectId());
        List<MemberModel> memberModelList = memberModelConverter.toMemberModelList(memberList);

        return GetMembersByProjectIdResult.builder()
                .withMemberModelList(memberModelList)
                .build();
    }
}
