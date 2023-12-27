package com.service.activity.results;

import java.util.ArrayList;
import java.util.List;

import com.service.models.MemberModel;

public class GetMembersResult {

    private final List<MemberModel> memberModelList;

    private GetMembersResult(List<MemberModel> memberModelList) {
        this.memberModelList = memberModelList;
    }

    public List<MemberModel> getMemberModelList() {
        return new ArrayList<>(memberModelList);
    }

    @Override
    public String toString() {
        return "GetMembersResult{" +
                "memberModelList=" + memberModelList +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<MemberModel> memberModelList;
        
        public Builder withMemberModelList(List<MemberModel> memberModelList) {
            this.memberModelList = new ArrayList<>(memberModelList);
            return this;
        }

        public GetMembersResult build() {
            return new GetMembersResult(memberModelList);
        }
    }


}
