package github.tiMorpheus.stock.bo.impl;

import github.tiMorpheus.stock.bo.AbstractDao;
import github.tiMorpheus.stock.bo.StockBo;
import github.tiMorpheus.stock.model.Stock;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("stockBo")
public class StockBoImpl extends AbstractDao implements StockBo {

    public void save(Stock stock) {
        persist(stock);
    }

    public void update(Stock stock) {
        getSession().update(stock);
    }

    public void delete(Stock stock) {
        Query query = getSession().createSQLQuery("delete from stock where stock_code = :stock_code");
        query.setString("stock_code", stock.getStockCode());
        query.executeUpdate();
    }

    public Stock findByStockCode(String s) {
        Criteria criteria = getSession().createCriteria(Stock.class);
        criteria.add(Restrictions.eq("stock_code", s));
        return (Stock) criteria.uniqueResult();
    }


}
