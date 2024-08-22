package com.rongzi.government.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.government.domain.rzgovernmentspecialbonds;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 政府专项债Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-23
 */
public interface rzgovernmentspecialbondsMapper 
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
     * 删除政府专项债
     * 
     * @param id 政府专项债主键
     * @return 结果
     */
    public int deleterzgovernmentspecialbondsById(Long id);

    /**
     * 批量删除政府专项债
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzgovernmentspecialbondsByIds(Long[] ids);

    /**
     * 批量删除附件表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzsrc2ByScrUuids(Long[] ids);
    
    /**
     * 批量新增附件表
     * 
     * @param rzsrc2List 附件表列表
     * @return 结果
     */
    public int batchrzsrc2(List<rzsrc2> rzsrc2List);
    

    /**
     * 通过政府专项债主键删除附件表信息
     * 
     * @param id 政府专项债ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
