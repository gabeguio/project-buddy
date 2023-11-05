package com.service.converters;

import java.util.ArrayList;
import java.util.List;

import com.service.dynamodb.models.Member;
import com.service.models.MemberModel;

public class MemberModelConverter {
    /**
     * Converts between Data and API models.
     */
    /**
     * Converts a provided {@link Member} into a {@link MemberModel} representation.
     *
     * @param member the member to convert
     * @return the converted member
     */
    public MemberModel toMemberModel(Member member) {

        return MemberModel.builder()
                .withProjectId(member.getProjectId())
                .withUserId(member.getUserId())
                .withFirstName(member.getFirstName())
                .withLastName(member.getLastName())
                .withRole(member.getRole())
                .withCompany(member.getCompany())
                .withEmail(member.getEmail())
                .build();
    }

    public List<MemberModel> toMemberModelList(List<Member> Members) {
        List<MemberModel> memberModelList = new ArrayList<>();

        for (Member Member : Members) {
            memberModelList.add(toMemberModel(Member));
        }

        return memberModelList;
    }
}
