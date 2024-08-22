package com.rongzi.government.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.government.domain.rzgovernmentspecialbonds;

/**
 * 政府政府专项债Service接口
 * 
 * @author rongzi
 * @date 2024-03-23
 */
public interface IrzgovernmentspecialbondsService 
{
    /**
     * 查询政府专项债
     * 
     * @param id 政府专项债主键
     * @return 政府专项债
     */
    public rzgovernmentspecialbonds selectrzgovernmentspecialbondsById(Long id);

    /**
     * 查询政府专项债列表
     * 
     * @param rzgovernmentspecialbonds 政府专项债
     * @return 政府专项债集合
     */
    public List<rzgovernmentspecialbonds> selectrzgovernmentspecialbondsList(rzgovernmentspecialbonds rzgovernmentspecialbonds);


    public Map<String, BigDecimal> selectrzgovernmentspecialbondsSum(rzgovernmentspecialbonds rzgovernmentspecialbonds);

    /**
     * 新增政府专项债
     * 
     * @param rzgovernmentspecialbonds 政府专项债
     * @return 结果
     */
    public int insertrzgovernmentspecialbonds(rzgovernmentspecialbonds rzgovernmentspecialbonds);

    /**
     * 修改政府专项债
     * 
     * @param rzgovernmentspecialbonds 政府专项债
     * @return 结果
     */
    public int updaterzgovernmentspecialbonds(rzgovernmentspecialbonds rzgovernmentspecialbonds);

    /**
     * 批量删除政府专项债
     * 
     * @param ids 需要删除的政府专项债主键集合
     * @return 结果
     */
    public int deleterzgovernmentspecialbondsByIds(Long[] ids);

    /**
     * 删除政府专项债信息
     * 
     * @param id 政府专项债主键
     * @return 结果
     */
    public int deleterzgovernmentspecialbondsById(Long id);
}
