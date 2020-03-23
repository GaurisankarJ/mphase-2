package com.mphase.stock.controller;

import com.mongodb.DBCollection;
import com.mphase.stock.model.Stock;
import com.mphase.stock.service.StockService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;

@Api(value = "Manage stocks", tags = "Stocks", consumes = "application/json", produces = "application/json")
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @ApiOperation("Find Stock")
    @ApiResponses({
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/stock")
    public List<Stock> getAllStocks(
            @ApiParam(value = "Page number for pagination")
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @ApiParam(value = "The size of the page")
            @RequestParam(value = "size", defaultValue = "500") Integer size,
            @ApiParam(value = "Date from for pagination")
            @RequestParam(value = "min", required = false) String min,
            @ApiParam(value = "Date to of the page")
            @RequestParam(value = "max", required = false) String max
    ) {
        return stockService.findAllStocks(page, size, min, max);
    }

    @ApiOperation("Update Stock")
    @ApiResponses({
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PutMapping("/stock")
    public Stock updateStock(
            @RequestBody Stock stock
    ) {
        return stockService.updateStock(stock);
    }
}
