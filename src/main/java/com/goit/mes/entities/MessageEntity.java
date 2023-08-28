package com.goit.mes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Entity
@Table(name = "message")
@Getter
@Setter
@ToString
public class MessageEntity {
  @Id
  @GeneratedValue
  private Long id;
  private LocalDateTime initDate;
  private LocalDateTime updDate;
  private String text;
}
