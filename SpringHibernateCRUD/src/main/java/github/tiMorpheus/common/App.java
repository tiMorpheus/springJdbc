package github.tiMorpheus.common;

import github.tiMorpheus.stock.dao.StockDao;
import github.tiMorpheus.stock.model.Stock;
import github.tiMorpheus.util.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StockDao stockDao = (StockDao) appContext.getBean("stockDaoBean");

        Stock stock = new Stock();
        stock.setStockId(1);
        stock.setStockCode("7668");

        stockDao.save(stock);

        Stock stock2 = stockDao.findByStockCode("7668");
        System.out.println(stock2);


        stockDao.delete(stock2);

        System.out.println("Done");
    }
}
