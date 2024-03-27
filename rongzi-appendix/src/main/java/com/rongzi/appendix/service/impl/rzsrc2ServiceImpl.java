package com.rongzi.appendix.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.appendix.mapper.rzsrc2Mapper;
import com.rongzi.appendix.domain.rzsrc2;
import com.rongzi.appendix.service.Irzsrc2Service;

/**
 * 附件表Service业务层处理
 * 
 * @author rongzi
 * @date 2024-02-08
 */
@Service
public class rzsrc2ServiceImpl implements Irzsrc2Service 
{
    @Autowired
    private rzsrc2Mapper rzsrc2Mapper;

    /**
     * 查询附件表
     * 
     * @param id 附件表主键
     * @return 附件表
     */
    @Override
    public rzsrc2 selectrzsrc2ById(Long id)
    {
        return rzsrc2Mapper.selectrzsrc2ById(id);
    }

    /**
     * 查询附件表列表
     * 
     * @param rzsrc2 附件表
     * @return 附件表
     */
    @Override
    public List<rzsrc2> selectrzsrc2List(rzsrc2 rzsrc2)
    {
        return rzsrc2Mapper.selectrzsrc2List(rzsrc2);
    }

    /**
     * 新增附件表
     * 
     * @param rzsrc2 附件表
     * @return 结果
     */
    @Override
    public int insertrzsrc2(rzsrc2 rzsrc2)
    {
        rzsrc2.setCreateTime(DateUtils.getNowDate());
        return rzsrc2Mapper.insertrzsrc2(rzsrc2);
    }

    /**
     * 修改附件表
     * 
     * @param rzsrc2 附件表
     * @return 结果
     */
    @Override
    public int updaterzsrc2(rzsrc2 rzsrc2)
    {
        return rzsrc2Mapper.updaterzsrc2(rzsrc2);
    }

    /**
     * 批量删除附件表
     * 
     * @param ids 需要删除的附件表主键
     * @return 结果
     */
    @Override
    public int deleterzsrc2ByIds(Long[] ids)
    {
        return rzsrc2Mapper.deleterzsrc2ByIds(ids);
    }

    /**
     * 删除附件表信息
     * 
     * @param id 附件表主键
     * @return 结果
     */
    @Override
    public int deleterzsrc2ById(Long id)
    {
        return rzsrc2Mapper.deleterzsrc2ById(id);
    }
}
