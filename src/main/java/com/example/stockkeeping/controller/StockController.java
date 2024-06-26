package com.example.stockkeeping.controller;

import com.example.stockkeeping.model.Stock;
import com.example.stockkeeping.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    // display a list of all items in stock
    @GetMapping
    public List<Stock> getStocks(){
        return stockService.findAllStock();
    }

    // display item by item code
    @GetMapping("/code/{itemCode}")
    public Stock getByItemCode(@PathVariable String itemCode){
        return stockService.findItemByCode(itemCode);
    }

    // add a new item to the stock
    @PostMapping("/new")
    public void newStock (@RequestBody Stock stock){
        stockService.saveStock(stock);
    }

    @PutMapping("/update/{itemCode}")
    public void updateStock(@PathVariable String itemCode, @RequestBody Stock stock){
        stockService.updateStock(itemCode, stock);
    }

    // delete items by item code
    @DeleteMapping("/delete/{itemCode}")
    public Iterable<Stock> deleteByItemCode(@PathVariable String itemCode){
        return stockService.deleteStockByItemCode(itemCode);
    }

    // delete all items in stock
    @DeleteMapping("/delete")
    public void deleteStocks(){
        stockService.deleteStocks();
        System.out.println("All stocks deleted");
    }

}
