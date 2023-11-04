package com.service.activity.results;

import java.util.ArrayList;
import java.util.List;

import com.service.models.MemberModel;

public class GetMembersByProjectIdResult {

    private final List<MemberModel> memberModelList;

    private GetMembersByProjectIdResult(List<MemberModel> memberModelList) {
        this.memberModelList = memberModelList;
    }

    public List<MemberModel> getMemberModelList() {
        return new ArrayList<>(memberModelList);
    }

    @Override
    public String toString() {
        return "GetMembersByProjectIdResult{" +
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

        public GetMembersByProjectIdResult build() {
            return new GetMembersByProjectIdResult(memberModelList);
        }
    }


}
