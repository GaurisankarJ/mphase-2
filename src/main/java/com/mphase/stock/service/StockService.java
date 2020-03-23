package com.mphase.stock.service;

import com.mphase.stock.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAllStocks(Integer page, Integer size, String fromDate, String toDate);
    Stock updateStock(Stock stock);
}
