package com.sunil.esociety_1.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@ToString
public class MonthYear {
    @Column(value = "amount")
    private double month_amount;
    @Column(value = "amount")
    private double year_amount;

    public MonthYear(double month_amount, double year_amount) {
        this.month_amount = month_amount;
        this.year_amount = year_amount;
    }
}
