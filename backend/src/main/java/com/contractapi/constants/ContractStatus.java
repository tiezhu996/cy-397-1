package com.contractapi.constants;

public enum ContractStatus {
  DRAFT("草稿"),
  PENDING_SIGN("待签署"),
  SIGNED("已签署"),
  EXPIRED("已过期");

  private final String display;
  ContractStatus(String display) { this.display = display; }
  public String getDisplay() { return display; }
}
