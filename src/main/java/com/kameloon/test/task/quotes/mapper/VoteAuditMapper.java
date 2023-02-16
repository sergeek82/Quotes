package com.kameloon.test.task.quotes.mapper;

import com.kameloon.test.task.quotes.dto.VoteAuditDto;
import com.kameloon.test.task.quotes.models.VoteAudit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoteAuditMapper {

    VoteAuditDto toDto(VoteAudit voteAudit);
    List<VoteAuditDto> toListDto(List<VoteAudit> voteAudits);
}
