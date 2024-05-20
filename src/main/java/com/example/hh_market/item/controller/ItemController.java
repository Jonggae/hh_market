package com.example.hh_market.item.controller;

import com.example.hh_market.item.dto.ItemDto;
import com.example.hh_market.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    //등록
    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto) {
        ItemDto addedItem = itemService.addItem(itemDto);
        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
    }
    // 전체 조회
    @GetMapping
    public ResponseEntity<List<ItemDto>> getItemList() {
        List<ItemDto> items = itemService.showAllItems();
        return ResponseEntity.ok(items);
    }

    //상세조회
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getInfoItem(@PathVariable Long id) {
        ItemDto item = itemService.showItemInfo(id);
        return ResponseEntity.ok(item);

    }
    @PutMapping("/{id}")
     public ResponseEntity<ItemDto> updateProduct(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        ItemDto updatedItem = itemService.updateItem(id, itemDto);
        return ResponseEntity.ok(updatedItem);
    }

    // 상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok("삭제 완료");
    }

}
