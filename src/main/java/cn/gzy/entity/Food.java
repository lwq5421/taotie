package cn.gzy.entity;

import java.math.BigDecimal;

public record Food(
                   Integer foodId,
                   String foodName,
                   String foodType,
                   String foodDesc,
                   BigDecimal foodPrice,
                   String foodAvatar){}