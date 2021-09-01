package org.starcoin.stcpricereporter.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.starcoin.stcpricereporter.data.model.PriceFeed;
import org.starcoin.stcpricereporter.service.PriceFeedService;

import javax.annotation.Resource;

@Api(tags = {"Starcoin-Price-Reporter RESTful API"})
@RestController
@RequestMapping("v1")
public class StcPriceReporterController {

    @Resource
    private PriceFeedService priceFeedService;

    @GetMapping("priceFeeds/{pairId}")
    public PriceFeed getPriceFeed(@PathVariable("pairId") String pairId) {
        return priceFeedService.getPriceFeed(pairId);
    }

    @GetMapping("exchangeRates/ETH_STC")
    public @ResponseBody String getEthToStcExchangeRate() {
        return priceFeedService.getEthToStcExchangeRate().toString();
    }

    @GetMapping("exchangeRates/WEI_NANOSTC")
    public @ResponseBody String getWeiToNanoStcExchangeRate() {
        return priceFeedService.getWeiToNanoStcExchangeRate().toString();
    }

}
