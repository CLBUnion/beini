package com.beini.gen_entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProductBrand {
	@Id
	@NotEmpty(message="商品品牌ID不能为空")
	private String pbUuid;

    private String imageUrl;
    @NotEmpty(message="品牌名称不能为空")
    private String name;

    private Integer orderIndex;

    private String pcUuid;

    private Integer status;

    public String getPbUuid() {
        return pbUuid;
    }

    public void setPbUuid(String pbUuid) {
        this.pbUuid = pbUuid == null ? null : pbUuid.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getPcUuid() {
        return pcUuid;
    }

    public void setPcUuid(String pcUuid) {
        this.pcUuid = pcUuid == null ? null : pcUuid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}