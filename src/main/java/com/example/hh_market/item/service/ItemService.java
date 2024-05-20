package com.example.hh_market.item.service;

import com.example.hh_market.item.dto.ItemDto;
import com.example.hh_market.item.entity.Item;
import com.example.hh_market.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*- 판매 게시글을 작성하는 API
- 판매 게시글을 상세 조회하는 API
- 판매 게시글을 전체 조회하는 API
- 판매 게시글을 수정하는 API
- 판매 게시글을 삭제하는 API*/
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    //판매글 작성
    public ItemDto addItem(ItemDto itemDto) {
        Item item = ItemDto.toEntity(itemDto);
        return ItemDto.from(itemRepository.save(item));

    }

    //전체조회
    public List<ItemDto> showAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(ItemDto::fromAll)
                .collect(Collectors.toList());
    }

    //상세조회
    public ItemDto showItemInfo(Long itemId) {
        return itemRepository.findById(itemId)
                .map(ItemDto::from)
                .orElseThrow();
    }

    //수정
    public ItemDto updateItem(Long itemId, ItemDto itemDto) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        item.updateFromDto(itemDto);
        return ItemDto.from(itemRepository.save(item));
    }

    //삭제
    public List<ItemDto> deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow();
        itemRepository.delete(item);
        return showAllItems();
    }

}
