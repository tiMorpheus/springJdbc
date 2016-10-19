package github.tiMorpheus.stock.model;


import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "stock_id")
    private long stockId;

    @Column(name = "stock_code", unique = true, nullable = false)
    private String stock_code;

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stock_code;
    }

    public void setStockCode(String stockCode) {
        this.stock_code = stockCode;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", stock_code='" + stock_code + '\'' +
                '}';
    }
}
