package com.lagou.service;


import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

import java.util.List;

public interface PromotionAdService {

    public PageInfo<PromotionAd> findAllPromotionAdService(PromotionAdVo promotionAdVo);

    public void savePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAd(PromotionAd promotionAd);

    public PromotionAd findPromotionAdById(int id);

    public void updatePromotionAdStatus(int id, int status);

}
