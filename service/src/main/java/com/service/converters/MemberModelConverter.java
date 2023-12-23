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
        List<String> currentTasks = null;
        if (member.getCurrentTasks() != null) {
            currentTasks = new ArrayList<>(member.getCurrentTasks());
        }

        List<String> tasksCompleted = null;
        if (member.getTasksCompleted() != null) {
            tasksCompleted = new ArrayList<>(member.getTasksCompleted());
        }

        return MemberModel.builder()
                .withProjectId(member.getProjectId())
                .withUserId(member.getUserId())
                .withMemberId(member.getMemberId())
                .withDateJoined(member.getDateJoined())
                .withRole(member.getRole())
                .withCurrentTasks(currentTasks)
                .withTasksCompleted(tasksCompleted)
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
