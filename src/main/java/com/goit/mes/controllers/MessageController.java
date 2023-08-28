package com.goit.mes.controllers;

import com.goit.mes.services.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/msg", consumes = {MediaType.ALL_VALUE})
@Slf4j
public class MessageController {
  private MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping
  public String getMessages(Model model){
    model.addAttribute("messages", messageService.getAll());
    return "first/message";
  }
  @RequestMapping(method = RequestMethod.POST, 
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = {
          MediaType.APPLICATION_ATOM_XML_VALUE,
          MediaType.APPLICATION_JSON_VALUE
      })
  public String saveMessage(@RequestParam Map<String, String> body, Model model){
    log.info("get message {}", body.get("message"));
    messageService.save(body.get("message"));
    return "redirect:/msg";
  }

  @RequestMapping(path = "/delete/{id}",method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
      produces = {
          MediaType.APPLICATION_ATOM_XML_VALUE,
          MediaType.APPLICATION_JSON_VALUE
      })
  public String delete(@PathVariable("id") Long id, @RequestParam Map<String, String> body, Model model){
    log.info("get {}", body);
    messageService.delete(id);
    return "redirect:/msg";
  }
  
}
