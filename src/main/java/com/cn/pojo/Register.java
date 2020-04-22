package com.cn.pojo;

import org.hibernate.validator.constraints.NotBlank;

public class Register {
  private Integer id;
  @NotBlank(message = "电话号码不能为空")
  private String registerPhone;
  @NotBlank(message = "验证码不能为空")
  private String registerCode;

  public Register() {
  }



  public Register(String registerPhone, String registerCode) {
    this.registerPhone = registerPhone;
    this.registerCode = registerCode;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRegisterPhone() {
    return registerPhone;
  }

  public void setRegisterPhone(String registerPhone) {
    this.registerPhone = registerPhone;
  }

  public String getRegisterCode() {
    return registerCode;
  }

  public void setRegisterCode(String registerCode) {
    this.registerCode = registerCode;
  }
}
