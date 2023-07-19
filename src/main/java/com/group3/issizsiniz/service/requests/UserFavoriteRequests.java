package com.group3.issizsiniz.service.requests;

import com.group3.issizsiniz.entity.JobPosts;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserFavoriteRequests {
    private JobPostsRequests favorite;
}
