package com.kameloon.test.task.quotes.controller;

import com.kameloon.test.task.quotes.dto.QuoteDto;
import com.kameloon.test.task.quotes.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService quoteServiceImpl;

    @PostMapping
    public ResponseEntity<QuoteDto> createQuote(@RequestBody @Validated QuoteDto quoteDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quoteServiceImpl.addQuote(quoteDto));
    }

    @GetMapping("/best")
    public ResponseEntity<List<QuoteDto>> getBest() {
        return ResponseEntity.ok(quoteServiceImpl.getTopAsc());
    }

    @GetMapping("/worst")
    public ResponseEntity<List<QuoteDto>> getWorst() {
        return ResponseEntity.ok(quoteServiceImpl.getTopDec());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteDto> getCertainQuote(@PathVariable Long id) {
        return ResponseEntity.ok(quoteServiceImpl.getQuote(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<QuoteDto> patchQuote(@RequestBody @Validated QuoteDto quoteDto, @PathVariable Long id) {
        return ResponseEntity.ok(quoteServiceImpl.updateQuote(quoteDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuoteDto> deleteQuote(@PathVariable Long id) {
        return ResponseEntity.ok(quoteServiceImpl.removeQuote(id));
    }
}
