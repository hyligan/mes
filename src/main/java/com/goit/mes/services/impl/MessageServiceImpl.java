package com.goit.mes.services.impl;

import com.goit.mes.entities.MessageEntity;
import com.goit.mes.repo.MessageRepo;
import com.goit.mes.services.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class MessageServiceImpl implements MessageService {
  private MessageRepo messageRepo;

  public MessageServiceImpl(MessageRepo messageRepo) {
    this.messageRepo = messageRepo;
  }

  @Override
  public List<MessageEntity> getAll() {
    return messageRepo.findAll();
  }

  @Override
  public Optional<MessageEntity> getById(Long id) {
    return messageRepo.findById(id);
  }

  @Override
  public void save(String text) {
    MessageEntity entity = new MessageEntity();
    entity.setInitDate(LocalDateTime.now());
    entity.setText(text);
    messageRepo.save(entity);
  }

  @Override
  public void delete(Long id) {
    messageRepo.deleteById(id);
  }
}
