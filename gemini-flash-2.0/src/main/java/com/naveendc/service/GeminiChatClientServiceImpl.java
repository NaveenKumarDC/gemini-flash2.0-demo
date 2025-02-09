package com.naveendc.service;

import com.naveendc.bean.President;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kumardc on 09/02/25
 */
@Service
public class GeminiChatClientServiceImpl implements GeminiChatClientService {


  private final ChatClient chatClient;

  public GeminiChatClientServiceImpl(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @Override
  public List<President> getListOfPresidents() {
    return chatClient.prompt()
            .user("List all of the indian presidents in history and return their name with their term in the years they held office.")
            .call()
            .entity(new ParameterizedTypeReference<List<President>>() {
            });
  }

}
