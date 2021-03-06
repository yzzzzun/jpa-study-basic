/**
* FileName : Product.java
* Created  : 2021. 1. 17.
* Author   : youngjun.jin
* Summary  :
* Copyright (C) 2021 yzzzzun. All rights reserved.
*
* 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
* 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
*/
package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author youngjun.jin
 */
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private int price;

	private int stockAmount;

	/**
	 * name를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * name 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param name 초기화 값
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * price를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * price 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param price 초기화 값
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * stockAmount를 반환합니다.
	 * 
	 * @author youngjun.jin
	 * @return stockAmount
	 */
	public int getStockAmount() {
		return this.stockAmount;
	}

	/**
	 * stockAmount 초기화 합니다.
	 * 
	 * @author youngjun.jin
	 * @param stockAmount 초기화 값
	 */
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
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
}
