package com.alinesno.infra.base.platform.entity;

import com.alinesno.infra.base.platform.enums.OwnerEnums;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

/**
 * 产品类型实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("product_type")
@Data
public class ProductTypeEntity extends InfraBaseEntity {

	/**
	 * 图标
	 */
	@TableField("icon")
	@ColumnType(length=255)
	@ColumnComment("图标")
	private String icon ;

	@TableField("code")
	@ColumnType(length=255)
	@ColumnComment("业务类型编码")
	private String code ;

	/**
	 * 名称
	 */
	@TableField("name")
	@ColumnType(length=255)
	@ColumnComment("名称")
	private String name;

	/**
	 * 产品类型描述
	 */
	@TableField("type_describe")
	@ColumnType(length=255)
	@ColumnComment("产品类型描述")
	private String typeDescribe;

	/**
	 * 排序
	 */
	@TableField("sort_number")
	@ColumnType(length=255)
	@ColumnComment("排序")
	private Integer sortNumber;



	/**
	 * 背景图
	 */
	@TableField("banner")
	@ColumnType(length=255)
	@ColumnComment("背景图")
	private String banner;

	/**
	 * 父类id
	 */
	@TableField("parent_id")
	@ColumnType(length=255)
	@ColumnComment("父类id")
	private Long parentId;

	/**
	 * 备注
	 */
	@TableField("remark")
	@ColumnType(length=255)
	@ColumnComment("备注")
	private String remark;

	@TableField("type_owner")
	@ColumnType(length=255)
	@ColumnComment("类型所有者")
	private String typeOwner = OwnerEnums.PLATFORM.getCode()  ; // 类型所有者

}
