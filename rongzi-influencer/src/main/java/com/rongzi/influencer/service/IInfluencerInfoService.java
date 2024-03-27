package com.rongzi.influencer.service;

import java.util.List;
import com.rongzi.influencer.domain.InfluencerInfo;

/**
 * 红人Service接口
 * 
 * @author rongzi
 * @date 2023-07-26
 */
public interface IInfluencerInfoService 
{
    /**
     * 查询红人
     * 
     * @param id 红人主键
     * @return 红人
     */
    public InfluencerInfo selectInfluencerInfoById(Long id);

    /**
     * 查询红人列表
     * 
     * @param influencerInfo 红人
     * @return 红人集合
     */
    public List<InfluencerInfo> selectInfluencerInfoList(InfluencerInfo influencerInfo);

    /**
     * 新增红人
     * 
     * @param influencerInfo 红人
     * @return 结果
     */
    public int insertInfluencerInfo(InfluencerInfo influencerInfo);

    /**
     * 修改红人
     * 
     * @param influencerInfo 红人
     * @return 结果
     */
    public int updateInfluencerInfo(InfluencerInfo influencerInfo);

    /**
     * 批量删除红人
     * 
     * @param ids 需要删除的红人主键集合
     * @return 结果
     */
    public int deleteInfluencerInfoByIds(Long[] ids);

    /**
     * 删除红人信息
     * 
     * @param id 红人主键
     * @return 结果
     */
    public int deleteInfluencerInfoById(Long id);
}