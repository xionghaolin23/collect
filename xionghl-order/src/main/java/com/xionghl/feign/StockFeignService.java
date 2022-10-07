package com.xionghl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author xionghaolin
 */
@FeignClient(name = "stock-service")
public interface StockFeignService {

    /**
     * 库存扣件
     * @return 扣件成功
     */
    @PostMapping(value = "stock/reduct")
    String reduct();

}

