package com.example.contrl7.model;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Integer id;
    private Integer fromAccountId;
    private Integer toAccountId;
    private Double amount;
    private String currency;
    private LocalDateTime timestamp;
    private String status;
    private boolean rollback;
    private LocalDateTime rollbackDate;
}
