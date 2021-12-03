package com.example.springcard.controller;


import com.example.springcard.payload.ApiResponse;
import com.example.springcard.payload.IncomeOutDto;
import com.example.springcard.projection.ProjectionInOut;
import com.example.springcard.repostory.CardRepostory;
import com.example.springcard.repostory.IncomeRepostory;
import com.example.springcard.repostory.OutcomeRepostory;
import com.example.springcard.security.JwtProvider;
import com.example.springcard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/card")
public class CardControl {
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    OutcomeRepostory outcomeRepostory;
    @Autowired
    IncomeRepostory incomeRepostory;
    @Autowired
    CardService cardService;
    @Autowired
    CardRepostory cardRepostory;

    @PostMapping
    public HttpEntity<?> add(HttpServletRequest httpRequest) {
        ApiResponse apiResponse = cardService.addCard(httpRequest);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> in_out(HttpServletRequest httpServletRequest, @RequestBody IncomeOutDto incomeDto) {
        ApiResponse apiResponse = cardService.in_outHistory(httpServletRequest, incomeDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/search")
    public HttpEntity<?> getByNumberIncome(@RequestParam String number) {
        List<ProjectionInOut> byToCard_number = incomeRepostory.findAllByToCard_Number(number);
        return ResponseEntity.ok(byToCard_number);

    }

    @GetMapping
    public HttpEntity<?> getByNumberOut(@RequestParam String number) {
        List<ProjectionInOut> allByToCard_number = outcomeRepostory.findAllByToCard_Number(number);
        return ResponseEntity.ok(allByToCard_number);

    }
}
