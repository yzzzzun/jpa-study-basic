/**
* FileName : Order.java
* Created  : 2021. 1. 17.
* Author   : youngjun.jin
* Summary  :
* Copyright (C) 2021 yzzzzun. All rights reserved.
*
* 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
* 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
*/
package jpql;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author youngjun.jin
 */
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	private int orderAmount;

	@Embedded
	private Address address;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	/**
	 * product를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return product
	 */
	public Product getProduct() {
		return this.product;
	}

	/**
	 * product 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param product 초기화 값
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * id를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * id 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param id 초기화 값
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * orderAmount를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return orderAmount
	 */
	public int getOrderAmount() {
		return this.orderAmount;
	}

	/**
	 * orderAmount 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param orderAmount 초기화 값
	 */
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * address를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return address
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * address 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param address 초기화 값
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
