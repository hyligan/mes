package com.goit.mes.controllers;

import com.goit.mes.entities.Worker;
import com.goit.mes.services.MessageService;
import com.goit.mes.services.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/worker", consumes = {MediaType.ALL_VALUE})
@Slf4j
public class WorkersController {
  private WorkerService workerService;
  
  public WorkersController(WorkerService workerService) {
    this.workerService = workerService;
  }

  @GetMapping
  public String getMessages(Model model){
    model.addAttribute("workerList", workerService.getAll());
    model.addAttribute("newWorker", new Worker());
    return "first/workers";
  }
  @GetMapping("/edit/{id}")
  public String editWorker(@PathVariable Long id, Model model) {
    Worker worker = workerService.findById(id);
    model.addAttribute("worker", worker);
    return "first/editPage";
  }
  @PostMapping("/create")
  public String createWorker(@ModelAttribute Worker newWorker) {
    // Add the new worker to your list of workers or save it to a database
    workerService.createWorker(newWorker);

    return "redirect:/worker"; // Redirect back to the worker list page
  }
  @PostMapping("/save/{id}")
  public String createWorker(@ModelAttribute Worker newWorker, @PathVariable("id") Long id) {
    // Add the new worker to your list of workers or save it to a database
    workerService.update(newWorker,id);

    return "redirect:/worker"; // Redirect back to the worker list page
  }
  
  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long id){
    workerService.delete(id);
    return "redirect:/worker";
  }
}
