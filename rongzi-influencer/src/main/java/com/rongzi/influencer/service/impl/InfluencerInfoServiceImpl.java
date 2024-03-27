package com.rongzi.influencer.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.influencer.mapper.InfluencerInfoMapper;
import com.rongzi.influencer.domain.InfluencerInfo;
import com.rongzi.influencer.service.IInfluencerInfoService;

/**
 * 红人Service业务层处理
 * 
 * @author rongzi
 * @date 2023-07-26
 */
@Service
public class InfluencerInfoServiceImpl implements IInfluencerInfoService 
{
    @Autowired
    private InfluencerInfoMapper influencerInfoMapper;

    /**
     * 查询红人
     * 
     * @param id 红人主键
     * @return 红人
     */
    @Override
    public InfluencerInfo selectInfluencerInfoById(Long id)
    {
        return influencerInfoMapper.selectInfluencerInfoById(id);
    }

    /**
     * 查询红人列表
     * 
     * @param influencerInfo 红人
     * @return 红人
     */
    @Override
    public List<InfluencerInfo> selectInfluencerInfoList(InfluencerInfo influencerInfo)
    {
        return influencerInfoMapper.selectInfluencerInfoList(influencerInfo);
    }

    /**
     * 新增红人
     * 
     * @param influencerInfo 红人
     * @return 结果
     */
    @Override
    public int insertInfluencerInfo(InfluencerInfo influencerInfo)
    {
        return influencerInfoMapper.insertInfluencerInfo(influencerInfo);
    }

    /**
     * 修改红人
     * 
     * @param influencerInfo 红人
     * @return 结果
     */
    @Override
    public int updateInfluencerInfo(InfluencerInfo influencerInfo)
    {
        influencerInfo.setUpdateTime(DateUtils.getNowDate());
        return influencerInfoMapper.updateInfluencerInfo(influencerInfo);
    }

    /**
     * 批量删除红人
     * 
     * @param ids 需要删除的红人主键
     * @return 结果
     */
    @Override
    public int deleteInfluencerInfoByIds(Long[] ids)
    {
        return influencerInfoMapper.deleteInfluencerInfoByIds(ids);
    }

    /**
     * 删除红人信息
     * 
     * @param id 红人主键
     * @return 结果
     */
    @Override
    public int deleteInfluencerInfoById(Long id)
    {
        return influencerInfoMapper.deleteInfluencerInfoById(id);
    }
}
