package com.lagou.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findAllPromotionAdService(PromotionAdVo promotionAdVo) {
        PageHelper.startPage(promotionAdVo.getCurrentPage(),promotionAdVo.getPageSize());
        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();

        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);

        return pageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {

        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        promotionAd.setUpdateTime(new Date());
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(int id) {
        PromotionAd promotionAdById = promotionAdMapper.findPromotionAdById(id);
        return promotionAdById;
    }

    @Override
    public void updatePromotionAdStatus(int id, int status) {
        PromotionAd promotionAd = new PromotionAd();
        Date date = new Date();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(date);

        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
