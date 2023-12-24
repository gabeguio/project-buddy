package com.service.converters;

import java.util.ArrayList;
import java.util.List;

import com.service.dynamodb.models.Member;
import com.service.dynamodb.models.User;
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
    public MemberModel toMemberModel(Member member, User user) {
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
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withCompany(user.getCompany())
                .withEmail(user.getEmail())
                .build();
    }

    public List<MemberModel> toMemberModelList(List<Member> Members, List<User> Users) {
        List<MemberModel> memberModelList = new ArrayList<>();

        for (int i = 0; i < Members.size(); i++) {
            memberModelList.add(toMemberModel(Members.get(i), Users.get(i)));
        }

        return memberModelList;
    }
}
