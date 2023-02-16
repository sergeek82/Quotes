package com.kameloon.test.task.quotes.controller;

import com.kameloon.test.task.quotes.dto.VoteAuditDto;
import com.kameloon.test.task.quotes.dto.VoteDto;
import com.kameloon.test.task.quotes.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vote")
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/{quoteId}")
    public ResponseEntity<VoteDto> up(@PathVariable Long quoteId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(voteService.upVote(quoteId));
    }

    @GetMapping("/{quoteId}/activity")
    public ResponseEntity<List<VoteAuditDto>> activity(@PathVariable Long quoteId) {
        return ResponseEntity.ok(voteService.getActivityById(quoteId));
    }

    @DeleteMapping("/{quoteId}")
    public ResponseEntity<VoteDto> down(@PathVariable Long quoteId) {
        return ResponseEntity.ok(voteService.downVote(quoteId));
    }
}
