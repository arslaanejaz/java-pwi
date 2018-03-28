package com.pwi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="inventory")
public class Inventory {

	//reverse
	@ManyToOne
	private Brand brand;
	

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	//reverse
    @ManyToOne(fetch = FetchType.EAGER)
    private Warehouse warehouse;
    
    public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Item name cannot be empty")
	@Size(min=1, max=30)
	@Column(name = "item", unique=false, nullable = false)
	private String item;
	
	@NotEmpty(message = "Item tpye cannot be empty")
	@Size(min=1, max=30)
	@Column(name = "type", unique=false, nullable = false)
	private String type;
	
	@NotEmpty(message = "Size cannot be empty")
	@Column(name = "size", unique=false, nullable = false)
	private Integer size;
	
	@NotEmpty(message = "Unit name cannot be empty")
	@Size(min=1, max=10)
	@Column(name = "unit", unique=false, nullable = false)
	private String unit;
	
	@Column(name = "in_stock", unique=false, nullable = false)
	private Integer in_stock;
	
	@Column(name = "avl_qty", unique=false, nullable = false)
	private Integer avl_qty;
	
	@Column(name = "in_transit", unique=false, nullable = false)
	private Integer in_transit;
	
	@Column(name = "moq", unique=false, nullable = false)
	private Integer moq;
	
	@Column(name = "qpb", unique=false, nullable = false)
	private Integer qpb;
	
	@Column(name = "reorder_point", unique=false, nullable = false)
	private Integer reorder_point;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getIn_stock() {
		return in_stock;
	}

	public void setIn_stock(Integer in_stock) {
		this.in_stock = in_stock;
	}

	public Integer getAvl_qty() {
		return avl_qty;
	}

	public void setAvl_qty(Integer avl_qty) {
		this.avl_qty = avl_qty;
	}

	public Integer getIn_transit() {
		return in_transit;
	}

	public void setIn_transit(Integer in_transit) {
		this.in_transit = in_transit;
	}

	public Integer getMoq() {
		return moq;
	}

	public void setMoq(Integer moq) {
		this.moq = moq;
	}

	public Integer getQpb() {
		return qpb;
	}

	public void setQpb(Integer qpb) {
		this.qpb = qpb;
	}

	public Integer getReorder_point() {
		return reorder_point;
	}

	public void setReorder_point(Integer reorder_point) {
		this.reorder_point = reorder_point;
	}
   
	


}
