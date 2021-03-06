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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MeetingList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2021-04-09T11:54:42.656Z")
public class MeetingList   {
  @JsonProperty("total")
  private Integer total = null;

  @JsonProperty("date")
  private List<Meeting> date = null;

  public MeetingList total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Movie list total items count
   * @return total
   **/
  @JsonProperty("total")
  @ApiModelProperty(required = true, value = "Movie list total items count")
  @NotNull
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public MeetingList date(List<Meeting> date) {
    this.date = date;
    return this;
  }

  public MeetingList addDateItem(Meeting dateItem) {
    if (this.date == null) {
      this.date = new ArrayList<Meeting>();
    }
    this.date.add(dateItem);
    return this;
  }

  /**
   * One pagination page data
   * @return date
   **/
  @JsonProperty("date")
  @ApiModelProperty(value = "One pagination page data")
  @Valid
  public List<Meeting> getDate() {
    return date;
  }

  public void setDate(List<Meeting> date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingList meetingList = (MeetingList) o;
    return Objects.equals(this.total, meetingList.total) &&
        Objects.equals(this.date, meetingList.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, date);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingList {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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

