package com.group3.issizsiniz.service.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserAddFavoriteRequests {
    private UserJobPostsRequests favorite;
}
