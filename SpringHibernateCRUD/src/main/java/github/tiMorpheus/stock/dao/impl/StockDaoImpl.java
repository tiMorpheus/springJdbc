package github.tiMorpheus.stock.dao.impl;

import github.tiMorpheus.util.CustomHibernateDaoSupport;

import java.util.*;

import github.tiMorpheus.stock.dao.StockDao;
import github.tiMorpheus.stock.model.Stock;
import org.springframework.stereotype.Repository;


@Repository("stockDao")
public class StockDaoImpl extends CustomHibernateDaoSupport implements StockDao{

    public void save(Stock stock) {
        getHibernateTemplate().save(stock);
    }

    public void update(Stock stock) {
        getHibernateTemplate().update(stock);
    }

    public void delete(Stock stock) {
        getHibernateTemplate().delete(stock);
    }

    public Stock findByStockCode(String stockCode) {
        List list = getHibernateTemplate().find(
                        "from Stock where stockCode=?",stockCode);

        return (Stock) list.get(0);
    }
}
