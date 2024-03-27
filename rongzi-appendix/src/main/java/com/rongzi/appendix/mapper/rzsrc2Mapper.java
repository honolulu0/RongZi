package com.rongzi.appendix.mapper;

import java.util.List;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 附件表Mapper接口
 * 
 * @author rongzi
 * @date 2024-02-08
 */
public interface rzsrc2Mapper 
{
    /**
     * 查询附件表
     * 
     * @param id 附件表主键
     * @return 附件表
     */
    public rzsrc2 selectrzsrc2ById(Long id);

    /**
     * 查询附件表列表
     * 
     * @param rzsrc2 附件表
     * @return 附件表集合
     */
    public List<rzsrc2> selectrzsrc2List(rzsrc2 rzsrc2);

    /**
     * 新增附件表
     * 
     * @param rzsrc2 附件表
     * @return 结果
     */
    public int insertrzsrc2(rzsrc2 rzsrc2);

    /**
     * 修改附件表
     * 
     * @param rzsrc2 附件表
     * @return 结果
     */
    public int updaterzsrc2(rzsrc2 rzsrc2);

    /**
     * 删除附件表
     * 
     * @param id 附件表主键
     * @return 结果
     */
    public int deleterzsrc2ById(Long id);

    /**
     * 批量删除附件表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzsrc2ByIds(Long[] ids);
}
