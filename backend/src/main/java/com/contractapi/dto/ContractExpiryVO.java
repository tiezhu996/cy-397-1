package com.contractapi.dto;

import com.contractapi.constants.ContractStatus;
import com.contractapi.entity.Contract;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public record ContractExpiryVO(Long id, Long userId, String title, String status,
                               @JsonProperty("statusDisplay") String statusDisplay,
                               BigDecimal amount,
                               @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime signedAt,
                               @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime expireDate,
                               long remainingDays) {
  public static ContractExpiryVO from(Contract contract, long remainingDays) {
    String display;
    try {
      display = ContractStatus.valueOf(contract.getStatus()).getDisplay();
    } catch (Exception e) {
      display = contract.getStatus();
    }
    BigDecimal amt = contract.getAmount() != null
      ? contract.getAmount().setScale(2, RoundingMode.HALF_UP)
      : null;
    return new ContractExpiryVO(
      contract.getId(),
      contract.getUserId(),
      contract.getTitle(),
      contract.getStatus(),
      display,
      amt,
      contract.getSignedAt(),
      contract.getExpireDate(),
      remainingDays
    );
  }
}
