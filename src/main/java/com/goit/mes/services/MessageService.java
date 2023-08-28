package com.goit.mes.services;

import com.goit.mes.entities.MessageEntity;

import java.util.List;
import java.util.Optional;

public interface MessageService {
  List<MessageEntity> getAll();
  Optional<MessageEntity> getById(Long id);
  
  void save(String text);

  void delete(Long id);
}
