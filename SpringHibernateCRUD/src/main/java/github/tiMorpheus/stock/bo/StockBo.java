package github.tiMorpheus.stock.bo;

import github.tiMorpheus.stock.model.Stock;

public interface StockBo {

    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findByStockCode(String s);
}
