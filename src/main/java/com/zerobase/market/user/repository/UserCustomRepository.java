package com.zerobase.market.user.repository;

import com.zerobase.market.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserCustomRepository {
    Boolean findAdminByRole(Long userId);

}
