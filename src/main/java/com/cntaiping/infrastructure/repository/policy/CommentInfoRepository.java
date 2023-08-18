package com.cntaiping.infrastructure.repository.policy;

import com.cntaiping.domain.policy.entity.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentInfoRepository extends JpaRepository<CommentInfo, UUID> {
}
