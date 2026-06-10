package com.contractapi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.contractapi.constants.ContractStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@TableName("contracts")
public class Contract {
  private Long id;
  private Long userId;
  private Long templateId;
  private String title;
  private String content;
  private String status;
  private String signers;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime signedAt;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime expireDate;

  private BigDecimal amount;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Long getUserId() { return userId; }
  public void setUserId(Long userId) { this.userId = userId; }
  public Long getTemplateId() { return templateId; }
  public void setTemplateId(Long templateId) { this.templateId = templateId; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public String getSigners() { return signers; }
  public void setSigners(String signers) { this.signers = signers; }
  public LocalDateTime getSignedAt() { return signedAt; }
  public void setSignedAt(LocalDateTime signedAt) { this.signedAt = signedAt; }
  public LocalDateTime getExpireDate() { return expireDate; }
  public void setExpireDate(LocalDateTime expireDate) { this.expireDate = expireDate; }
  public BigDecimal getAmount() {
    return amount != null ? amount.setScale(2, RoundingMode.HALF_UP) : null;
  }
  public void setAmount(BigDecimal amount) { this.amount = amount; }

  @JsonProperty("statusDisplay")
  public String getStatusDisplay() {
    try {
      return ContractStatus.valueOf(status).getDisplay();
    } catch (Exception e) {
      return status;
    }
  }
}
