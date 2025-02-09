package com.naveendc.controllers;

import com.naveendc.bean.President;
import com.naveendc.service.GeminiChatClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

  @Autowired
  private GeminiChatClientService geminiChatClientService;

  @GetMapping("/presidents")
  public List<President> listPresidents() {
    return geminiChatClientService.getListOfPresidents();
  }

}
