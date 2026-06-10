package com.contractapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public record GenerateContractRequest(Long userId, Long templateId, String title, Map<String, String> variables, String format, BigDecimal amount, LocalDateTime expireDate) {}
