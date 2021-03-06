/*
 * Organiser Application API
 * Organiser application made for learning Java
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package pl.jacek.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * RegisterUserRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2021-04-09T11:54:42.656Z")
public class RegisterUserRequest   {
  @JsonProperty("nick_name")
  private String nickName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  public RegisterUserRequest nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * User nickname
   * @return nickName
   **/
  @JsonProperty("nick_name")
  @ApiModelProperty(value = "User nickname")
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public RegisterUserRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User email address
   * @return email
   **/
  @JsonProperty("email")
  @ApiModelProperty(required = true, value = "User email address")
  @NotNull
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public RegisterUserRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User password
   * @return password
   **/
  @JsonProperty("password")
  @ApiModelProperty(required = true, value = "User password")
  @NotNull
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterUserRequest registerUserRequest = (RegisterUserRequest) o;
    return Objects.equals(this.nickName, registerUserRequest.nickName) &&
        Objects.equals(this.email, registerUserRequest.email) &&
        Objects.equals(this.password, registerUserRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickName, email, password);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterUserRequest {\n");
    
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

