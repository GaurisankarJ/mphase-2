package com.mphase.stock.service.impl;

import com.mphase.stock.model.Stock;
import com.mphase.stock.repository.StockRepository;
import com.mphase.stock.service.StockService;
import com.mphase.stock.utility.StockUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public StockServiceImpl() {
    }

    @Override
    public List<Stock> findAllStocks(Integer page, Integer size, String fromDate, String toDate) {
        Pageable pageable = PageRequest.of(page, size);
        List<Stock> list = stockRepository.findAll(pageable).getContent();

        if (fromDate != null && toDate != null) {
            List<Stock> stocks = list.stream()
                    .filter(stock -> StockUtility.checkDateInRange(fromDate, toDate, stock.getDate()))
                    .collect(Collectors.toList());
            return stocks;
        }

        return list;
    }

    @Override
    public Stock updateStock(Stock stock) {
        Query query = new Query();
        query.addCriteria(Criteria.where("date").is(stock.getDate()));
        Update update = new Update();
        update.set("openPrice", stock.getOpenPrice());
        update.set("closePrice", stock.getClosePrice());
        update.set("highPrice", stock.getHighPrice());
        update.set("lowPrice", stock.getLowPrice());
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        return mongoTemplate.findAndModify(query, update, options, Stock.class);
    }
}
