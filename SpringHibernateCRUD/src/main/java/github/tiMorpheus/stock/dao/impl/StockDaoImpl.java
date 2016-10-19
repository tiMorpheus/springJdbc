package github.tiMorpheus.stock.dao.impl;

import github.tiMorpheus.stock.bo.StockBo;
import github.tiMorpheus.stock.dao.StockDao;
import github.tiMorpheus.stock.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("stockDaoBean")
@Transactional
public class StockDaoImpl implements StockDao{

    @Autowired
    private StockBo stockBo;

    public void save(Stock stock) {
        stockBo.save(stock);
    }

    public void update(Stock stock) {
        stockBo.update(stock);
    }

    public void delete(Stock stock) {
        stockBo.delete(stock);
    }

    public Stock findByStockCode(String s) {
        return stockBo.findByStockCode(s);
    }

}
