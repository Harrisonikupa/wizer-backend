package com.easynotes.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity //Used to mark the class as a persistence java class
@Table(name = "notes") //Used to provide the details of the table that this Entity is mapped to
@EntityListeners(AuditingEntityListener.class) //used to auto fill the createdAt and updatedAt fields
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true) //used to serialize and deserialize java objects from and to JSON

public class Note implements Serializable {
  @Id //Used to define the primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @NotBlank //Used to validate that the annotated field is not null or empty
  private String title;

  @NotBlank
  private String content;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP) //Used with java.util.Date and java.util.Calander classes
  @CreatedDate
  private Date createdAt;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;

  //Getters and Setters ... (Omitted for brevity)


}
