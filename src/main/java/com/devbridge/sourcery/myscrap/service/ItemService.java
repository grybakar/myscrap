package com.devbridge.sourcery.myscrap.service;

import com.devbridge.sourcery.myscrap.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

  private final ItemRepository itemRepository;

}
