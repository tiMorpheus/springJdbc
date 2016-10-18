package github.tiMorpheus.stock.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock", catalog = "springhibernate_db", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STOCK_NAME"),
        @UniqueConstraint(columnNames = "STOCK_CODE")})
public class Stock implements Serializable {

    private static final long serialVersionUID = -222095982513671708L;

    private Long stockId;
    private String stockCode;
    private String stockName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString() {
        return "Stock [stockCode=" + stockCode + ", stockId=" + stockId
                + ", stockName=" + stockName + "]";
    }
}

